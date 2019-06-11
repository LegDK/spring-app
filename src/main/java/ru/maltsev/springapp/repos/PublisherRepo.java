package ru.maltsev.springapp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.maltsev.springapp.model.Publisher;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
