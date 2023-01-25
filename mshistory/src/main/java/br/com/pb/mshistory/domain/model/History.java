package br.com.pb.mshistory.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    private String sku;
    private Long idOrder;
    private BigDecimal amount;
    private LocalDate date;


}
