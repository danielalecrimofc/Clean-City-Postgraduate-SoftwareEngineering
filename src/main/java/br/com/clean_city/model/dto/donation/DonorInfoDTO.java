package br.com.clean_city.model.dto.donation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class DonorInfoDTO {
    private String name;
    private Double value;
    private LocalDateTime date;
}