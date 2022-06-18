package com.klid.user.controller;

import com.klid.user.entity.User;
import com.klid.user.model.UserDepartment;
import com.klid.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ivan Kaptue
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("UserController save user {}", user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDepartment> getUserWithDepartment(@PathVariable Long userId) {
        log.info("UserController getUserWithDepartment {}", userId);
        return ResponseEntity.ok(userService.getUserWithDepartment(userId));
    }
}
