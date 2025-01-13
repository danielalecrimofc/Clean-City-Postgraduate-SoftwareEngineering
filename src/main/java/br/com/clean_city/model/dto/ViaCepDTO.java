package br.com.clean_city.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepDTO {

    @JsonAlias("cep")
    private String cep;

    @JsonAlias("logradouro")
    private String street;

    @JsonAlias("complemento")
    private String complement;

    @JsonAlias("bairro")
    private String neighborhood;

    @JsonAlias("localidade")
    private String city;

    @JsonAlias("uf")
    private String state;
}
