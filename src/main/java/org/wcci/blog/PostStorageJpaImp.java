package org.wcci.blog;


import org.springframework.stereotype.Service;
import org.wcci.blog.models.Post;

@Service
public class PostStorageJpaImp implements PostStorage {
    private PostRepository postRepository;


    public PostStorageJpaImp(PostRepository postRepo) {
        this.postRepository = postRepo;
    }
  @Override
    public Post findPostById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void store(Post reviewToStore){
        postRepository.save(reviewToStore);
    }
}
