package com.dri.first_api.Controller;

import com.dri.first_api.DTO.CreateUserDTO;
import com.dri.first_api.DTO.UserResponseDTO;
import com.dri.first_api.Entity.User;
import com.dri.first_api.Service.CreateUserService;

import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/create")
public class CreateUserController {

    private final CreateUserService createUserService;

    @Autowired
    public CreateUserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }


    @PostMapping("/users/create")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        User createUser = createUserService.createUser(createUserDTO);
        UserResponseDTO userResponseDTO = new UserResponseDTO(createUser);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

}
