package org.wcci.blog;


import java.util.Collection;


public interface CategoryStorage {

    public Collection<Category> findAllCategories();

    public void store(Category category);

}
