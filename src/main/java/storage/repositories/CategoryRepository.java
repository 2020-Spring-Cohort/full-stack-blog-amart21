package storage.repositories;

import org.wcci.blog.models.Category;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByType(String categoryType);
}
