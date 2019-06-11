package ru.maltsev.springapp.repos;

import org.springframework.data.repository.CrudRepository;
import ru.maltsev.springapp.model.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
}
