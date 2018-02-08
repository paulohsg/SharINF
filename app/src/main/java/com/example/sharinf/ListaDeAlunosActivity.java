package com.example.sharinf;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilha1 on 07/02/2018.
 */

public class ListaDeAlunosActivity extends Activity {

    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_alunos);

        Aluno aluno_data[] = new Aluno[]
                {
                        new Aluno(R.drawable.profile_icon, "João"),
                        new Aluno(R.drawable.profile_icon, "Pedro"),
                        new Aluno(R.drawable.profile_icon, "José"),
                        new Aluno(R.drawable.profile_icon, "Augusto"),
                        new Aluno(R.drawable.profile_icon, "Leonardo")
                };

        AlunoAdapter adapter = new AlunoAdapter(this,
                R.layout.alunos_list_item, aluno_data);

        listView1 = (ListView)findViewById(R.id.lista);

        View header = (View)getLayoutInflater().inflate(R.layout.profile_header, null);
        listView1.addHeaderView(header);

        listView1.setAdapter(adapter);
    }

}
