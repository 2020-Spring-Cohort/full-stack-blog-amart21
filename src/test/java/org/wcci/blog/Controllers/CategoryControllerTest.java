package org.wcci.blog.Controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.models.Category;
import org.wcci.blog.controllers.CategoryController;
import storage.CategoryStorage;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class CategoryControllerTest {

    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoryController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

    }

    @Test
    public void shouldReturnViewWithOnePost() {
        Category testCategory = new Category("hamburger");
        when(mockStorage.findCategoryByType("Pizza")).thenReturn(testCategory);

        underTest.displaySingleCategory("Pizza", mockModel);
        verify(mockStorage).findCategoryByType("Pizza");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoryWhenDiaplayedSingleCategoryIsCalled() {
        String viewName = underTest.displaySingleCategory("Pizza", mockModel);
        assertThat(viewName).isEqualTo("category-view");
    }

    @Test
    public void shouldGoToIndividualEndPoint() throws Exception {
        Category testCategory = new Category("coupe");
        when(mockStorage.findCategoryByType("coupe")).thenReturn(testCategory);

        mockMvc.perform(get("/categories/coupe"))
                .andExpect(status().isOk())
                .andExpect(view().name("category-view"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", testCategory));

    }
    @Test
    public void categoryControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("coupe");

        List<Category> categoryCollection = Collections.singletonList(testCategory);
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categories-view"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }

}
