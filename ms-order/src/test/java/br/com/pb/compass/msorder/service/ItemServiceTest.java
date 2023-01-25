package br.com.pb.compass.msorder.service;

import br.com.pb.compass.msorder.domain.dto.ItemDTO;
import br.com.pb.compass.msorder.domain.dto.request.ItemRequest;
import br.com.pb.compass.msorder.domain.model.Item;
import br.com.pb.compass.msorder.repository.ItemRepository;
import br.com.pb.compass.msorder.repository.OrderRepository;
import br.com.pb.compass.msorder.util.MappersUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.verification.VerificationMode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

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
