package br.com.clean_city.resource;

import br.com.clean_city.model.dto.auth.AuthResponseDTO;
import br.com.clean_city.model.record.AuthRequest;
import br.com.clean_city.security.JwtUtil;
import br.com.clean_city.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "Authentication API")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Operation(summary = "Authenticate user", description = "Authenticate user and return JWT token")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.username());
        final String jwt = jwtUtil.generateToken(userDetails);

        var user = userService.getUserByUsername(authRequest.username());
        AuthResponseDTO authResponseDTO = new AuthResponseDTO(user.getId(), user.getUserDetails().getFirstName(), user.getUsername(), user.getRoles(), jwt);

        return ResponseEntity.ok(authResponseDTO);
    }
}