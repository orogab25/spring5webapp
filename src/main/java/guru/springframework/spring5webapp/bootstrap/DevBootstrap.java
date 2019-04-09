package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Publishers
        Publisher publisher=new Publisher();
        publisher.setName("qwe");
        publisherRepository.save(publisher);

        //Authors
        Author eric=new Author("Eric","Butcher");
        Book asd=new Book("joska","12m",publisher);
        eric.getBooks().add(asd);
        asd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(asd);

        Author pista=new Author("Pista","Butcher");
        Book bsd=new Book("hello","20u",publisher);
        pista.getBooks().add(bsd);
        authorRepository.save(pista);
        bookRepository.save(bsd);
    }
}