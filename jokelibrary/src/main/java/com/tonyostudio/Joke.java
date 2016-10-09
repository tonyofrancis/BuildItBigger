package com.tonyostudio;

/**
 * Created by tonyofrancis on 10/9/16.
 */

public class Joke {

    private String joke;
    private String answer;

    public Joke() {
    }

    public Joke(String joke, String answer) {
        this.joke = joke;
        this.answer = answer;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
