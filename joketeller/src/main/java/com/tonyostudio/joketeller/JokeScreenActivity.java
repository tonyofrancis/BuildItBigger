package com.tonyostudio.joketeller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JokeScreenActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "com.tonyostudio.joketeller.joke";
    public static final String EXTRA_ANSWER = "com.tonyostudio.joketeller.answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_screen);

        final TextView jokeTextView = (TextView) findViewById(R.id.joke_text_view);
        final Button answerButton = (Button) findViewById(R.id.answer_button);

        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        jokeTextView.setText(joke);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = getIntent().getStringExtra(EXTRA_ANSWER);
                jokeTextView.setText(answer);
                answerButton.setVisibility(View.GONE);
            }
        });

    }

    public static Intent getIntent(Context context, String joke, String answer) {
        Intent intent = new Intent(context,JokeScreenActivity.class);
        intent.putExtra(EXTRA_JOKE,joke);
        intent.putExtra(EXTRA_ANSWER,answer);

        return intent;
    }

}
