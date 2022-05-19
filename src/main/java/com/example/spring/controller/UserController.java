package com.example.spring.controller;

import com.example.spring.support.JSONResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("list")
    public String index() {
        return "user list";
    }

    @PostMapping("create")
    public String create(@RequestParam Map<String, Object> map,
                         @RequestHeader("token") String token,
                         @CookieValue("clientId") String clientId) {

        log.info(map.toString());
        log.info(token);
        log.info(clientId);
        return "user create";
    }

    @GetMapping("{userId}/get")
    public String get(@PathVariable("userId") String userId,
                      @RequestParam Integer id,
                      @RequestParam String name) {
        log.info(userId);
        log.info(id.toString());
        log.info(name);
        return "user get";
    }

    @PostMapping("update")
    public JSONResponse update(@RequestBody Map<String, Object> body) {
        log.info(body.toString());
        return JSONResponse.success(body);
    }

    @GetMapping("delete")
    public String delete() {
        return "user delete";
    }

}
