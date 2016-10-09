package com.tonyostudio.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.tonyostudio.jokeservice.jokeApi.JokeApi;
import com.tonyostudio.jokeservice.jokeApi.model.Joke;
import com.tonyostudio.joketeller.JokeScreenActivity;

import java.io.IOException;

/**
 * Created by tonyofrancis on 10/9/16.
 */

public class JokeTask extends AsyncTask<Void,Void,Joke> {

    public static boolean isLoading = false;

    private Context context;
    private JokeApi jokeApi;

    public JokeTask(Context context) {
        this.context = context;
    }

    @Override
    protected Joke doInBackground(Void... params) {
        isLoading = true;

        JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                .setRootUrl("http://192.168.0.4:8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });


        jokeApi = builder.build();

        try {
            return jokeApi.getJoke().execute();
        }catch (IOException error) {
            Log.e("ApiError",error.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Joke joke) {
        super.onPostExecute(joke);

        if(joke != null) {
            Intent intent = JokeScreenActivity.getIntent(context,joke.getJoke(),joke.getAnswer());
            context.startActivity(intent);
        } else {
            Toast.makeText(context,R.string.error_no_joke,Toast.LENGTH_SHORT).show();
        }

        isLoading = false;
    }
}
