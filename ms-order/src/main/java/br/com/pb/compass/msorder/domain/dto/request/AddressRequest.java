package br.com.pb.compass.msorder.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;



@Data
public class AddressRequest {

    @JsonProperty("cep")
    @Pattern(regexp = "^\\d{11}$",message = "deve ter apenas numeros")
    private String cep;

    @JsonProperty("numero")
    @Pattern(regexp = "^\\d{11}$",message = "deve ter apenas numeros")
    private String number;


}
