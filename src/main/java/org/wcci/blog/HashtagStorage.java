package org.wcci.blog;


import java.util.Collection;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);

    Hashtag findHashtagById(Long id);

    Collection<Hashtag> findAllHashtags();


}
