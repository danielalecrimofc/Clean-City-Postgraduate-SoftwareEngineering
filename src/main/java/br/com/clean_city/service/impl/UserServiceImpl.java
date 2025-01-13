package br.com.clean_city.service.impl;

import br.com.clean_city.model.Address;
import br.com.clean_city.model.User;
import br.com.clean_city.model.UserDetails;
import br.com.clean_city.model.dto.user.UserRegisterDTO;
import br.com.clean_city.model.dto.user.UserResponseDTO;
import br.com.clean_city.repository.UserRepository;
import br.com.clean_city.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRegisterDTO userRegisterDTO) {
        Address address = Address.builder()
                .cep(userRegisterDTO.getCep())
                .address(userRegisterDTO.getAddress())
                .complement(userRegisterDTO.getComplement())
                .neighborhood(userRegisterDTO.getNeighborhood())
                .city(userRegisterDTO.getCity())
                .state(userRegisterDTO.getState())
                .country(userRegisterDTO.getCountry())
                .build();

        UserDetails userDetails = UserDetails.builder()
                .firstName(userRegisterDTO.getFirstName())
                .lastName(userRegisterDTO.getLastName())
                .email(userRegisterDTO.getEmail())
                .birthDate(userRegisterDTO.getBirthDate())
                .cpf(userRegisterDTO.getCpf())
                .phone(userRegisterDTO.getPhone())
                .address(address)
                .build();

        User user = User.builder()
                .username(userRegisterDTO.getEmail())
                .userDetails(userDetails)
                .build();

        userRepository.save(user);
        return new UserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRegisterDTO userRegisterDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        Address address = user.getUserDetails().getAddress();
        address.setCep(userRegisterDTO.getCep());
        address.setAddress(userRegisterDTO.getAddress());
        address.setComplement(userRegisterDTO.getComplement());
        address.setNeighborhood(userRegisterDTO.getNeighborhood());
        address.setCity(userRegisterDTO.getCity());
        address.setState(userRegisterDTO.getState());
        address.setCountry(userRegisterDTO.getCountry());

        UserDetails userDetails = user.getUserDetails();
        userDetails.setFirstName(userRegisterDTO.getFirstName());
        userDetails.setLastName(userRegisterDTO.getLastName());
        userDetails.setEmail(userRegisterDTO.getEmail());
        userDetails.setBirthDate(userRegisterDTO.getBirthDate());
        userDetails.setCpf(userRegisterDTO.getCpf());
        userDetails.setPhone(userRegisterDTO.getPhone());
        userDetails.setAddress(address);

        user.setUsername(userRegisterDTO.getEmail());
        user.setUserDetails(userDetails);

        userRepository.save(user);
        return new UserResponseDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails
    convertToUserDetails(User user) {
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}