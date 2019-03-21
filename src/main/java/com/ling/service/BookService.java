package com.ling.service;

import com.ling.dao.BookRepository;
import com.ling.entity.Book;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lian on 03/07/2019.
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public long count(){
        return this.bookRepository.count();
    }

    public Book save(Book book){
        return this.bookRepository.save(book);
    }

    public void delete(Book book){
        this.bookRepository.delete(book);
    }
    public void deleteById(int id){
        this.bookRepository.deleteById(id);
    }

    public Iterable<Book> getAll(){
        return this.bookRepository.findAll();
    }

    public Book findById(int id){
        return this.bookRepository.findById(id).get();
    }

    public List<Book> getByName(String name){
        List<Book> books = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name",name);
        Iterable<Book> iterable = this.bookRepository.search(matchQueryBuilder);
        iterable.forEach(b->books.add(b));
        return books;
    }

    public Page<Book> pageQuery(Integer pageNo,Integer pageSize,String keyword){
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name",keyword))
                .withPageable(PageRequest.of(pageNo,pageSize))
                .build();
        return this.bookRepository.search(query);
    }
}
