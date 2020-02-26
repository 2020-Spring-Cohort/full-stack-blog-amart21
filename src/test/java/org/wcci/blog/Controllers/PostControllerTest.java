package org.wcci.blog.Controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.controllers.PostController;
import org.wcci.blog.PostStorage;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.models.Post;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class PostControllerTest {

    private PostController underTest;
    private Model model;
    private PostStorage mockStorage;
    private Post testPost;

    @BeforeEach
    void setUp(){
        mockStorage = mock(PostStorage.class);
        underTest = new PostController(mockStorage);
        model = mock(Model.class);
        Category testCategory = new Category("Pizza");
        Hashtag testHashtag = new Hashtag("");
        testPost = new Post(testCategory, "love this pizza","best pizza in town");
        when(mockStorage.findPostById(1)).thenReturn(testPost);
    }
    @Test
    public void displayPostInteractsWithDependenciesCorrectly(){
        underTest.displayPost(1L, model);
        verify(mockStorage).findPostById(1);
        verify(model).addAttribute("post",testPost);
    }
    @Test
    public void displayPostMappingIsCorrect() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/review/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post-view"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost));
    }

}
