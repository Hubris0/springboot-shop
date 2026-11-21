package mate.academy.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.dto.BookDto;
import mate.academy.dto.CreateBookRequestDto;
import mate.academy.exception.EntityNotFoundException;
import mate.academy.mapper.BookMapper;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import mate.academy.service.BookService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto createBookRequestDto) {
        Book book = bookMapper.toModel(createBookRequestDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDto(savedBook);
    }

    @Override
    public BookDto findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto bookDto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book by id: " + id));
        bookMapper.updateBookFromDto(bookDto, existingBook);
        return bookMapper.toDto(bookRepository.save(existingBook));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book by id: " + id));
        bookRepository.deleteById(id);
    }
}
