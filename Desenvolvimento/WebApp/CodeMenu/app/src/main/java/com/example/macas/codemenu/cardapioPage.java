package com.example.macas.codemenu;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;
import java.util.ListIterator;

import static android.R.id.list;


public class cardapioPage extends AppCompatActivity {


    //talvez fazer metodo da lista aqui
    private class cardapioPageTask extends AsyncTask<cardapio, Void, Void> {

        @Override
        public Void doInBackground(cardapio... params) {
            cardapioDAO dao = new cardapioDAO();

            dao.createNote(params[0]);
            return null;
        }

        @Override
        public void onPostExecute(Void notes) {
            Intent intent = new Intent();

            intent.putExtra("cardapio", cardapio.class);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }

    private cardapio card;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);

        this.card = new cardapio();
        this.card = (ListView) findViewById(R.id.card.id);
        this.listaItem.setOnClickListener(listaItem.getAdapter().getItem(id, list));


        this.btConfirma = (Button) findViewById(R.id.btConfirma);
        this.btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedidoSalvo();
            }
        });
    }

        private void pedidoSalvo() {
        this.listaItem.setOnClickListener(this.listaItem.getOnItemClickListener(listaItem));
        this.listaItem.getAdapter(this.listaItem.getAdapter().toString()); //.getText().toString());

       new cardapioPageTask().execute(this.listaItem);

    }



}
