package org.wcci.blog.Storage;


import org.junit.jupiter.api.Test;
import org.wcci.blog.Hashtag;
import org.wcci.blog.HashtagRepository;
import org.wcci.blog.HashtagStorage;
import org.wcci.blog.HashtagStorageJpaImp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HashtagJpaImpTest {
    @Test
    public void shouldStoreHashtag(){
        HashtagRepository hashtagRepo = mock(HashtagRepository.class);
        HashtagStorage underTest = new HashtagStorageJpaImp(hashtagRepo);
        Hashtag testHashtag = new Hashtag("billy");
        underTest.store(testHashtag);
        verify(hashtagRepo).save(testHashtag);

    }

}

