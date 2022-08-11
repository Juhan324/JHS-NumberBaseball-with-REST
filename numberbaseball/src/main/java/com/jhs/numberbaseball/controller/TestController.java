package com.jhs.numberbaseball.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/status/{statuscode}")
    public ResponseEntity<Object> badRequestTest(@PathVariable String statuscode){
        switch(statuscode){
            case "ok":
                return ResponseEntity.ok("good");
            case "notfound":
                return ResponseEntity.notFound().build();
            case "badrequest":
                return ResponseEntity.badRequest().body("잘못된 요청입니다.");
            default:
                return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/game/guess/{number}")
    public ResponseEntity<Object> guessTest(@PathVariable String number){
        return ResponseEntity.ok().body(number);
    }
}