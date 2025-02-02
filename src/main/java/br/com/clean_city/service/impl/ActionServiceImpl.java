package br.com.clean_city.service.impl;

import br.com.clean_city.model.Action;
import br.com.clean_city.model.Address;
import br.com.clean_city.model.User;
import br.com.clean_city.model.dto.action.ActionRequestDTO;
import br.com.clean_city.model.dto.action.ActionResponseDTO;
import br.com.clean_city.model.dto.donation.DonorInfoDTO;
import br.com.clean_city.model.dto.user.AddressDTO;
import br.com.clean_city.repository.ActionRepository;
import br.com.clean_city.repository.AddressRepository;
import br.com.clean_city.repository.DonationRepository;
import br.com.clean_city.repository.UserRepository;
import br.com.clean_city.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public ActionResponseDTO createAction(ActionRequestDTO actionRequestDTO) {

        Action action = new Action();
        action.setName(actionRequestDTO.getName());
        action.setDescription(actionRequestDTO.getDescription());
        action.setImage(actionRequestDTO.getImage());
        action.setDate(actionRequestDTO.getDate());
        action.setActive(false);
        if (actionRequestDTO.getUserId() != null) {
            User user = userRepository.findById(actionRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            action.setUser(user);
        }

        Address address = new Address();
        AddressDTO addressDTO = actionRequestDTO.getAddress();
        if (addressDTO != null) {
            address.setAddress(addressDTO.getAddress());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setCep(addressDTO.getCep());
            address.setCountry(addressDTO.getCountry());
            action.setAddress(address);
        }

        action = actionRepository.save(action);
        return new ActionResponseDTO().of(action);
    }

    @Override
    public ActionResponseDTO getActionById(Long id) {
        Action action = actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));
        Address address = addressRepository.findById(action.getAddress().getId()).orElseThrow(() -> new RuntimeException("Address not found"));
        action.setAddress(address);
        System.out.println("action: " + action);
        return new ActionResponseDTO().of(action);
    }


    @Override
    public List<ActionResponseDTO> getAllActions(Boolean active) {
        List<Action> actions;
        if (active != null) {
            actions = actionRepository.findByActive(active);
        } else {
            actions = actionRepository.findAll();
        }
        return actions.stream()
                      .map(action -> new ActionResponseDTO().of(action))
                      .collect(Collectors.toList());
    }

    @Override
    public ActionResponseDTO updateAction(Long id, ActionRequestDTO actionRequestDTO) {
        Action action = actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));
        // update fields from actionRequestDTO to action
        action.setName(actionRequestDTO.getName());
        action.setDescription(actionRequestDTO.getDescription());
        action.setImage(actionRequestDTO.getImage());
        action.setDate(actionRequestDTO.getDate());
        if (actionRequestDTO.getUserId() != null) {
            User user = userRepository.findById(actionRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
            action.setUser(user);
        }
        Address address = action.getAddress();
        AddressDTO addressDTO = actionRequestDTO.getAddress();
        if (addressDTO != null) {
            address.setAddress(addressDTO.getAddress());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setCep(addressDTO.getCep());
            address.setCountry(addressDTO.getCountry());
        }
        action.setAddress(address);
        action = actionRepository.save(action);
        return new ActionResponseDTO().of(action);
    }

    @Override
    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }

    @Override
    public ActionResponseDTO linkUserToAction(Long actionId, Long userId) {
        Action action = actionRepository.findById(actionId).orElseThrow(() -> new RuntimeException("Action not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        action.setUser(user);
        action = actionRepository.save(action);
        return new ActionResponseDTO().of(action);
    }

    @Override
    public Double getTotalDonationsByActionId(Long actionId) {
        return donationRepository.findTotalDonationsByActionId(actionId);
    }

    @Override
    public List<DonorInfoDTO> getDonorInfoByActionId(Long actionId) {
        return donationRepository.findDonorInfoByActionId(actionId);
    }

    @Override
    public ActionResponseDTO enableAction(Long id, Boolean enable){
        Action action = actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));
        action.setActive(enable);
        return new ActionResponseDTO().of(actionRepository.save(action));
    }
}