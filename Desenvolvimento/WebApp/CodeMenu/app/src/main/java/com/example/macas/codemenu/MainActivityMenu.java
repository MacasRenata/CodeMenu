package com.example.macas.codemenu;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivityMenu extends AppCompatActivity {

    private static final int REQUEST_CREATE = 1;

    private class NoteLoaderTask extends AsyncTask<Void, Void, List<Note>> {

        @Override
        public List<Note> doInBackground(Void... params) {
            NoteDao dao = new NoteDao();
            List<Note> notes = null;

            notes = dao.readAllNotes();
            return notes;
        }

        @Override
        public void onPostExecute(List<Note> notes) {
            notesAdapter.addAll(notes);
        }
    }

    private ArrayAdapter<Note> notesAdapter;
    private ListView notesList;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        this.notesList = (ListView) findViewById(R.id.notesList);
        this.notesList.setAdapter(notesAdapter);
        this.notesList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                noteItemClicked(position);
            }
        });

        this.createButton = (Button) findViewById(R.id.createButton);
        this.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });

        new NoteLoaderTask().execute();
    }

    private void noteItemClicked(int position) {
        Note note = notesAdapter.getItem(position);
        Intent intent = new Intent(this, ViewNoteActivity.class);

        intent.putExtra("note", note);
        startActivity(intent);
    }

    private void createNewNote() {
        Intent intent = new Intent(this, CreateNoteActivity.class);

        startActivityForResult(intent, REQUEST_CREATE);
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode,
                                  Intent data) {
        if ((requestCode == REQUEST_CREATE)
                && (resultCode == Activity.RESULT_OK)) {
            Note newNote = (Note) data.getSerializableExtra("note");

            this.notesAdapter.add(newNote);
        }
    }

    /*

    Button btCardapio, btPedido, btPagamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        String url = "http://8080/";
        getWebservice2(url);




        btCardapio = (Button) findViewById(R.id.btCardapio);

        btCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(MainActivityMenu.this, cardapioPage.class);
                startActivity(intent);
                finish();

            }
        });


        btPedido = (Button) findViewById(R.id.btPedido);

        btPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPedido();
            }

            void chamaPedido() {
                Intent intent = new Intent();
                intent.setClass(MainActivityMenu.this, pedidoPage.class);
                startActivity(intent);
                finish();

            }
        });

        btPagamento = (Button) findViewById(R.id.btPagamento);

        btPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPagamento();
            }

            void chamaPagamento() {
                Intent intent = new Intent();
                intent.setClass(MainActivityMenu.this, pagamentoPage.class);
                startActivity(intent);
                finish();

            }
        });
    }*/
}
