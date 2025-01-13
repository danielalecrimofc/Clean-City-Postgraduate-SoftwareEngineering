package br.com.clean_city.service.impl;

import br.com.clean_city.client.ViaCepClient;
import br.com.clean_city.model.dto.ViaCepDTO;
import br.com.clean_city.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaCepServiceImpl implements ViaCepService {

    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public ViaCepDTO obterEnderecoPorCep(String cep) {
        return viaCepClient.buscarEnderecoPorCep(cep);
    }
}
