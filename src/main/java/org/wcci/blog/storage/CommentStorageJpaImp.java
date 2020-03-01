package org.wcci.blog.storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.models.Comment;
import org.wcci.blog.storage.repositories.CommentRepository;

import java.util.Collection;

    @Service
    public class CommentStorageJpaImp implements CommentStorage {
        private CommentRepository commentRepository;
        public CommentStorageJpaImp(CommentRepository commentRepo) {
            this.commentRepository = commentRepo;
        }
        @Override
        public Comment findCommentById(Long id) {
            return commentRepository.findById(id).get();
        }
        @Override
        public void store(Comment commentToStore){
            commentRepository.save(commentToStore);
        }
        @Override
        public Collection<Comment> findAllComments(){
            return (Collection<Comment>) commentRepository.findAll();
        }
    }


