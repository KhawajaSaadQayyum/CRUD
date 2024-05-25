package CRUD.controller;

import CRUD.Entity.Books;
import CRUD.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/addBook")
    public ResponseEntity<String> addBooks(@RequestBody Books books){
      return   bookService.addBook(books);

    }
    @GetMapping("/getBooks")
    public List<Books> getAllBooks(){
       return bookService.getAllBooks();

    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id){
        return bookService.deleteBook(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> getAllBooks(@PathVariable long id,@RequestBody Books books){
        return bookService.updateBook(books , id );

    }
}
