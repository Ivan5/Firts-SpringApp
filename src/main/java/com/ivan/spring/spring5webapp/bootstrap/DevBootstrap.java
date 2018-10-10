package com.ivan.spring.spring5webapp.bootstrap;

import com.ivan.spring.spring5webapp.model.Author;
import com.ivan.spring.spring5webapp.model.Book;
import com.ivan.spring.spring5webapp.model.Publisher;
import com.ivan.spring.spring5webapp.repositories.AuthorRepository;
import com.ivan.spring.spring5webapp.repositories.BookRespository;
import com.ivan.spring.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRespository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRespository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData () {
        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);
        //Erick
        Author erick = new Author("Erick","Evans");
        Book dd = new Book("Domain Driven Desing","1234",publisher);
        erick.getBooks().add(dd);
        dd.getAuthors().add(erick);
        authorRepository.save(erick);
        bookRepository.save(dd);

        //Rod
        Author rod = new Author("Rod","Johns");
        Book noEJB = new Book("J2EE Development","23444",publisher);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
