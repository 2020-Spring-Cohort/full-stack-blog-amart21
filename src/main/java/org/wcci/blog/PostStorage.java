package org.wcci.blog;


public interface PostStorage {
    Post findPostById(long id);

    void store(Post postToStore);
}
