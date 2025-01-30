package br.com.clean_city.model;

import br.com.clean_city.model.enums.RolesEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Table(name = "user_login")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserDetails userDetails;

    @Enumerated(EnumType.STRING)
    private Set<RolesEnum> roles;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Action> actions;

}