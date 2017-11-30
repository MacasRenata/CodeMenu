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

import java.util.List;


public class MainActivityMenu extends AppCompatActivity {

    Button btCardapio, btPedido, btPagamento;

    private static final int REQUEST_CREATE = 1;

    private class NoteLoaderTask extends AsyncTask<Void, Void, List<cardapio>> {

        @Override
        public List<cardapio> doInBackground(Void... params) {
            cardapioDAO dao = new cardapioDAO();
            List<cardapio> cardapios = null;

            cardapios = dao.readAllNotes();
            return cardapios;
        }

        @Override
        public void onPostExecute(List<cardapio> notes) {
            notesAdapter.addAll(notes);
        }
    }

    private ArrayAdapter<cardapio> notesAdapter;
    private ListView notesList;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        this.notesList = (ListView) findViewById(R.id.listItem);
        this.notesList.setAdapter(notesAdapter);
        this.notesList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                setBtCardapio(position);
            }
        });

        this.createButton = (Button) findViewById(R.id.btCardapio);
        this.createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewCardapio();
            }
        });

        new NoteLoaderTask().execute();
    }

    private void setBtCardapio(int position) {
        cardapio note = notesAdapter.getItem(position);
        Intent intent = new Intent(this, cardapioPage.class);

        intent.putExtra("cardapio", cardapio.class);
        startActivity(intent);
    }

    private void createNewCardapio() {
        Intent intent = new Intent(this, cardapioActivity.class);

        startActivityForResult(intent, REQUEST_CREATE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        if ((requestCode == REQUEST_CREATE)
                && (resultCode == MainActivityMenu.RESULT_OK)) {
            cardapio newNote = (cardapio) data.getSerializableExtra("cardapio");

            this.notesAdapter.add(newNote);
        }
    }
    

}
