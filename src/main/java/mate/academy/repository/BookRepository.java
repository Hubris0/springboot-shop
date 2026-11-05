package mate.academy.repository;

import java.util.List;
import mate.academy.model.Book;

public interface BookRepository {
    Book addBook(Book book);

    List<Book> findAll();
}
