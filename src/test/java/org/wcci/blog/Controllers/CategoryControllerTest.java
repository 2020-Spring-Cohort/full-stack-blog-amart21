package org.wcci.blog.Controllers;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.CategoryController;
import org.wcci.blog.CategoryStorage;

import static org.mockito.Mockito.mock;

public class CategoryControllerTest {

    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp(){
        mockModel = mock(Model.class);
        mockStorage = mock(CategoryStorage.class);
        underTest = new CategoryController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

    }

}
