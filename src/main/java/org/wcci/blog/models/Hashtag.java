package org.wcci.blog.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

public class Hashtag {
    private String hashtag;

    public Long getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> posts;

    public String getHashtag() {
        return hashtag;
    }

    public Hashtag(){

    }

    public Hashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hashtag)) return false;
        Hashtag hashtag1 = (Hashtag) o;
        return Objects.equals(hashtag, hashtag1.hashtag) &&
                Objects.equals(id, hashtag1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashtag, id);
    }
}
