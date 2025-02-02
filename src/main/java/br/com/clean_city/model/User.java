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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserDetails userDetails;

    @Enumerated(EnumType.STRING)
    private Set<RolesEnum> roles;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<Action> actions;

}