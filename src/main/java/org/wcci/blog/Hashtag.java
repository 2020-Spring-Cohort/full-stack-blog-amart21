package org.wcci.blog;

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
        return Objects.equals(getHashtag(), hashtag1.getHashtag()) &&
                Objects.equals(getId(), hashtag1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHashtag(), getId());
    }
}


