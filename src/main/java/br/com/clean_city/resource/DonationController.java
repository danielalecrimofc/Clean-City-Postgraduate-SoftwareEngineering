package br.com.clean_city.resource;

import br.com.clean_city.model.dto.donation.DonationRequestDTO;
import br.com.clean_city.model.dto.donation.DonationResponseDTO;
import br.com.clean_city.service.DonationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/donations")
@Tag(name = "Donation", description = "The Donation API")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @Operation(summary = "Create donation", description = "Create donation")
    @PostMapping
    public ResponseEntity<DonationResponseDTO> createDonation(@RequestBody DonationRequestDTO donationRequestDTO) {
        DonationResponseDTO createdDonation = donationService.createDonation(donationRequestDTO);
        return ResponseEntity.ok(createdDonation);
    }

    @Operation(summary = "Get all donations", description = "Get all donations")
    @GetMapping
    public ResponseEntity<List<DonationResponseDTO>> getAllDonations() {
        List<DonationResponseDTO> donations = donationService.getAllDonations();
        return ResponseEntity.ok(donations);
    }

}