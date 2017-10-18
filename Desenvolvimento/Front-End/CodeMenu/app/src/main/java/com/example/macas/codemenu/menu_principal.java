package com.example.macas.codemenu;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class menu_principal extends AppCompatActivity {

    Button btCardapio, btPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.menu_principal);

        btCardapio = (Button) findViewById(R.id.btCardapio);

        btCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(menu_principal.this, cardapio_beb.class);
                startActivity(intent);
                finish();
            }

            public List<cardapio_ref> queryGetAll() {
                List<cardapio_ref> list = new ArrayList<cardapio_ref>();

                try {
                    Cursor cursor = this.chamaCardapio (TABLE_NAME,  new String[] {"nomeRef", "imgBD", "valor"},
                            null, null, null, null, null, null);
                    int nregistros = cursor.getCount();
                    if (nregistros!=0) {
                        cursor.moveToFirst();
                        do {
                            Cursor refeicao = new Cursor(cursor.getString(0), cursor.getString(1), cursor.getString(2)) {
                            };
                            list.add(refeicao);

                        }while (cursor.moveToNext());

                        if (cursor !=null && ! cursor.isClosed())
                            cursor.close();
                        return list;
                    }else
                        return null;
                }
                catch (Exception err) {
                    return null;
                }
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
                    intent.setClass(menu_principal.this, pedidos.class);
                    startActivity(intent);
                    finish();
                }
            });



}

}
