package br.com.pb.compass.msorder.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class AddressRequest {

    private String cep;

    private String number;


}
