package ru.maltsev.springapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.maltsev.springapp.model.Author;
import ru.maltsev.springapp.model.Book;
import ru.maltsev.springapp.model.Publisher;
import ru.maltsev.springapp.repos.AuthorRepo;
import ru.maltsev.springapp.repos.BookRepo;
import ru.maltsev.springapp.repos.PublisherRepo;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;

    public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("Harper Collins");

        publisherRepo.save(publisher);

        Author eric = new Author("Eric", "Evance");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("j2EE development without ejb", "234444", publisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
