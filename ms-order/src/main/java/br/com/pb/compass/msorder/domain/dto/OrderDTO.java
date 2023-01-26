package br.com.pb.compass.msorder.domain.dto;

import br.com.pb.compass.msorder.domain.dto.request.AddressRequest;
import br.com.pb.compass.msorder.domain.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private String cpf;
    private List<ItemDTO> items;
    private Double amount;
    private Address address;
}
