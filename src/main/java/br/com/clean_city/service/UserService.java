package br.com.clean_city.service;

import br.com.clean_city.model.dto.user.UserRegisterDTO;
import br.com.clean_city.model.dto.user.UserResponseDTO;
import br.com.clean_city.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

public interface UserService {

    UserResponseDTO createUser(UserRegisterDTO userRegisterDTO);
    UserResponseDTO getUserById(Long id);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO updateUser(Long id, UserRegisterDTO userRegisterDTO);
    void deleteUser(Long id);
    User getUserByUsername(String username);
    UserDetails convertToUserDetails(User user);
    UserResponseDTO addRolesToUser(Long id, Set<String> roles);
    UserResponseDTO removeRolesFromUser(Long id, Set<String> roles);
}