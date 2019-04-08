package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        //Eric
        Author eric=new Author("Eric","Butcher");
        Book asd=new Book("joska","12m","mmm");
        eric.getBooks().add(asd);
        asd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(asd);

        //Pista
        Author pista=new Author("Pista","Butcher");
        Book bsd=new Book("hello","20u","lll");
        pista.getBooks().add(bsd);
        authorRepository.save(pista);
        bookRepository.save(bsd);
    }
}