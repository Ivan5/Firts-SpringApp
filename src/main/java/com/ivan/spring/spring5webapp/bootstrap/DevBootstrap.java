package com.ivan.spring.spring5webapp.bootstrap;

import com.ivan.spring.spring5webapp.model.Author;
import com.ivan.spring.spring5webapp.model.Book;
import com.ivan.spring.spring5webapp.repositories.AuthorRepository;
import com.ivan.spring.spring5webapp.repositories.BookRespository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRespository bookRepository;

    public DevBootstrap(AuthorRepository author , BookRespository book){
        this.authorRepository = author;
        this.bookRepository = book;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData () {
        //Erick
        Author erick = new Author("Erick","Evans");
        Book dd = new Book("Domain Driven Desing","1234","Marger Collins");
        erick.getBooks().add(dd);
        dd.getAuthors().add(erick);
        authorRepository.save(erick);
        bookRepository.save(dd);

        //Rod
        Author rod = new Author("Rod","Johns");
        Book noEJB = new Book("J2EE Development","23444","work");
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
