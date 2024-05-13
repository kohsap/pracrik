package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // GET запрос с ID в параметрах строки запроса
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    // POST запрос для получения ID из JSON тела
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public User getUserFromBody(@RequestBody UserRequest request) {
        return userService.getUser(request.getId());
    }

    // Вспомогательный класс для запроса
    private static class UserRequest {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
