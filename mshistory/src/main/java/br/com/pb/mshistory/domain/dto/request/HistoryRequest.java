package br.com.pb.mshistory.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryRequest {

    private Long id;
    private BigDecimal amount;
    private LocalDate date;
}
