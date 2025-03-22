package com.dri.first_api.CreateUserControlletTest;

import com.dri.first_api.Controller.CreateUserController;
import com.dri.first_api.DTO.CreateUserDTO;
import com.dri.first_api.DTO.UserResponseDTO;
import com.dri.first_api.Entity.User;
import com.dri.first_api.Service.CreateUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(MockitoExtension.class)
public class CreateUserControllerTest {

    @Mock
    private CreateUserService createUserService;

    @InjectMocks
    private CreateUserController createUserController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(createUserController).build();
    }

    @Test
    public void testCreateUser() throws Exception {
        // Arrange
        CreateUserDTO createUserDTO = new CreateUserDTO("John", "john@example.com", "ADMIN");

        // O serviço cria o usuário com os dados do DTO
        User user = new User(1L, "John", "john@example.com", "ADMIN");

        // Configura o mock para retornar o usuário criado
        when(createUserService.createUser(any(CreateUserDTO.class))).thenReturn(user);

        // Espera a resposta com o DTO de resposta e status CREATED
        UserResponseDTO userResponseDTO = new UserResponseDTO(user);

        // Act & Assert
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createUserDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(userResponseDTO)));

        // Verifica que o serviço foi chamado exatamente uma vez
        verify(createUserService, times(1)).createUser(any(CreateUserDTO.class));
    }
}
