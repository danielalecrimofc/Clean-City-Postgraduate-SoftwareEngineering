package br.com.clean_city.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}