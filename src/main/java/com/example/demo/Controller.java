package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private final Tracer tracer;

    @Autowired
    public Controller(Tracer tracer) {
        this.tracer = tracer;
    }

    @GetMapping("/path")
    public Map<String, String> req() {
        return tracer.getAllBaggage();
    }
}
