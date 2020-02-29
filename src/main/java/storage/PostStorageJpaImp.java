package storage;

import storage.repositories.PostRepository;
import org.wcci.blog.models.Post;
import org.springframework.stereotype.Service;

@Service
public class PostStorageJpaImp implements PostStorage {
    private PostRepository postRepository;

    public PostStorageJpaImp(PostRepository postRepo) {
        this.postRepository = postRepo;

        }

        @Override
        public Post findPostById(long id){
            return postRepository.findById(id).get();
        }

        @Override
        public void store(Post postToStore){
            postRepository.save(postToStore);
        }
    }

