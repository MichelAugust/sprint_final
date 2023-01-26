package br.com.pb.compass.msorder.framework.adapter.in.rest;

import br.com.pb.compass.msorder.domain.dto.ItemDTO;
import br.com.pb.compass.msorder.domain.dto.request.ItemRequest;
import br.com.pb.compass.msorder.application.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService service;

    @PatchMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItems(@PathVariable Long id, @RequestBody ItemRequest request) {
        return ResponseEntity.ok(service.updateItemById(id, request));
    }

}
