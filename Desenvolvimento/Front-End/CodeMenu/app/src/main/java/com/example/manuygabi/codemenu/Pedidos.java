package com.example.manuygabi.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pedidos extends AppCompatActivity {

    Button btAddItens, btMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Pedidos);

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(Pedidos.this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        btAddItens = (Button) findViewById(R.id.btAddItens);

        btAddItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapioRef();
            }

            void chamaCardapioRef() {
                Intent intent = new Intent();
                intent.setClass(Pedidos.this, CardapioRef.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
