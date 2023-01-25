package br.com.pb.compass.msorder.rest;

import br.com.pb.compass.msorder.domain.dto.OrderDTO;
import br.com.pb.compass.msorder.domain.dto.request.AddressRequest;
import br.com.pb.compass.msorder.domain.dto.request.OrderRequest;
import br.com.pb.compass.msorder.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class OrderController {
    private final OrderService service;

    @PostMapping
    public ResponseEntity<OrderDTO> createNewOrder(@RequestBody @Valid OrderRequest orderRequest) throws IOException {
        OrderDTO response = service.saveNewOrder(orderRequest);

        AddressRequest addressRequest = new AddressRequest();
        URL url = new URL("viacep.com.br/ws/"+ addressRequest.getCep()+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String cep;
        StringBuilder jsonCep = new StringBuilder();

        while ((cep = br.readLine()) != null){
            jsonCep.append(cep);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrderns(@RequestParam(required = false) String sort,
                                                        @RequestParam(required = false) String cpf) {
        return (cpf == null || cpf.isBlank())
                ? ResponseEntity.ok(service.getAll(sort, "12345678933"))
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

