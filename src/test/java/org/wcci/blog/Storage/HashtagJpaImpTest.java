package org.wcci.blog.Storage;


import org.junit.jupiter.api.Test;
import org.wcci.blog.models.Hashtag;
import storage.repositories.HashtagRepository;
import storage.HashtagStorage;
import storage.HashtagStorageJpaImp;

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

