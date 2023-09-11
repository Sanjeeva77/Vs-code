package springbootrestapidemo.dao;

import springbootrestapidemo.entities.Book;

public interface BookRepository  extends JpaRepository<Book,Integer>{

    
}