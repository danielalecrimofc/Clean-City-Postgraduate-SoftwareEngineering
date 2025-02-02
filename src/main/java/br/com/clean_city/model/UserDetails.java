package br.com.clean_city.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "user_details")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDetails {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
    private String cpf;
    private String phone;

    @OneToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "user_login_id")
    @ToString.Exclude
    private User user;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Address address;

}