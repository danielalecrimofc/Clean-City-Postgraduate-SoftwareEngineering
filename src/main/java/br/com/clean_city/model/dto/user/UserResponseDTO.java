package br.com.clean_city.model.dto.user;

import br.com.clean_city.model.User;
import br.com.clean_city.model.enums.RolesEnum;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseDTO {

    private Long id;
    private String username;
    private Set<RolesEnum> roles;
    private UserDetailsDTO userDetails;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.userDetails = new UserDetailsDTO(user.getUserDetails());
    }
}