package storage;

import org.wcci.blog.models.Comment;

import java.util.Collection;

public interface CommentStorage {

    void store(Comment commentToStore);

    Comment findCommentById(Long id);

    Collection<Comment> findAllComments();

}
