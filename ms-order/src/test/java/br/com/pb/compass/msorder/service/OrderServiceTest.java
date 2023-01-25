package br.com.pb.compass.msorder.service;

import br.com.pb.compass.msorder.repository.OrderRepository;
import br.com.pb.compass.msorder.util.MappersUtils;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest(classes = OrderService.class)
class OrderServiceTest {
    @Autowired
    private OrderService service;
    @MockBean
    private OrderRepository repository;
    @SpyBean
    private ModelMapper mapper;

    @SpyBean
    private MappersUtils mappersUtils;


    @Test
    void saveNewOrder() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getAllByCpf() {
    }

    @Test
    void getOrderById() {

    }
    @Test
    void deleteOrderById() {
    }

    @Test
    void updateOrderInformation() {
    }
}