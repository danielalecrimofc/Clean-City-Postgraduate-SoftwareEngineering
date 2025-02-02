package br.com.clean_city.resource;

import br.com.clean_city.model.dto.action.ActionRequestDTO;
import br.com.clean_city.model.dto.action.ActionResponseDTO;
import br.com.clean_city.model.dto.donation.DonorInfoDTO;
import br.com.clean_city.service.ActionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actions")
@Tag(name = "Action", description = "The Action API")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @Operation(summary = "Create action", description = "Create action")
    @PostMapping
    public ResponseEntity<ActionResponseDTO> createAction(@RequestBody ActionRequestDTO actionRequestDTO) {
        ActionResponseDTO createdAction = actionService.createAction(actionRequestDTO);
        return ResponseEntity.ok(createdAction);
    }

    @Operation(summary = "Get action by id", description = "Get action by id")
    @GetMapping("/{id}")
    public ResponseEntity<ActionResponseDTO> getActionById(@PathVariable Long id) {
        ActionResponseDTO actionResponseDTO = actionService.getActionById(id);
        return ResponseEntity.ok(actionResponseDTO);
    }

    @Operation(summary = "Get all actions", description = "Get all actions")
    @GetMapping
    public ResponseEntity<List<ActionResponseDTO>> getAllActions(@RequestParam(required = false) Boolean active) {
        List<ActionResponseDTO> actions = actionService.getAllActions(active);
        return ResponseEntity.ok(actions);
    }

    @Operation(summary = "Update action", description = "Update action")
    @PutMapping("/{id}")
    public ResponseEntity<ActionResponseDTO> updateAction(@PathVariable Long id, @RequestBody ActionRequestDTO actionRequestDTO) {
        ActionResponseDTO updatedAction = actionService.updateAction(id, actionRequestDTO);
        return ResponseEntity.ok(updatedAction);
    }

    @Operation(summary = "Enable/Disable action", description = "Enable/Disable action")
    @PutMapping("/{id}/enable")
    public ResponseEntity<ActionResponseDTO> enableAction(@PathVariable Long id, @RequestParam Boolean enable) {
        ActionResponseDTO updatedAction = actionService.enableAction(id, enable);
        return ResponseEntity.ok(updatedAction);
    }

    @Operation(summary = "Delete action", description = "Delete action")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Link user to action", description = "Link user to action")
    @PostMapping("/{actionId}/users/{userId}")
    public ResponseEntity<ActionResponseDTO> linkUserToAction(@PathVariable Long actionId, @PathVariable Long userId) {
        ActionResponseDTO actionResponseDTO = actionService.linkUserToAction(actionId, userId);
        return ResponseEntity.ok(actionResponseDTO);
    }

    @Operation(summary = "Get total donations by action id", description = "Get total donations by action id")
    @GetMapping("/{id}/total-donations")
    public ResponseEntity<Double> getTotalDonationsByActionId(@PathVariable Long id) {
        Double totalDonations = actionService.getTotalDonationsByActionId(id);
        return ResponseEntity.ok(totalDonations);
    }

    @Operation(summary = "Get donor info by action id", description = "Get donor info by action id")
    @GetMapping("/{id}/donor-info")
    public ResponseEntity<List<DonorInfoDTO>> getDonorInfoByActionId(@PathVariable Long id) {
        List<DonorInfoDTO> donorInfo = actionService.getDonorInfoByActionId(id);
        return ResponseEntity.ok(donorInfo);
    }

}