package org.wcci.blog;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.models.Post;
import storage.CategoryStorage;
import storage.HashtagStorage;
import storage.PostStorage;

@Component
public class Populator implements CommandLineRunner {
    private CategoryStorage categoryStorage;
    private PostStorage postStorage;
    private HashtagStorage hashtagStorage;

    public Populator(CategoryStorage categoryStorage, PostStorage postStorage, HashtagStorage hashtagStorage) {
        this.categoryStorage = categoryStorage;
        this.postStorage = postStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @Override
    public void run(String... args) {
        Category pizza = new Category("pizza");
        categoryStorage.store(pizza);
        Category game_system = new Category("game_system");
        categoryStorage.store(game_system);
        Hashtag hashtag1 = new Hashtag("Awesome");
        Hashtag hashtag2 = new Hashtag("Crap");
        hashtagStorage.store(hashtag1);
        hashtagStorage.store(hashtag2);
        Post post1 = new Post(pizza, "awesome", "The best pizza in town. You have to order the Double-Cheese of Death. You'd think you had died" +
                "and gone to mouse shangri-la. Absolutely awesome.", hashtag1);
        Post post2 = new Post(game_system, "rocks offer more enjoyment", "The new Intellivision 1800 makes me wish " +
                "I had stuck playing with rocks from my backyard. The control paddle broke within the first two hours of play, and " +
                "that was the best part of my experience. The games didn't load correctly, and the on/off switch kept not working.", hashtag2);
        postStorage.store(post1);
        postStorage.store(post2);


    }
}

