package storage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
