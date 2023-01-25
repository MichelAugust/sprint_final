package br.com.pb.compass.msorder.domain.dto;

import br.com.pb.compass.msorder.domain.dto.request.AddressRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
public class OrderDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("items")
    @ManyToOne
    private List<ItemDTO> items;
    @JsonProperty("total")
    private Double amount;
    @JsonProperty("endereco")
    @OneToOne
    private AddressDTO addressDTO;

}
