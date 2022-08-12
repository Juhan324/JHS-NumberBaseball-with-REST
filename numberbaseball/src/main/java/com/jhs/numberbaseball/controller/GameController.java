package com.jhs.numberbaseball.controller;

import com.jhs.numberbaseball.dto.ConnectionRegist;
import com.jhs.numberbaseball.dto.NumberGuess;
import com.jhs.numberbaseball.dto.NumberRegist;
import com.jhs.numberbaseball.dto.Result;
import com.jhs.numberbaseball.service.BaseballService;
import com.jhs.numberbaseball.util.UserUtil;
import com.jhs.numberbaseball.vo.PlayerVO;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/game")
public class GameController {
    @GetMapping("/{number}")
    public ResponseEntity<Object> guess(@PathVariable int number) {
        Object result = new Result("test",number,0,1);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/guess/{number}")
    public ResponseEntity<Object> guessTest(@PathVariable int number, @RequestBody NumberGuess numberGuess){
        PlayerVO userVO = UserUtil.findbyName(numberGuess.getTarget());
        System.out.println(userVO);
        List<Integer> compare = BaseballService.compare(BaseballService.intToList(userVO.getNumber()), BaseballService.intToList(number));
        Object result = new Result(userVO.getUsername(),number, compare.get(0), compare.get(1));
        return ResponseEntity.ok().body(result);
    }
    @PostMapping("/numberregister")
    public ResponseEntity<Object> numberRegister(@RequestBody NumberRegist numberRegist){
        Object o = numberRegist;
        JSONObject result = new JSONObject(o);
        if(!result.getString("type").equals("numberregist")) {
            return ResponseEntity.badRequest().body(result.getString("type") + " is not allowed");
        }else{
            if(UserUtil.numberRegist(result.getString("username"), result.getInt("number"))){
                return ResponseEntity.ok(UserUtil.getUserList());
            }else{
                return  ResponseEntity.badRequest().body("Connection need");
            }
        }
    }

    @PostMapping("/connectionregister")
    public ResponseEntity<Object> connectionRegister(@RequestBody ConnectionRegist connectionRegist){
        Object o = connectionRegist;
        JSONObject result = new JSONObject(o);
        if(!result.getString("type").equals("connectionregist")) {
            return ResponseEntity.badRequest().body(result.getString("type") + " is not allowed");
        }else{
            if(UserUtil.connectionRegist(result.getString("username"), "WenSocketSession"+result.getString("username"))){
                return ResponseEntity.ok(UserUtil.getUserList());
            }else{
                return  ResponseEntity.badRequest().body("user already exists");
            }
        }
    }
}
