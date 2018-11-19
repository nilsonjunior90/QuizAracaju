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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.nilsonjunior90.quizaracaju.model.User;
import com.google.firebase.*;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference usersDatabase = database.getReference("users");

    EditText email_editText;
    EditText name_editText;
    EditText pass_editText;




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
            public void onClick(View view) {startLeaderBoardActivity();}});


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
        final View sing_in = inflater.inflate(R.layout.sing_in,null);

        //ligar os campos as variaveis
        email_editText = (EditText) sing_in.findViewById(R.id.email_edit);
        name_editText = (EditText) sing_in.findViewById(R.id.name_edit);
        pass_editText = (EditText) sing_in.findViewById(R.id.password_edit);


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
                String email = email_editText.getText().toString();
                String name = name_editText.getText().toString();
                String pass = pass_editText.getText().toString();

                final User user = new User(email,name,pass);





                // Read from the database
                usersDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot){
                        if (dataSnapshot.child(user.getKey()).exists()){
                            //fixme hardcoded string... O Usuario já existe
                            Toast.makeText(MainActivity.this,"O Usuario já existe",Toast.LENGTH_LONG).show();

                        }else {
                            usersDatabase.child(user.getKey()).setValue(user);
                            //fixme hardcoded string... Usuario Criado com Sucesso
                            Toast.makeText(MainActivity.this,"Usuario Criado com Sucesso",Toast.LENGTH_LONG).show();

                        }

                        //todo remover na versão final
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
//                        String value = dataSnapshot.getValue(String.class);
//                        Log.d("FireBase", "Value is: " + value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
//                        Log.w("FireBase", "Failed to read value.", error.toException());
                    }
                });




                Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_LONG).show();
            }
        });



        logInDialog.setView(sing_in);

        logInDialog.show();
    }


}
