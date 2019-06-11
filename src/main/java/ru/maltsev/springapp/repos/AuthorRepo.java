package ru.maltsev.springapp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.maltsev.springapp.model.Author;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
