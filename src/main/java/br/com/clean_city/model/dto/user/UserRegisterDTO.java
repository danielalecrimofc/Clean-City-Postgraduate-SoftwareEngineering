package br.com.clean_city.model.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String cep;
    private String cpf;
    private String phone;
    private String password;
    private String passwordConfirmation;

    private String address;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;

}
