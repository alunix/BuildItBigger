package com.example.jokelib;


import java.util.Random;

public class JokeTell {

    private static final String JOKE = "A man walks into a cafe: splash!";
    private static final String[] jokes = new String[]{
            "What do you call a boomerang that won't come back? A stick.",
            "Where do you find giant snails? On the ends of their fingers.",
            "If you drop a white hat into the Red Sea, what does it become? Wet.",
            "What starts with E, ends with E and only has one letter? An envelope.",
            "What travels around the world and stays in a corner? A stamp.",
            "What is white when it's dirty and black when it's clean? A blackboard."
    };

    public String getJoke() {
        return JOKE;
    }

    public String getRandomJoke() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(jokes.length - 1);
        return jokes[randomInt];
    }

}
