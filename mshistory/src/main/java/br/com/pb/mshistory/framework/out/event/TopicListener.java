package br.com.pb.mshistory.framework.out.event;

import br.com.pb.mshistory.application.service.HistoryService;
import br.com.pb.mshistory.domain.dto.HistoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicListener {
    private final HistoryService service;

    @Value("${topic.name.consumer")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, HistoryDTO> payload) {
        log.info("Tópico: {}", topicName);
        log.info("Order: {}", payload.value());

        service.saveNewhistory(payload.value());
    }
}

