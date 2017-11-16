package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cardapio_ref extends AppCompatActivity {

    private Long id;
    private String nome;
    private int tipo;
    private double preco;
    private String urlImagem;


    public cardapio_ref(){
        super();
    }

    public cardapio_ref(Long id, String nome, int tipo, double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.urlImagem = urlImagem;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }




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
