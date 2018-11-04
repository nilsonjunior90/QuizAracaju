package com.github.nilsonjunior90.quizaracaju;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;



/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashScreenActivity extends AppCompatActivity {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_splash_screen);
        mContentView = findViewById(R.id.fullscreen_content);

        mContentView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);





        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });


       //FIXME
       /* Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startMainActivity();
            }
        };

        timer.schedule(task,2000);*/


    }


    private void startMainActivity() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Start Quiz",
                Toast.LENGTH_SHORT);

        toast.show();

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


}
