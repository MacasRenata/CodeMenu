package com.example.macas.codemenu;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ListView;

public class cardapioPage extends AppCompatActivity {

    ListView lv;
    String id;

    Button btConfirma, btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);
/*
        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");
        lv = (ListView)findViewById(R.id.listItem);
        cardapio rede = new cardapio();
       // rede.context = this;
        rede.execute();
    }

    public boolean onCreateOptionsMenu(Menu item) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.id.listItem, onOptionsItemSelected(item));  pq nao adiciona item selecionado na lista??
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btConfirma) {
            Intent intent = new Intent(this, asyncTask.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    } */

        btConfirma = (Button) findViewById(R.id.btConfirma);

        btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(cardapioPage.this, pedidoPage.class);
                startActivity(intent);
                finish();

            }
        });

        btSair = (Button) findViewById(R.id.btSair);

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(cardapioPage.this, MainActivityMenu.class);
                startActivity(intent);
                finish();

            }
        });

    }

}
