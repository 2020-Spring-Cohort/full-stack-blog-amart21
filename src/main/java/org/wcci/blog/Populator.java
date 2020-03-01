package org.wcci.blog;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.models.Category;
import org.wcci.blog.models.Hashtag;
import org.wcci.blog.models.Post;
import org.wcci.blog.storage.CategoryStorage;
import org.wcci.blog.storage.HashtagStorage;
import org.wcci.blog.storage.PostStorage;


@Component
public class Populator implements CommandLineRunner{
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
        Hashtag hashtag3 = new Hashtag("Dud");
        Hashtag hashtag4 = new Hashtag("Delicious");
        Hashtag hashtag5 = new Hashtag("BangingPie");
        Hashtag hashtag6 = new Hashtag("Needmorehands");
        Hashtag hashtag7 = new Hashtag("Fast");
        Hashtag hashtag8 = new Hashtag("BringItOn");
        Hashtag hashtag9 = new Hashtag("BetterThanBreathing");
        Hashtag hashtag10 = new Hashtag("MyHappySpot");
        Hashtag hashtag11 = new Hashtag("Giggity");
        Hashtag hashtag12 = new Hashtag("GangGang");
        Hashtag hashtag13 = new Hashtag("Meh");
        Hashtag hashtag14 = new Hashtag("ChokingOnTheGoodness");
        Hashtag hashtag15 = new Hashtag("Lag");
        Hashtag hashtag16 = new Hashtag("BestValue");
        Hashtag hashtag17 = new Hashtag("ForeverACustomer");
        hashtagStorage.store(hashtag1);
        hashtagStorage.store(hashtag2);
        hashtagStorage.store(hashtag3);
        hashtagStorage.store(hashtag4);
        hashtagStorage.store(hashtag5);
        hashtagStorage.store(hashtag6);
        hashtagStorage.store(hashtag7);
        hashtagStorage.store(hashtag8);
        hashtagStorage.store(hashtag9);
        hashtagStorage.store(hashtag10);
        hashtagStorage.store(hashtag11);
        hashtagStorage.store(hashtag12);
        hashtagStorage.store(hashtag13);
        hashtagStorage.store(hashtag14);
        hashtagStorage.store(hashtag15);
        hashtagStorage.store(hashtag16);
        hashtagStorage.store(hashtag17);

        Post post1 = new Post(pizza, "awesome", "The best pizza in town. You have to order the Double-Cheese of Death. You'd think you had died" +
                "and gone to mouse shangri-la. Absolutely awesome.", hashtag1);
        Post post2 = new Post(game_system, "rocks offer more enjoyment", "The new Intellivision 1800 makes me wish " +
                "I had stuck playing with rocks from my backyard. The control paddle broke within the first two hours of play, and " +
                "that was the best part of my experience. The games didn't load correctly, and the on/off switch kept not working.", hashtag2);
        Post post3 = new Post(game_system,"no comparison, Sega is the BEST", "lalalalalalala", hashtag12);
        Post post4 = new Post(pizza,"Cardboard","I'd rather eat cardboard than order Jimmy's pizza again. No taste, little toppings, and makes pizza out of a box look"+
                "like gourmet food. Terrible",hashtag2,hashtag13);
        Post post5 = new Post(game_system,"Atari RULES","PONG is the best game EVAH! Atari and pong have provided hours of fun and excitement. I can't take enough"+
                "no-doze, I gotta keep playing. Who needs sleep?? Not this guy!!",hashtag17);
        Post post6 = new Post();
        Post post7 = new Post();
        Post post8 = new Post();
        Post post9 = new Post();
        postStorage.store(post1);
        postStorage.store(post2);
        postStorage.store(post3);
        postStorage.store(post4);
        postStorage.store(post5);
        postStorage.store(post6);
        postStorage.store(post7);
        postStorage.store(post8);
        postStorage.store(post9);



    }
}

