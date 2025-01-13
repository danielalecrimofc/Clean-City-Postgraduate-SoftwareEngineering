package br.com.clean_city.model;

import br.com.clean_city.model.enums.RolesEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @ElementCollection(targetClass = RolesEnum.class)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_login_id"))
    @Enumerated(EnumType.STRING)
    private Set<RolesEnum> roles = Set.of(RolesEnum.USER);

}