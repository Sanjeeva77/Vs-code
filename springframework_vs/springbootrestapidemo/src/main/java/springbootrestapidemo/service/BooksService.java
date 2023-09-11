package springbootrestapidemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springbootrestapidemo.dao.BookRepository;
import springbootrestapidemo.entities.Book;

@Component
public class BooksService {

     @Autowired
    private BookRepository bookRepository;

    // private static  List<Book> books= new ArrayList<>();

    // static{
    //     books.add(new Book(5,"Java Head First","ABC"));
    //     books.add(new Book(12,"Java Completet Reference","XYZ"));
    //     books.add(new Book(1212,"JThink in Java","LMN"));
    // }

    //get all books
    public List<Book> getBooks(){

        List<Book> list =bookRepository.findAll();
        return list;
    }

    //get single book
    public Book getBookById(int id){
        Book book=null;
        try{
           book=bookRepository.findById(id).get();
         }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return book;
    }

    //adding a book
    public Book addBook(BookRepository book){
        Book book2=bookRepository.save(book);
        return book2;
    }

    //updating a book
    public void updateBook(BookRepository book,int id)
    {

    //   books= books.stream().map(b->{
    //         if(b.getBookId()==id){
    //             b.setAuthor(book.getAuthor());
    //             b.setTitle(book.getTitle());
    //            }
    //         return b;
    //     }).collect(Collectors.toList());
      Book b=bookRepository.findById(id).get();
      b.setAuthor(book.getAuthor());
      b.setTitle(book.getTitle());
      Book book2=bookRepository.save(b);
        
    }

    //deleting a book
    public void deleteBook(int id){
    //    books= books.stream().filter(b->b.getBookId()!=id).collect(Collectors.toList());
    bookRepository.deleteById(id);
    }
    
}
