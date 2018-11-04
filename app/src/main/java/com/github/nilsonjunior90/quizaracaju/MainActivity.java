package com.github.nilsonjunior90.quizaracaju;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       Button aboutButton = (Button) findViewById(R.id.about_button);
       aboutButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startAboutActivity();
        }
        });


        Button leaderBoardButton = (Button) findViewById(R.id.leader_board_button);
        leaderBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLeaderBoardActivity();
            }
        });


        Button newQuizButton = (Button) findViewById(R.id.new_quiz_button);
        newQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startQuizActivity();
            }
        });

    }

    private void startAboutActivity() {

        Intent intent = new Intent(this, AboutActivity.class);

        startActivity(intent);
    }

    private void startLeaderBoardActivity() {

        Intent intent = new Intent(this, LeaderBoardActivity.class);

        startActivity(intent);
    }

    private void startQuizActivity() {

        Intent intent = new Intent(this, QuizActivity.class);

        startActivity(intent);
    }


}
