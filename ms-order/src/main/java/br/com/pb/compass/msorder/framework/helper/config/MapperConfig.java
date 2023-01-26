package br.com.pb.compass.msorder.framework.helper.config;

import br.com.pb.compass.msorder.domain.dto.OrderDTO;
import br.com.pb.compass.msorder.domain.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class MapperConfig {
    @Bean
    public ModelMapper mapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }



}


