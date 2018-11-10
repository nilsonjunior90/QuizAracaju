package com.github.nilsonjunior90.quizaracaju;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LeaderBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //todo - consulta dinamica de dados
        final ListView record_list = (ListView) findViewById(R.id.leader_board_listView);

        String[] values = new String[] { "999 Rosa Faria", "950 Araripe Coutinho", "900 Gumersindo Bessa",
                "800 Tobias Barreto", "768 João Ribeiro"};

        final ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        //todo - adapter personalizado
        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);

        record_list.setAdapter(adapter);
    }

}
