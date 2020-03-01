package org.wcci.blog.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Comment {
@ManyToOne
    private Post post;
    private String comment;

    @Id
    @GeneratedValue
    private Long id;
    public Comment(){
            }
    public Comment(String comment, Post post){
        this.comment = comment;
        this.post = post;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment1 = (Comment) o;
        return Objects.equals(post, comment1.post) &&
                Objects.equals(comment, comment1.comment) &&
                Objects.equals(id, comment1.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(post, comment, id);
    }
    public String getComment(){
        return comment;
    }
    public Long getId(){
        return id;
    }
}
