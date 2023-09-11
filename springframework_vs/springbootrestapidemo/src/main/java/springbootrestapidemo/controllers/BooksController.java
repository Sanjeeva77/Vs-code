package springbootrestapidemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import springbootrestapidemo.dao.BookRepository;
import springbootrestapidemo.service.BooksService;

public class BooksController {

    @Autowired
    private BooksService booksService;
   
    @GetMapping("/books")
    public ResponseEntity<List<BookRepository>> getBooks(){
         List<BookRepository> list = this.booksService.getBooks();
         if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookRepository> getBookById(@PathVariable("id") int id){

        BookRepository book = null;
        book=this.booksService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.of(Optional.of(book));
        
    }

    @PostMapping("/books")
    public ResponseEntity<BookRepository> addBook(@RequestBody BookRepository book){
         BookRepository book2 = null;
         try {
            book2=this.booksService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(book2);
         } catch (Exception e) {
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
         
        
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookRepository> updateBook(@RequestBody BookRepository book,@PathVariable("id") int id){

        try{
            this.booksService.updateBook(book,id);
            return ResponseEntity.ok().body(book);
         }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){

        try{
        this.booksService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
