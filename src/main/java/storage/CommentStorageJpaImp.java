package storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Comment;
import storage.repositories.CommentRepository;

import java.util.Collection;

public class CommentStorageJpaImp {
    @Service
    public class CommentStorageJpaImp {
        private CommentRepository commentRepository;


        public CommentStorageJpaImp(CommentRepository commentRepo) {
            this.commentRepository = commentRepo;
        }

        @Override
        public Comment findCommentById(Long id) {
            return commentRepository.findById(id).get();
        }

        @Override
        public void store(Comment commentToStore) {
            commentRepository.save(commentToStore);
        }
        @Override
        public Collection<Comment> findAllComments(){
            return (Collection<Comment>) commentRepository.findAll();
        }
    }
}