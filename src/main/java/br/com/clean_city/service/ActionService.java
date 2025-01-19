package br.com.clean_city.service;

import br.com.clean_city.model.dto.action.ActionRequestDTO;
import br.com.clean_city.model.dto.action.ActionResponseDTO;
import br.com.clean_city.model.dto.donation.DonorInfoDTO;

import java.util.List;

public interface ActionService {

    ActionResponseDTO createAction(ActionRequestDTO actionRequestDTO);
    ActionResponseDTO getActionById(Long id);
    List<ActionResponseDTO> getAllActions();
    ActionResponseDTO updateAction(Long id, ActionRequestDTO actionRequestDTO);
    void deleteAction(Long id);
    ActionResponseDTO linkUserToAction(Long actionId, Long userId);
    Double getTotalDonationsByActionId(Long actionId);
    List<DonorInfoDTO> getDonorInfoByActionId(Long actionId);

}