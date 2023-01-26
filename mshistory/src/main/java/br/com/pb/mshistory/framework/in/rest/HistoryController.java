package br.com.pb.mshistory.framework.in.rest;

import br.com.pb.mshistory.application.service.HistoryService;
import br.com.pb.mshistory.domain.dto.HistoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {

    private final HistoryService service;

    @GetMapping()
    public ResponseEntity<List<HistoryDTO>> getAllDate
            (@RequestParam(required = false, name = "inicio") LocalDate start,
             @RequestParam(required = false, name = "fim") LocalDate date) {
        List<HistoryDTO> responsePage = service.verify(start, date);

        return ResponseEntity.status(HttpStatus.OK).body(responsePage);
    }
}