package org.wcci.blog;


import org.wcci.blog.models.Hashtag;

import java.util.Collection;

public interface HashtagStorage {

    void store(Hashtag hashtagToStore);

    Hashtag FindHashtagById(Long id);

    Collection<Hashtag> findAllHashtags();


}
