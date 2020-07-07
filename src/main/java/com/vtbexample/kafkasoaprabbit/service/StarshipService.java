package com.vtbexample.kafkasoaprabbit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtbexample.kafkasoaprabbit.dto.StarshipDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class StarshipService {

    private KafkaTemplate<Long, StarshipDto> kafkaStarshipTemplate;
    private ObjectMapper objectMapper;

    public void send(StarshipDto dto){
        log.info("<= sending {}",writeValueAsString(dto));
        kafkaStarshipTemplate.send("test",dto);
    }

    @KafkaListener(id = "Starship", topics = {"test"}, containerFactory = "singleFactory")
    public void consume(StarshipDto dto){
        log.info("=> consumed {}", writeValueAsString(dto));
    }

    private String writeValueAsString (StarshipDto dto){
        try{
            return objectMapper.writeValueAsString(dto);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            throw new RuntimeException("Writing value to JSON failed: " + dto.toString());
        }
    }
}
