package CRUD.service;

import CRUD.Entity.Books;
import CRUD.Repositiry.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    public ResponseEntity<String> addBook(Books books) {
        bookRepo.save(books);
        return new ResponseEntity<>("Added In service", HttpStatus.OK);
    }

    public List<Books> getAllBooks() {
        return  new ArrayList<>(bookRepo.findAll());

    }

    public ResponseEntity<String> deleteBook(long id) {
        bookRepo.deleteById(id);
        return new ResponseEntity<>("Deleted Success",HttpStatus.OK);
    }

    public ResponseEntity<String> updateBook(Books books ,long id) {

        Optional<Books> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            Books existingBook = optionalBook.get();
            existingBook.setName(books.getName());
            existingBook.setAutherName(books.getAutherName());
            existingBook.setPrice(books.getPrice());
            bookRepo.save(existingBook);
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        } else {
           return  new ResponseEntity<>("Record Not found",HttpStatus.OK);
        }

    }
}
