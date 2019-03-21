package com.ling;

import com.ling.dao.BookRepository;
import com.ling.entity.Book;
import com.ling.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Lian on 03/01/2019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookService bookService;

    @Test
    public void testSave(){
        Book book = new Book();
        book.setId(3);
        book.setName("Test dd3");
        book.setAuthor("mack");

        Book b = this.bookService.save(book);
        System.out.println(b.getName());

    }

    @Test
    public void testFindById(){
        Book b = this.bookService.findById(1);
        System.out.println(b.getName());

    }

    @Test
    public void testGetAll() {
        Iterable<Book> iterable = bookService.getAll();
        iterable.forEach(b->System.out.println(b.getAuthor()));
    }

    @Test
    public void testGetByName() {
        Iterable<Book> iterable = bookService.getByName("Test");
        iterable.forEach(b->System.out.println(b.getAuthor()));
    }

    @Test
    public void testageQuery() {
        Page<Book> page = bookService.pageQuery(0,10,"Test");
        page.getContent().forEach(b->System.out.println(b.getAuthor()));
    }
}
