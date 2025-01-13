package br.com.clean_city.service;

import br.com.clean_city.model.dto.ViaCepDTO;

public interface ViaCepService {
    ViaCepDTO obterEnderecoPorCep(String cep);
}
