package br.com.clean_city.resource;

import br.com.clean_city.model.dto.ViaCepDTO;
import br.com.clean_city.service.CepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/cep")
@Tag(name = "Cep", description = "Cep API")
public class CepController {

    @Autowired
    private CepService cepService;

    @Operation(summary = "Get address by CEP", description = "Get address by CEP")
    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepDTO> buscarEndereco(@PathVariable String cep) {

        return ResponseEntity.ok().body(cepService.getAddressByCep(cep));
    }

}
