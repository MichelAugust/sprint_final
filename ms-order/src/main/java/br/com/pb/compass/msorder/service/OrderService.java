package br.com.pb.compass.msorder.service;

import br.com.pb.compass.msorder.domain.dto.OrderDTO;
import br.com.pb.compass.msorder.domain.dto.request.OrderRequest;
import br.com.pb.compass.msorder.domain.model.Order;
import br.com.pb.compass.msorder.repository.OrderRepository;
import br.com.pb.compass.msorder.util.MappersUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository repository;
    private final ModelMapper mapper;
    private final MappersUtils mappersUtils;

    public OrderDTO saveNewOrder(OrderRequest orderRequest) {
        Order entity = mappersUtils.orderRequestToEntity(orderRequest);
        Order saved = repository.save(entity);
        return mapper.map(saved, OrderDTO.class);
    }
    public List<OrderDTO> getAll(String sort, String s) {
        Sort sorted = verifySortDirection(sort);
        List<Order> ordersList = repository.findAll(sorted);

        return ordersList.stream().map(order -> mapper.map(order, OrderDTO.class)).collect(Collectors.toList());
    }

    public List<OrderDTO> getAllByCpf(String sort, String cpf) {
        Sort sorted = verifySortDirection(sort);
        List<Order> ordersList = repository.findAllByCpf(sorted, cpf);

        return ordersList.stream().map(order -> mapper.map(order, OrderDTO.class)).collect(Collectors.toList());
    }

    public OrderDTO getOrderById(Long id) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(entity, OrderDTO.class);
    }

    public void deleteOrderById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repository.delete(order);
    }

    public OrderDTO updateOrderInformation(Long id, OrderRequest orderRequest) {
        Order entity = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Order newOrder = mappersUtils.orderRequestToEntity(orderRequest);

        mapper.map(newOrder, entity);
        repository.save(entity);

        return mapper.map(entity, OrderDTO.class);
    }

    private Sort verifySortDirection(String stringSort) {
        if (stringSort == null) {
            return Sort.by("id");
        }
        Sort.Direction direction = stringSort.equalsIgnoreCase
                ("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return Sort.by(direction, "amount");
    }

}




