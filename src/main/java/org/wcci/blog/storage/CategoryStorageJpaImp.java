package org.wcci.blog.storage;


import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.models.Category;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryStorageJpaImp implements CategoryStorage {
    private CategoryRepository categoryRepository;

    public CategoryStorageJpaImp(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Collection<Category> findAllCategories(){
        return (Collection<Category>) categoryRepository.findAll();

    }
    @Override
    public void store(Category category){
        categoryRepository.save(category);
    }
    @Override
    public Category findCategoryByType(String categoryType){
        return categoryRepository.findByType(categoryType).get();
    }


}
