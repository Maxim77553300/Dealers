package com.leverx.dealers.service;


import com.leverx.dealers.config.MyConfig;
import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.entity.User;
import com.leverx.dealers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND = "User not Found";

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        //???
        return (UserDetails) userRepository.findUserByFirstName(firstName).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
    }

    @Override
    public void addUser(AddUserRequest addUserRequest) {
        User user = new User();
        user.setFirstName(addUserRequest.getFirst_name());
        user.setLastName(addUserRequest.getLast_name());
        user.setPassword(addUserRequest.getPassword());
        user.setEmail(addUserRequest.getEmail());

        userRepository.save(user);
    }

//    @Override
//    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
//        //???
//        return (UserDetails) userRepository.findUserByFirstName(firstName).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
//    }

    ////////---------------------------------------------
    static final Map<UUID, AddUserRequest> awaitingRegistration = new HashSet<>();

    @Autowired
    private MyConfig myConfig;

    @Override
    public String registration(AddUserRequest addUserRequest) {
        UUID uuid = UUID.randomUUID();
        awaitingRegistration.put(uuid, addUserRequest);
        return myConfig.getHostName + "user/registration/" + uuid.toString();
    }

    @Override
    public boolean continueRegistration(String registrationUuid) {
        UUID uuid = UUID.fromString(registrationUuid);
        AddUserRequest addUserRequest = awaitingRegistration.get(uuid);
        if (addUserRequest != null) {
            continueRegistration(addUserRequest);
            awaitingRegistration.remove(uuid);
            return true;
        }
        return false;
    }

    private void sendRequestToAdmin(AddUserRequest addUserRequest, String linkForAdmin, UUID uuid1) {

        User admin = userRepository.getById(1);
        emailService.sendEmail(admin.getEmail(), addUserRequest.toString());
        emailService.sendEmail(admin.getEmail(), linkForAdmin);
        AWAITING_MAP.put(uuid1, admin);
    }

    public AdminResponseDto confirmForAdmin(String code) {
        UUID uuid = UUID.fromString(code);
        User admin = AWAITING_MAP.get(uuid);
        if (admin != null) {
            AWAITING_MAP.remove(uuid);
            adminResponseDto.setAdminResponse(1);
            return adminResponseDto;
        }
        return adminResponseDto;
    }


    private User createUser(AddUserRequest addUserRequest) {
        User user = new User();
        user.setFirstName(addUserRequest.getFirst_name());
        user.setLastName(addUserRequest.getLast_name());
        user.setPassword(addUserRequest.getPassword());
        user.setEmail(addUserRequest.getEmail());
        user.setRole(addUserRequest.getRole());
        userRepository.save(user);

    }
}
