package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.wcci.blog.models.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByType(String categoryType);
}
