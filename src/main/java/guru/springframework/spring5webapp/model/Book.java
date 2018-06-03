package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbm;
    @OneToOne
    private Publisher publisher;


    @ManyToMany
    @JoinTable(name = "auther_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "auther_id"))
    private Set<Author> authers = new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbm, Publisher publisher) {
        this.title = title;
        this.isbm = isbm;
        this.publisher = publisher;
    }

    public Book(String title, String isbm, Publisher publisher, Set<Author> authers) {
        this.title = title;
        this.isbm = isbm;
        this.publisher = publisher;
        this.authers = authers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbm() {
        return isbm;
    }

    public void setIsbm(String isbm) {
        this.isbm = isbm;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthers() {
        return authers;
    }

    public void setAuthers(Set<Author> authers) {
        this.authers = authers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbm='" + isbm + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authers=" + authers +
                '}';
    }
}
