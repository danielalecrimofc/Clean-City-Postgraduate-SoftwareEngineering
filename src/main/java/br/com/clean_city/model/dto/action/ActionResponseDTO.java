package br.com.clean_city.model.dto.action;

import br.com.clean_city.model.Action;
import br.com.clean_city.model.dto.user.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private LocalDateTime date;
    private Long userId;
    private AddressDTO address;
    private Boolean active;

    public ActionResponseDTO of(Action action) {
        return ActionResponseDTO.builder()
            .id(action.getId())
            .name(action.getName())
            .description(action.getDescription())
            .image(action.getImage())
            .date(action.getDate())
            .active(action.getActive())
            .userId(action.getUser() != null ? action.getUser().getId() : null)
            .address(action.getAddress() != null ? new AddressDTO(action.getAddress()) : null)
            .build();
    }

    public List<ActionResponseDTO> of(List<Action> actions) {
        return actions.stream().map(this::of).collect(Collectors.toList());
    }

}