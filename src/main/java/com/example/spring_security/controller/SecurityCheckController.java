package com.example.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityCheckController {


    //Same HTTP methods but restricted on method level.

    @GetMapping("/m1")
    public String m1(){
        return "Method 1";
    }

    @GetMapping( "/m2")
    public String m2(){
        return "Method 2";
    }

    @GetMapping("/m3")
    public String m3(){
        return "Method 3";
    }


//    @GetMapping("/m1")
//    public String m1() {
//        return "Method 1";
//    }
//
//    @PostMapping("/m2")
//    public String m2() {
//        return "Method 2";
//    }
//
//    @PatchMapping("/m3")
//    public String m3() {
//        return "Method 3";
//    }
}
