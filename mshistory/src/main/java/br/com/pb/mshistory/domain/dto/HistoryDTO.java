package br.com.pb.mshistory.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDTO   {

    private Long idOrder;
    private String sku;
    private BigDecimal total;
    private LocalDate date;

}
