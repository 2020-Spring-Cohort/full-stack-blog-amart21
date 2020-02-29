package storage;


import org.springframework.stereotype.Service;
import storage.repositories.HashtagRepository;
import org.wcci.blog.models.Hashtag;

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

