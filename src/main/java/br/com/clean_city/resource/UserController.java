package br.com.clean_city.resource;

import br.com.clean_city.model.dto.user.UserRegisterDTO;
import br.com.clean_city.model.dto.user.UserResponseDTO;
import br.com.clean_city.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User", description = "User API")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Create user", description = "Create user")
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRegisterDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @Operation(summary = "Get user by id", description = "Get user by id")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO userResponseDTO = userService.getUserById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @Operation(summary = "Get all users", description = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Update user", description = "Update user")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRegisterDTO userRegisterDTO) {
        UserResponseDTO userResponseDTO = userService.updateUser(id, userRegisterDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @Operation(summary = "Delete user", description = "Delete user")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}