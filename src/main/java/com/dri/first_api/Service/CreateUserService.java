package com.dri.first_api.Service;

import com.dri.first_api.DTO.CreateUserDTO;
import com.dri.first_api.Entity.User;
import com.dri.first_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserDTO createUserDTO) {

        if (userRepository.existsByEmail(createUserDTO.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        user.setType(createUserDTO.getType());

        return userRepository.save(user);
    }

}
