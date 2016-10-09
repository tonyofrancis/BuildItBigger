package com.tonyostudio;

import java.util.Random;

public class JokeLibrary {

    private static Joke[] jokes = new Joke[] {
            new Joke("What is Mozart doing right now?","Decomposing!!"),
            new Joke("Why do seagulls fly over the sea?","Because if they flew over the bay, they would be called bagles"),
            new Joke("What did Jay-Z call his girlfriend before getting married?","Feyoncè"),
            new Joke("When the smog lifts in Los Angeles, what happens?","UCLA"),
            new Joke("What happens when you cross a shark with a cow?","I don't know but I wouldn't milk it.")
    };

    public static Joke getRandomJoke() {
        return randomJoke();
    }

    private static Joke randomJoke() {

        Random random = new Random();
        int index = random.nextInt(jokes.length - 1) + 1;
        return jokes[index];
    }
}
