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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;

import static android.R.id.list;


public class cardapioPage extends AppCompatActivity {


    //talvez fazer metodo da lista aqui
    private class cardapioPageTask extends AsyncTask<cardapio, Void, Void> {

        @Override
        public Void doInBackground(cardapio... params) {
            cardapioDAO dao = new cardapioDAO();

            dao.listarCardapio(params[0]);
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
    private cardapioDAO cardList;
    private cardapioService cardServ;
    private ListView listaItem;
    private Button btConfirma;
    private Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);

        this.card = new cardapio();
        this.listaItem = (ListView) findViewById(R.id.listaItem);
        this.listaItem.setOnClickListener(cardList.enviarPedido());


        this.btConfirma = (Button) findViewById(R.id.btConfirma);
        this.btConfirma.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               enviarPedido();
            }
       });
    }

        private void pedidoSalvo() {
        this.listaItem.setOnClickListener(this.listaItem.getOnItemClickListener(listaItem));
        this.listaItem.getAdapter(this.listaItem.getOnItemClickListener()); //.getText().toString());

       new cardapioPageTask().execute(this.listaItem);

    }



}
