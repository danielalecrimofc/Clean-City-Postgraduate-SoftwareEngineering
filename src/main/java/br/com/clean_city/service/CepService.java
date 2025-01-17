package br.com.clean_city.service;

import br.com.clean_city.model.dto.ViaCepDTO;

public interface CepService {
    ViaCepDTO getAddressByCep(String cep);
}
