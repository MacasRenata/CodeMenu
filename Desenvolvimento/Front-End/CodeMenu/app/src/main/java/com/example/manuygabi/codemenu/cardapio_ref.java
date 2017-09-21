package com.example.manuygabi.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cardapio_ref extends AppCompatActivity {

    Button btCardapioBeb, btMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardapio_ref);


        btCardapioBeb = (Button) findViewById(R.id.btCardapioBeb);

        btCardapioBeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaBebida();
            }

            void chamaBebida() {
                Intent intent = new Intent();
                intent.setClass(cardapio_ref.this, cardapio_beb.class);
                startActivity(intent);
                finish();
            }
        });

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(cardapio_ref.this, menu_principal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
