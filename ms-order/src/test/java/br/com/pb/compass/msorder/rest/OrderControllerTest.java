package br.com.pb.compass.msorder.rest;

import br.com.pb.compass.msorder.domain.dto.OrderDTO;
import br.com.pb.compass.msorder.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = OrderController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Spy
    private ObjectMapper objectMapper;
    @Mock
    private  OrderService service;
    private static final Long ID = 1L;
    private static final String URL = "/pedidos";
    private static final String ID_URL = "/pedidos/1";

    @Test
    void whenGetByIdThenReturnSucess() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        OrderDTO orderResponse = new OrderDTO();

        when(service.getOrderById(any())).thenReturn(orderResponse);
        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get(ID_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    @Test
    void deleteOrder()throws Exception {
        doNothing().when(service).deleteOrderById(1L);

        MvcResult result = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .delete(ID_URL)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }
}