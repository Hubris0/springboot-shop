package mate.academy.repository.book.spec;

import jakarta.persistence.criteria.Predicate;
import java.util.Arrays;
import mate.academy.model.Book;
import mate.academy.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    public static final String KEY = "title";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder)
                -> {
            Predicate[] predicates = Arrays.stream(params)
                    .map(param -> criteriaBuilder.like(
                            criteriaBuilder.lower(root.get(KEY)),
                            "%" + param.toLowerCase() + "%"
                    ))
                    .toArray(Predicate[]::new);
            return criteriaBuilder.or(predicates);
        };
    }
}
