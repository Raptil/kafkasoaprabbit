package com.vtbexample.kafkasoaprabbit.controller;

import com.vtbexample.kafkasoaprabbit.dto.StarshipDto;
import com.vtbexample.kafkasoaprabbit.service.StarshipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/starship")
@AllArgsConstructor
public class StarshipController {

    private final StarshipService service;

    @PostMapping
    public void send(@RequestBody StarshipDto dto){
        service.send(dto);
    }

    @GetMapping("/test")
    public void testSend(){
        StarshipDto dto = new StarshipDto();
        dto.setName("testName");
        dto.setModel("testModel");
        service.send(dto);
    }
}
