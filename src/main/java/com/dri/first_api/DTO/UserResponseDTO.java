package com.dri.first_api.DTO;

import com.dri.first_api.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private String name;
    private String email;
    private String type;

    public UserResponseDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.type = user.getType();
    }
}
