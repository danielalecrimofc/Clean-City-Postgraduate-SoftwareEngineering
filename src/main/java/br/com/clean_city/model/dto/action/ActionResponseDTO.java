package br.com.clean_city.model.dto.action;

import br.com.clean_city.model.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionResponseDTO {
    private Long id;
    private String name;
    private String description;
    private byte[] image;
    private LocalDateTime date;
    private Long userId;

    public ActionResponseDTO(Action action) {
        this.id = action.getId();
        this.name = action.getName();
        this.description = action.getDescription();
        this.image = action.getImage();
        this.date = action.getDate();
        this.userId = action.getUser() != null ? action.getUser().getId() : null;
    }
}