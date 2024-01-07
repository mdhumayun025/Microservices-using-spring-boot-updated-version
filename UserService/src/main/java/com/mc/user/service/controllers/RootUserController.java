package com.mc.user.service.controllers;

import com.mc.user.service.entities.User;
import com.mc.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/root-users")
public class RootUserController {
    @GetMapping
    public ResponseEntity<List<String>> getAllUser(){
        List<String> users = Arrays.asList("Kabir", "Zubair", "Rasheda");
        return ResponseEntity.ok(users);
    }
}
