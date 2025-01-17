package br.com.clean_city.service.impl;

import br.com.clean_city.model.Action;
import br.com.clean_city.model.Donation;
import br.com.clean_city.model.dto.donation.DonationRequestDTO;
import br.com.clean_city.model.dto.donation.DonationResponseDTO;
import br.com.clean_city.repository.ActionRepository;
import br.com.clean_city.repository.DonationRepository;
import br.com.clean_city.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public DonationResponseDTO createDonation(DonationRequestDTO donationRequestDTO) {
        Donation donation = new Donation();
        // map fields from donationRequestDTO to donation
        donation.setName(donationRequestDTO.getName());
        donation.setCpf(donationRequestDTO.getCpf());
        donation.setValue(donationRequestDTO.getValue());
        donation.setDate(donationRequestDTO.getDate());
        donation.setTelephone(donationRequestDTO.getTelephone());
        donation.setEmail(donationRequestDTO.getEmail());
        donation.setIdTransaction(donationRequestDTO.getIdTransaction());
        if (donationRequestDTO.getActionId() != null) {
            Action action = actionRepository.findById(donationRequestDTO.getActionId()).orElseThrow(() -> new RuntimeException("Action not found"));
            donation.setAction(action);
        }
        donation = donationRepository.save(donation);
        return new DonationResponseDTO(donation);
    }

    @Override
    public List<DonationResponseDTO> getAllDonations() {
        return donationRepository.findAll().stream().map(DonationResponseDTO::new).collect(Collectors.toList());
    }

}