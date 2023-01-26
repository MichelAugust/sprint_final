package br.com.pb.compass.msorder.service;

import br.com.pb.compass.msorder.application.service.OrderService;
import br.com.pb.compass.msorder.framework.adapter.out.database.OrderRepository;
import br.com.pb.compass.msorder.framework.helper.util.MappersUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ItemServiceTest {

    @InjectMocks
    private OrderService service;
    @Mock
    private OrderRepository repository;
    @Mock
    private ModelMapper mapper;
    @Mock
    private MappersUtils mappersUtils;

    private static final Long ID = 1L;



}
