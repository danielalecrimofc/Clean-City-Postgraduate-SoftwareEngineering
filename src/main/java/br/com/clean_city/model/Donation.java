package br.com.clean_city.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "donation")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private Double value;
    private LocalDateTime date;
    private String telephone;
    private String email;
    private String idTransaction;

    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;

}
