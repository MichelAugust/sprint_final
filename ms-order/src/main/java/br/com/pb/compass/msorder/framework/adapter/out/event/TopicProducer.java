package br.com.pb.compass.msorder.framework.adapter.out.event;

import br.com.pb.compass.msorder.domain.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicProducer {

    private static final Logger log = LoggerFactory.getLogger(TopicProducer.class);

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, OrderDTO> kafkaTemplate;

    public void send(OrderDTO message){
        log.info("Payload send: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
