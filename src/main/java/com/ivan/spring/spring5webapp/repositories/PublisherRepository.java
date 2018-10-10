package com.ivan.spring.spring5webapp.repositories;
import com.ivan.spring.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
