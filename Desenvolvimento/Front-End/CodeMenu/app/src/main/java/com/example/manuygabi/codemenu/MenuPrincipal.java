package com.example.manuygabi.codemenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;


public class MenuPrincipal extends AppCompatActivity {

    Button btCardapio, btPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.MenuPrincipal);

        btCardapio = (Button) findViewById(R.id.btCardapio);

        btCardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapio();
            }

            void chamaCardapio() {
                Intent intent = new Intent();
                intent.setClass(MenuPrincipal.this, CardapioBeb.class);
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
                    intent.setClass(MenuPrincipal.this, Pedidos.class);
                    startActivity(intent);
                    finish();
                }
            });



}

}
