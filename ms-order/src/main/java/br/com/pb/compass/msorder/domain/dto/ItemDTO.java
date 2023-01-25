package br.com.pb.compass.msorder.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ItemDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("data_de_criacao")
    private LocalDateTime creationDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("data_de_validade")
    private LocalDateTime expirationDate;
    @JsonProperty("valor")
    private BigDecimal value;
    @JsonProperty("descricao")
    private String description;
}
