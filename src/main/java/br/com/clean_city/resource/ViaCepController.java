package br.com.clean_city.resource;

import br.com.clean_city.model.dto.ViaCepDTO;
import br.com.clean_city.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/cep")
public class ViaCepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepDTO> buscarEndereco(@PathVariable String cep) {

        return ResponseEntity.ok().body(viaCepService.obterEnderecoPorCep(cep));
    }

}
