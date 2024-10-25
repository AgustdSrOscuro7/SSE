package com.co.rudas.sse.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
public class sseController {

    @GetMapping("/")
    public SseEmitter streamSseMvc() {
        SseEmitter emitter = new SseEmitter();
        try {
            emitter.send(SseEmitter.event().name("evento-inicial").data("Conexion establecida"));
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
        return emitter;
    }
}
