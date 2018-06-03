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

    AuthorRepository authorRepository;
    BookRepository bookRepository;
    PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){

        // Geoff
        Author geoffrey = new Author("Geofrey","Seloana");
        Publisher publisher = new Publisher("Oracle","27 Maggs Str");
        Book php = new Book("PHP","978-3-16-148410-0",publisher);
        geoffrey.getBooks().add(php);
        php.getAuthers().add(geoffrey);

        authorRepository.save(geoffrey);
        bookRepository.save(php);
        publisherRepository.save(publisher);


        // Eric
        Author eric = new Author("Eric","Dlamini");
        Publisher publisher1 = new Publisher("Microsoft","22 Setso Str");
        Book javascript = new Book("Javascript","9781234567897",publisher1);
        eric.getBooks().add(javascript);
        javascript.getAuthers().add(eric);

        authorRepository.save(eric);
        bookRepository.save(javascript);
        publisherRepository.save(publisher1);


    }


}
