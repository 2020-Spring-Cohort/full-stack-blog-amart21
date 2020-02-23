package org.wcci.blog.Storage;

import org.junit.jupiter.api.Test;
import org.wcci.blog.Category;
import org.wcci.blog.CategoryRepository;
import org.wcci.blog.CategoryStorage;
import org.wcci.blog.CategoryStorageJpaImp;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpaImpTest {

    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testCategory = new Category("Pizza");
        CategoryStorage underTest = new CategoryStorageJpaImp(mockCategoryRepo);
        when(mockCategoryRepo.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.store(testCategory);
        verify(mockCategoryRepo).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);


    }
}
