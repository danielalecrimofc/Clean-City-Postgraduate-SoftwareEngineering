package br.com.clean_city.model.dto.donation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationRequestDTO {
    private String name;
    private String cpf;
    private Double value;
    private LocalDateTime date;
    private String telephone;
    private String email;
    private String idTransaction;
    private Long actionId;
}