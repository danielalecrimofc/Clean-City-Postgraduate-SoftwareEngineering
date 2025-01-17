package br.com.clean_city.service;

import br.com.clean_city.model.dto.donation.DonationRequestDTO;
import br.com.clean_city.model.dto.donation.DonationResponseDTO;

import java.util.List;

public interface DonationService {
    DonationResponseDTO createDonation(DonationRequestDTO donationRequestDTO);
    List<DonationResponseDTO> getAllDonations();

}