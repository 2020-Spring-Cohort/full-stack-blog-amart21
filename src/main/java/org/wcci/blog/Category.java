package org.wcci.blog;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    @GeneratedValue
    private Long id;
    private String type;
    @OneToMany(mappedBy = "category")
    private Collection<Post> posts;

    public Category(String type) {
        this.type = type;
    }
    public Category(){

    }
    public String getType(){
        return type;
    }



}
