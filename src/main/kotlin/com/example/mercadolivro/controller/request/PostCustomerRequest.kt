package com.example.mercadolivro.controller.request

import com.example.mercadolivro.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Name must not be null or empty")
    var name: String,

    @field:Email(message = "E-mail must be valid")
    @EmailAvailable
    var email: String,

    @field:NotEmpty(message = "Password must not be null or empty")
    var password: String
)