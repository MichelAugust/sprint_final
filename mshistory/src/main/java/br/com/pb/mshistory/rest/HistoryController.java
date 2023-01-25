package br.com.pb.mshistory.rest;

import br.com.pb.mshistory.domain.dto.HistoryDTO;
import br.com.pb.mshistory.service.HistoryService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Order")
@OpenAPIDefinition(
        info = @Info(
                title = "MS Order",
                description = "Microserviço de gerenciamento de pedidos",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8081/api/pedidos"
        )
)
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