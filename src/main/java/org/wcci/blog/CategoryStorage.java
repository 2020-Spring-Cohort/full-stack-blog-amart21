package org.wcci.blog;


import org.wcci.blog.models.Category;

import java.util.Collection;


public interface CategoryStorage {

    Collection<Category> findAllCategories();

    void store(Category category);

    Category findCategoryByType(String categoryType);

}
