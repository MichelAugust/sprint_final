package br.com.pb.compass.msorder.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ItemRequest {

    @JsonProperty("nome")
    private String name;
    @Positive
    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("descricao")
    private String description;
    @Future
    @JsonProperty("data_de_validade")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime expirationDate;
}

