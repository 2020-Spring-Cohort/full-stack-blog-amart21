package org.wcci.blog.Integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.CategoryRepository;
import org.wcci.blog.PostRepository;

@DirtiesContext
@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private PostRepository PostReop;
    @Autowired
    private TestEntityManager entityManager;




}
