package com.github.nilsonjunior90.quizaracaju;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_login);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogInForm();
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

    private void showLogInForm(){
        AlertDialog.Builder logInDialog = new AlertDialog.Builder(MainActivity.this);
        logInDialog.setCancelable(true);
        logInDialog.setTitle("Login"); //todo string id "dialogo login"
        logInDialog.setMessage("Cadastre-se ou entre com seu e-mail e senha."); //todo string


        LayoutInflater inflater = this.getLayoutInflater();
        View sing_in = inflater.inflate(R.layout.sing_in,null);

        //todo ligar os campos as variaveis


       //cancelar                    //todo string
        logInDialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG).show();//todo remover isso na versão final
            }
        });

        //OK
        logInDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo firebase criar usuario.
                Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_LONG).show();
            }
        });



        logInDialog.setView(sing_in);

        logInDialog.show();
    }


}
