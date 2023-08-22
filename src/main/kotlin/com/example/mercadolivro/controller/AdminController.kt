package com.example.mercadolivro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin")
class AdminController() {

    @GetMapping("/report")
    fun report(@RequestParam name: String?): String {
        return "This is a report. Only administrators can access it!"
    }
}