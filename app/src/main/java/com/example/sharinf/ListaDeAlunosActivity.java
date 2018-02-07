package com.example.sharinf;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ilha1 on 07/02/2018.
 */

public class ListaDeAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_alunos);
        List<Aluno> alunos = todosOsCursos();

        ListView listaDeAlunos = (ListView) findViewById(R.id.lista);

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunos);

        listaDeAlunos.setAdapter(adapter);
    }


    private List<Aluno> todosOsCursos() {
        return new ArrayList<>(Arrays.asList(
                new Aluno("Aluno1", "CC", "1"),
                new Aluno("Aluno2", "CC", "2"),
                new Aluno("Aluno3", "CC", "3")));
    }

}
