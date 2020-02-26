package org.wcci.blog;


import java.util.Collection;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);

    Hashtag FindHashtagById(Long id);

    Collection<Hashtag> findAllHashtags();


}
