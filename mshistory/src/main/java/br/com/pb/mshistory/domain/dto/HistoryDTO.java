package br.com.pb.mshistory.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class HistoryDTO   {

    private Long idOrder;
    private String sku;
    private BigDecimal total;
    private LocalDate date;

}
