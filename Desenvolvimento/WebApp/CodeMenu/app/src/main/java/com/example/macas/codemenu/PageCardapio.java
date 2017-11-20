package com.example.macas.codemenu;


import com.example.macas.codemenu.cardapio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class PageCardapio extends AppCompatActivity {

    ListView lv;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_cardapio);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("id");
        lv = (ListView)findViewById(R.id.item);
        cardapio rede = new cardapio();
        rede.context = this;
        rede.execute();
    }

    public boolean onCreateOptionsMenu(Menu item) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.id.btConfirma, onOptionsItemSelected(item));
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
    }

}
