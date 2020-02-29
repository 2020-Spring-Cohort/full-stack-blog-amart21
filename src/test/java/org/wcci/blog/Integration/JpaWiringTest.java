package org.wcci.blog.Integration;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.models.Category;
import storage.repositories.CategoryRepository;
import org.wcci.blog.models.Post;
import storage.repositories.PostRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void catgegoryShouldHaveAListOfPosts(){
        Category testCategory = new Category("Pizza");
        Post testPost = new Post(testCategory,"pizza","best pie in town");
        categoryRepo.save(testCategory);
        postRepo.save(testPost);

        entityManager.flush();
        entityManager.clear();
        Optional<Category> retrievedCategoryOptional = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOptional.get();
        Post retrievedPost = postRepo.findById(testPost.getId()).get();

        assertThat(retrievedCategory.getPosts()).contains(testPost);

    }



}
