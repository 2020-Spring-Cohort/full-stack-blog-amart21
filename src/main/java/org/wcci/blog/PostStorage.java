package org.wcci.blog;


import org.wcci.blog.Post;

public interface PostStorage {
    Post findPostById(long id);

    void store(Post postToStore);

}
