package storage;


import org.wcci.blog.models.Post;

public interface PostStorage {
    Post findPostById(long id);

    void store(Post postToStore);

}
