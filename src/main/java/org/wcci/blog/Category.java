package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return getId().equals(category.getId()) &&
                getType().equals(category.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getType());
    }
    public Long getId(){
        return id;
    }
    public Collection<Post> getPosts(){
        return posts;
    }
    @Override
    public String toString(){
        return "Category{" + "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
