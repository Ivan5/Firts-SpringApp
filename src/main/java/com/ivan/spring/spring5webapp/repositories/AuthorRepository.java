package com.ivan.spring.spring5webapp.repositories;

import com.ivan.spring.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    <S extends Author> S save(S s);


    <S extends Author> Iterable<S> saveAll(Iterable<S> iterable);


    Optional<Author> findById(Long aLong);


    boolean existsById(Long aLong);


    Iterable<Author> findAll();


    Iterable<Author> findAllById(Iterable<Long> iterable);


    long count();


    void deleteById(Long aLong);


    void delete(Author author);


    void deleteAll(Iterable<? extends Author> iterable);

    void deleteAll();
}
