package mate.academy.service;

import java.util.List;
import mate.academy.dto.BookDto;
import mate.academy.dto.BookSearchParameters;
import mate.academy.dto.CreateBookRequestDto;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto createBookRequestDto);

    BookDto findBookById(Long id);

    List<BookDto> findAll(Pageable pageable);

    BookDto update(Long id, CreateBookRequestDto bookDto);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters params);
}
