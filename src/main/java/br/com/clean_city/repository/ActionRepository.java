package br.com.clean_city.repository;

import br.com.clean_city.model.Action;
import br.com.clean_city.model.dto.action.ActionResponseDTO;
import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {

    List<Action> findByActive(Boolean active);

}
