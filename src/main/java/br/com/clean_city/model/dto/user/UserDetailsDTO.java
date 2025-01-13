package br.com.clean_city.model.dto.user;

import br.com.clean_city.model.UserDetails;
import lombok.Data;

@Data
public class UserDetailsDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String cpf;
    private String phone;
    private AddressDTO address;

    public UserDetailsDTO(UserDetails userDetails) {
        this.id = userDetails.getId();
        this.firstName = userDetails.getFirstName();
        this.lastName = userDetails.getLastName();
        this.email = userDetails.getEmail();
        this.birthDate = userDetails.getBirthDate();
        this.cpf = userDetails.getCpf();
        this.phone = userDetails.getPhone();
        this.address = new AddressDTO(userDetails.getAddress());
    }
}