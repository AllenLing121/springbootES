package com.ling.dao;

import com.ling.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lian on 03/01/2019.
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
