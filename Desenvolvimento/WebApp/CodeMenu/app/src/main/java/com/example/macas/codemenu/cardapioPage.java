package com.example.macas.codemenu;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;

import static android.R.id.list;
import android.widget.ArrayAdapter;


public class cardapioPage extends AppCompatActivity {
    private static final int REQUEST_CREATE = 1;

    private class NoteLoaderTask extends AsyncTask<Void, Void, List<cardapio>> {

        @Override
        public List<cardapio> doInBackground(Void... params) {
            cardapioDAO dao = new cardapioDAO();
            List<cardapio> cardapioList = null;

            cardapioList = dao.listarCardapio();
            return cardapioList;
        }

        @Override
        public void onPostExecute(List<cardapio> cardapioList) {
            cardapioArrayAdapter.addAll();
        }
    }

    private ArrayAdapter<cardapio> cardapioArrayAdapter;
    private ListView listaItem;
    private Button btConfirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);

        this.cardapioArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        this.listaItem = (ListView) findViewById(R.id.listaItem);
        this.listaItem.setAdapter(cardapioArrayAdapter);
        this.listaItem.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                noteItemClicked(position);
            }
        });

        this.btConfirma = (Button) findViewById(R.id.btConfirma);
        this.btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewNote();
            }
        });

        new NoteLoaderTask().execute();
    }

    private void noteItemClicked(int position) {
        cardapio itens = cardapioArrayAdapter.getItem(position);
        Intent intent = new Intent(this, cardapioActivity.class);

        intent.putExtra("cardapio", itens);
        startActivity(intent);
    }

    private void createNewNote() {
        Intent intent = new Intent(this, cardapioPage.class);

        startActivityForResult(intent, REQUEST_CREATE);
    }

    @Override
    public void onActivityResult (int requestCode, int resultCode,
                                  Intent data) {
        if ((requestCode == REQUEST_CREATE)
                && (resultCode == Activity.RESULT_OK)) {
            cardapio newCardapio = (cardapio) data.getSerializableExtra("cardapio");

            this.cardapioArrayAdapter.add(newCardapio);
        }
    }
}



































