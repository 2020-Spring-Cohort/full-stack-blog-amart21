package org.wcci.blog.Storage;

import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Category;
import org.wcci.blog.storage.repositories.CategoryRepository;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.CategoryStorageJpaImp;

import java.util.Collections;
import java.util.Optional;

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
    @Test
    public void shouldRetrieveSingleCategoryByType(){
        CategoryRepository mockCategoryRepo = mock(CategoryRepository.class);
        Category testcategory1 = new Category("Pizza");
        Category testcategory2 = new Category("Game Systems");
        CategoryStorage underTest = new CategoryStorageJpaImp(mockCategoryRepo);
        underTest.store(testcategory1);
        underTest.store(testcategory2);
        Optional<Category> testCategory1Optional = Optional.of(testcategory1);
        when(mockCategoryRepo.findByType("Pizza"))  .thenReturn(testCategory1Optional);
        Optional<Category> testCategory2Optional =Optional.of(testcategory2);
        when(mockCategoryRepo.findByType("Game Systems")).thenReturn(testCategory2Optional);

        Category retrievedCategory1 = underTest.findCategoryByType("Pizza");
        Category retrievedCategory2 = underTest.findCategoryByType("Game Systems");
        assertThat(retrievedCategory1).isEqualTo(testcategory1);
        assertThat(retrievedCategory2).isEqualTo(testcategory2);
        }
    }

