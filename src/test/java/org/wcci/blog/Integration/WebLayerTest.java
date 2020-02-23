package org.wcci.blog.Integration;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.CategoryStorage;
import org.wcci.blog.HashtagStorage;
import org.wcci.blog.PostStorage;


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

    }



}
