package org.wcci.blog;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

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
    private Collection<org.wcci.blog.models.Hashtag> hashtags;

    public Post(Category category, String title, String postBody, Hashtag...hashtag){
        this.category = category;
        this.title = title;
        this.postBody = postBody;
        this.hashtags = Arrays.asList(hashtag);

    }
    public Post(){

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
