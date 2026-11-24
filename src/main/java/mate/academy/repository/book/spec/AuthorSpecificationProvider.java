package mate.academy.repository.book.spec;

import jakarta.persistence.criteria.Predicate;
import java.util.Arrays;
import mate.academy.model.Book;
import mate.academy.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {

    @Override
    public String getKey() {
        return "author";
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder)
                -> {
            Predicate[] predicates = Arrays.stream(params)
                    .map(param -> criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("author")),
                            "%" + param.toLowerCase() + "%"
                    ))
                    .toArray(Predicate[]::new);
            return criteriaBuilder.or(predicates);
        };
    }
}
