package com.dri.first_api.Service;

import com.dri.first_api.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> getUserById(String id);
    List<User> getAllUsers();
    void deleteUser(String id);
    // void updateUser(String id, UpdateUserDTO updateUserDTO);
}
