package org.wcci.blog;

import org.springframework.stereotype.Service;
import org.wcci.blog.Hashtag;
import org.wcci.blog.HashtagRepository;
import org.wcci.blog.HashtagStorage;

import java.util.Collection;

@Service
public class HashtagStorageJpaImp implements HashtagStorage {
    private HashtagRepository hashtagRepository;


    public HashtagStorageJpaImp(HashtagRepository hashtagRepository){
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void store(Hashtag hashtagToStore){
        hashtagRepository.save(hashtagToStore);

    }
    @Override
    public Hashtag findHashtagById(Long id){
        return hashtagRepository.findById(id).get();
    }

    @Override
    public Collection<Hashtag> findAllHashtags(){
        return (Collection<Hashtag>) hashtagRepository.findAll();
    }

}
