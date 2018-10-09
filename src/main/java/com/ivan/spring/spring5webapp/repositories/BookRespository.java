package com.ivan.spring.spring5webapp.repositories;

import com.ivan.spring.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;




public interface BookRespository extends CrudRepository<Book, Long> {

}
