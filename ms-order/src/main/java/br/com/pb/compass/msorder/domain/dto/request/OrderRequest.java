package br.com.pb.compass.msorder.domain.dto.request;

import br.com.pb.compass.msorder.domain.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Data
public class OrderRequest {
    @NotBlank
    @Pattern(regexp = "^\\d{11}$", message = "deve ter apenas 11 numeros")
    @JsonProperty("cpf")
    @CPF
    private String cpf;
    @Valid
    @NotNull
    @Size(min = 1)
    @JsonProperty("items")
    private List<ItemRequest> items;

    @NotNull
    @Positive
    @JsonProperty("total")
    private Double amount;

    @NotNull
    @JsonProperty("endereco")
    private Address address;

    public void setAddress() {
    }
}

