package br.com.pb.compass.msorder.framework.helper.util;

import br.com.pb.compass.msorder.domain.dto.request.ItemRequest;
import br.com.pb.compass.msorder.domain.dto.request.OrderRequest;
import br.com.pb.compass.msorder.domain.model.Address;
import br.com.pb.compass.msorder.domain.model.Item;
import br.com.pb.compass.msorder.domain.model.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Component
public class MappersUtils {

    public Order orderRequestToEntity(OrderRequest request) {
        Order entity = new Order();
        entity.setAmount(BigDecimal.valueOf(request.getAmount()));
        entity.setCpf(request.getCpf());
        entity.setAddress(new Address());
        entity.setItems(!request.getItems().isEmpty() ?
                request.getItems().stream().map(this::itemRequestToEntity).collect(Collectors.toList())
                : null);

        return entity;
    }

    public Item itemRequestToEntity(ItemRequest request) {
        if (request == null) return null;
        Item entity = new Item();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setValue(request.getValue());
        entity.setExpirationDate(request.getExpirationDate());

        return entity;
    }


}




