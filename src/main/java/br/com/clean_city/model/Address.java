package br.com.clean_city.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table(name = "address")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String cep;
    private String address;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @OneToOne(mappedBy = "address")
    @ToString.Exclude
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Action action;

}