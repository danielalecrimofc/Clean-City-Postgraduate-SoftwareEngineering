package br.com.clean_city.repository;

import br.com.clean_city.model.Donation;
import br.com.clean_city.model.dto.donation.DonorInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Query("SELECT SUM(d.value) FROM Donation d WHERE d.action.id = :actionId")
    Double findTotalDonationsByActionId(Long actionId);

    @Query("SELECT new br.com.clean_city.model.dto.donation.DonorInfoDTO(d.name, d.value, d.date) FROM Donation d WHERE d.action.id = :actionId")
    List<DonorInfoDTO> findDonorInfoByActionId(Long actionId);
}