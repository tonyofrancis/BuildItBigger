package com.tonyostudio.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import com.tonyostudio.jokeservice.jokeApi.model.Joke;

/**
 * Created by tonyofrancis on 10/10/16.
 */

public class JokeServiceAsyncTest extends AndroidTestCase {
    private static final String LOG_TAG = "JokeAsyncTask";

    @SuppressWarnings("unchecked")
    public void test() {

        Joke joke = null;
        JokeTask jokeTask = new JokeTask(getContext());
        jokeTask.execute();

        try {
            joke = jokeTask.get();
            Log.d(LOG_TAG, "Retrieved joke successfully: " + joke);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
    }
}
