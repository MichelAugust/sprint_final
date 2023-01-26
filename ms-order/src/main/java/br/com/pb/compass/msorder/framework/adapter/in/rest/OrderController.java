package br.com.pb.compass.msorder.framework.adapter.in.rest;

import br.com.pb.compass.msorder.application.service.OrderService;
import br.com.pb.compass.msorder.domain.dto.OrderDTO;
import br.com.pb.compass.msorder.domain.dto.request.OrderRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class OrderController {
    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> createNewOrder(@RequestBody @Valid OrderRequest orderRequest) {
        OrderDTO response = service.saveNewOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrderns(@RequestParam(required = false) String sort,
                                                        @RequestParam(required = false) String cpf) {
        return (cpf == null || cpf.isBlank())
                ? ResponseEntity.ok(service.getAll(sort))
                : ResponseEntity.ok(service.getAllByCpf(sort, cpf));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrderInformation
            (@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        return ResponseEntity.ok(service.updateOrderInformation(id, orderRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }


}

