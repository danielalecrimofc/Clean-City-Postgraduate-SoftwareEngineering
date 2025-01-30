package br.com.clean_city.model.dto.user;

import br.com.clean_city.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private Long id;
    private String cep;
    private String address;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.cep = address.getCep();
        this.address = address.getAddress();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
    }
}