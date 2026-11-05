package mate.academy;

import java.math.BigDecimal;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            System.out.println("--- Startowanie procesu dodawania danych testowych ---");

            Book harryPotter = new Book();
            harryPotter.setTitle("Harry Potter i Kamień Filozoficzny");
            harryPotter.setAuthor("J.K. Rowling");
            harryPotter.setIsbn("9788380082113");
            harryPotter.setPrice(new BigDecimal("39.99"));
            harryPotter.setDescription("Fantastyczna powieść o młodym czarodzieju.");

            bookRepository.addBook(harryPotter);

            System.out.println("--- Książka została pomyślnie dodana do bazy danych! ---");

            System.out.println("--- Znaleziono następujące książki: "
                    + bookRepository.findAll() + "\n ---");
        };
    }
}
