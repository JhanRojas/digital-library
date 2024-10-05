package com.diglib.repositories;

import com.diglib.models.BookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends CrudRepository<BookModel, Long> {
    public abstract ArrayList<BookModel> findAll();
}
