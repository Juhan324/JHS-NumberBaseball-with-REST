package com.jhs.numberbaseball.controller;

import com.jhs.numberbaseball.dto.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/game")
public class GameController {
    @GetMapping("/guess/{number}")
    public ResponseEntity<Object> guess(@PathVariable int number) {
        Object result = new Result("test",number,0,1);
        return ResponseEntity.ok().body(result);
    }
}
