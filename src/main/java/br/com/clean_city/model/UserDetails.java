package br.com.clean_city.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "user_details")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String cpf;
    private String phone;

    @OneToOne
    @JoinColumn(name = "user_login_id")
    @ToString.Exclude
    private User user;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Address address;

}