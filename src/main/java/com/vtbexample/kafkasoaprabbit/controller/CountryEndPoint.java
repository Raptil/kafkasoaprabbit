package com.vtbexample.kafkasoaprabbit.controller;

import com.vtbexample.kafkasoaprabbit.dto.GetRequest;
import com.vtbexample.kafkasoaprabbit.dto.GetResponse;
import com.vtbexample.kafkasoaprabbit.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@AllArgsConstructor
@Endpoint
public class CountryEndPoint {

    private static final String NAMESPACE_URI = "http://www.vtbexample.com/kafkasoaprabbit/dto";

    private CountryService countryService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRequest")
    @ResponsePayload
    public GetResponse getResponse(@RequestPayload GetRequest request){
        GetResponse response = new GetResponse();
        response.setCountry(countryService.findCountry(request.getName()));
        return response;
    }
}
