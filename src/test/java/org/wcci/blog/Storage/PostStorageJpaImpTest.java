package org.wcci.blog.Storage;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostStorageJpaImpTest {
    private PostRepository postRepo;
    private PostStorage underTest;
    private Post testPost;

    @BeforeEach
    void setUp(){
        postRepo = mock(PostRepository.class);
        underTest = new PostStorageJpaImp(postRepo);
        Category testCategory = new Category("Game Systems");
        Hashtag testHashtag = new Hashtag("groovy");
        testPost = new Post(testCategory, "blah blah blah", "hours of fun");
    }
    @Test
    public void shouldFindReviewById(){
        when(postRepo.findById(1L)).thenReturn(Optional.of(testPost));
        Post retrievedPost = underTest.findPostById(1L);
        assertThat(retrievedPost).isEqualTo(testPost);

    }

    @Test
    public void shouldStorePost(){
        underTest.store(testPost);
        verify(postRepo).save(testPost);
    }
}
