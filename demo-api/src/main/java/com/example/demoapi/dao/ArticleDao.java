package com.example.demoapi.dao;

import com.example.demoapi.ds.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends CrudRepository<Article, Integer> {
}
