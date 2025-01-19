package br.com.clean_city.model.dto.action;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionRequestDTO {
    private String name;
    private String description;
    private byte[] image;
    private LocalDateTime date;
    private Long userId;
}