package br.com.pb.mshistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class MshistoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MshistoryApplication.class, args);
    }

}
