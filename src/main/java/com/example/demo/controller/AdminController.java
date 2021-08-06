package com.example.demo.controller;

import com.example.demo.entity.UserPersist;
import com.example.demo.security.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = AdminController.PATH)
public class AdminController {

    static final String PATH = "/api/user";
    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserPersist>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
