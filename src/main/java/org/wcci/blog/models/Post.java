package org.wcci.blog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.*;

@Entity

public class Post {
    @Lob
    private String postBody;
    private String  title;
    @ManyToOne
    private Category category;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @OneToMany
    Collection<Comment> comments;
    public Post(Category category, String title, String postBody, Hashtag...hashtag){
        this.category = category;
        this.title = title;
        this.postBody = postBody;
        this.hashtags = Arrays.asList(hashtag);
    }
    public Post(){

    }
    public Collection<Hashtag>getHashtags(){
        return hashtags;
    }
    public void addHashtag(Hashtag hashtagToAdd) {
        hashtags.add(hashtagToAdd);
    }
    public Collection<Comment> getComments(){
        return comments;
    }

    public void addCommentToReview(Comment commentToAdd){
        comments.add(commentToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(postBody,post.postBody) &&
                Objects.equals(title, post.title) &&
                Objects.equals(category, post.category) &&
                getId().equals(post.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(postBody, title, category, getId());
    }
    public String getPostBody(){
        return postBody;
    }
    public String getTitle(){
        return title;
    }
    public Category getCategory(){
        return category;
    }
    public Long getId(){
        return id;
    }
}
