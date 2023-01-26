package br.com.pb.compass.msorder.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class ItemDTO {

    private Long id;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private BigDecimal value;
    private String description;
}
