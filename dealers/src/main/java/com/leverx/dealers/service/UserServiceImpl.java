package com.leverx.dealers.service;


import com.leverx.dealers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private static final String USER_NOT_FOUND = "User not Found";


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findUserByFirstName(firstName).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
    }
}
