package org.wcci.blog;


import javafx.geometry.Pos;

public interface PostStorage {
    Post FindPostById(long id);

    void store(Post postToStore);
}
