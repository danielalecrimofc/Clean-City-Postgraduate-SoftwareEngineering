package br.com.clean_city.model.dto.auth;

import br.com.clean_city.model.enums.RolesEnum;
import lombok.Data;

import java.util.Set;

@Data
public class AuthResponseDTO {

    private Long id;
    private String username;
    private Set<RolesEnum> roles;
    private String token;

    public AuthResponseDTO(Long id, String username, Set<RolesEnum> roles, String token) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.token = token;
    }
}