package org.wcci.blog.Integration;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.HashtagStorage;
import org.wcci.blog.storage.PostStorage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CategoryStorage mockStorage;
    @MockBean
    HashtagStorage hashtagStorage;
    @MockBean
    PostStorage postStorage;

    @Test
    public void postShouldBeOkAndReturnThePostViewwiththeViewModelAttribute() throws Exception{

        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categories-view"))
                .andExpect(model().attributeExists("categories"));

    }



}
