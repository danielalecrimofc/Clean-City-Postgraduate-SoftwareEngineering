package br.com.clean_city.service.impl;

import br.com.clean_city.client.ViaCepClient;
import br.com.clean_city.model.dto.ViaCepDTO;
import br.com.clean_city.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepServiceImpl implements CepService {

    @Autowired
    private ViaCepClient viaCepClient;

    @Override
    public ViaCepDTO getAddressByCep(String cep) {
        return viaCepClient.getAddressByCep(cep);
    }
}
