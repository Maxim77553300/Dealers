package com.leverx.dealers.service;

import com.leverx.dealers.dto.AddUserRequest;
import com.leverx.dealers.dto.AdminResponseDto;
import com.leverx.dealers.email.EmailService;
import com.leverx.dealers.entity.Role;
import com.leverx.dealers.entity.User;
import com.leverx.dealers.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND = "User not Found";
    private static final String LOCALHOST_URL = "localhost:8080";
    private static final String MESSAGE = "Please wait, the administrator is checking the data and go to the address localhost:8080/auth/register , to complete the registration ";

    private static final Map<UUID, User> AWAITING_MAP = new HashMap<>();

    private final UserRepository userRepository;
    private final EmailService emailService;

    AdminResponseDto adminResponseDto = new AdminResponseDto();

    public UserServiceImpl(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Override
    public void registration(AddUserRequest addUserRequest) throws RuntimeException {
        User user = createUser(addUserRequest);
        UUID uuidUser = UUID.randomUUID();
        UUID uuidAdmin = UUID.randomUUID();
        // тут должен был быть redis c ttl 24 часа)

        if (userRepository.findUserByEmail(addUserRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Error! This email is exist!! Please enter another email");
        }
        String link = LOCALHOST_URL + "/auth/confirm/" + uuidUser.toString();
        AWAITING_MAP.put(uuidUser, user);
        String linkForAdmin = LOCALHOST_URL + "/auth/confirm/admin/" + uuidAdmin.toString();

        sendRequestToAdmin(addUserRequest, linkForAdmin, uuidAdmin); // send letter to admin--
        if (adminResponseDto.getAdminResponse() == 1) {
            emailService.sendEmail(addUserRequest.getEmail(), link);

        }
        if (adminResponseDto.getAdminResponse() == 0) {
            emailService.sendEmail(addUserRequest.getEmail(), MESSAGE);
        }
        adminResponseDto.setAdminResponse(0);

    }

    @Override
    public void confirm(String code) {
        UUID uuid = UUID.fromString(code);
        User user = AWAITING_MAP.get(uuid);
        if (user != null) {
            userRepository.save(user);
            AWAITING_MAP.remove(uuid);
        }
    }

    @Override
    public void forgotPassword(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(RuntimeException::new);
        UUID uuid = UUID.randomUUID();
        AWAITING_MAP.put(uuid, user);
        String link = LOCALHOST_URL + "/auth/check_code/" + uuid.toString();
        emailService.sendEmail(user.getEmail(), link);
    }

    @Override
    public boolean checkCode(String code) {
        return AWAITING_MAP.containsKey(UUID.fromString(code));
    }

    @Override
    public void reset(String code, String password) {
        UUID key = UUID.fromString(code);
        User userFromMap = AWAITING_MAP.get(key);
        if (userFromMap == null) {
            throw new RuntimeException("Как нету?!");
        }
        User actualUser = userRepository.findById(userFromMap.getId())
                .orElseThrow(RuntimeException::new);
        actualUser.setPassword(password);
        userRepository.save(actualUser);
        AWAITING_MAP.remove(key);
    }

    private void sendRequestToAdmin(AddUserRequest addUserRequest, String linkForAdmin, UUID uuid1) {

        User admin = userRepository.getById(1);
        emailService.sendEmail(admin.getEmail(), addUserRequest.toString());
        emailService.sendEmail(admin.getEmail(), linkForAdmin);

        AWAITING_MAP.put(uuid1, admin);
    }

    @Override
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
        user.setRole(Role.ANONYMOUS);
        return user;
    }
}
