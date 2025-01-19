package br.com.clean_city.model.dto.donation;

import br.com.clean_city.model.Donation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DonationResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double value;
    private LocalDateTime date;
    private String telephone;
    private String email;
    private String idTransaction;
    private Long actionId;

    public DonationResponseDTO(Donation donation) {
        this.id = donation.getId();
        this.name = donation.getName();
        this.cpf = donation.getCpf();
        this.value = donation.getValue();
        this.date = donation.getDate();
        this.telephone = donation.getTelephone();
        this.email = donation.getEmail();
        this.idTransaction = donation.getIdTransaction();
        this.actionId = donation.getAction() != null ? donation.getAction().getId() : null;
    }
}