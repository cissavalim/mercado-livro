package com.example.mercadolivro.controller

import com.example.mercadolivro.controller.request.PostBookRequest
import com.example.mercadolivro.controller.request.PutBookRequest
import com.example.mercadolivro.controller.response.BookResponse
import com.example.mercadolivro.extension.toBookModel
import com.example.mercadolivro.extension.toBookResponse
import com.example.mercadolivro.service.BookService
import com.example.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    var customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.findById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookResponse> {
        return bookService.findAll().map { it.toBookResponse() }
    }

    @GetMapping("/active")
    fun findActives(): List<BookResponse> =
        bookService.findActives().map { it.toBookResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookResponse {
        return bookService.findById(id).toBookResponse()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookToUpdate = bookService.findById(id)
        bookService.update(book.toBookModel(bookToUpdate))
    }

}