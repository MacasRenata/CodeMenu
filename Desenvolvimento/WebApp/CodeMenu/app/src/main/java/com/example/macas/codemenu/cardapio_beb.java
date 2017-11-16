package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cardapio_beb extends AppCompatActivity {


    private Long id;
    private String nome;
    private int tipo;
    private double preco;
    private String urlImagem;


    public cardapio_beb(){
        super();
    }

    public cardapio_beb(Long id, String nome, int tipo, double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.urlImagem = urlImagem;

        //necessario fazer o filtro posteriormente
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button btMenuPrincipal, btCardapioRef, btPedidoCozinha;

        setContentView(R.layout.cardapio_beb);

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(cardapio_beb.this, menu_principal.class);
                startActivity(intent);
                finish();
            }
        });

        btCardapioRef = (Button) findViewById(R.id.btCardapioBeb);

        btCardapioRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaCardapioRef();
            }

            void chamaCardapioRef() {
                Intent intent = new Intent();
                intent.setClass(cardapio_beb.this, cardapio_ref.class);
                startActivity(intent);
                finish();
            }
        });

        btPedidoCozinha = (Button) findViewById(R.id.btConfirmaPedido);

        btPedidoCozinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPedidoCozinha();
            }

            void chamaPedidoCozinha() {
                Intent intent = new Intent();
                intent.setClass(cardapio_beb.this, pedidos.class); // Aqui precisa alterar para a chamada @Cozinha do sistema
                startActivity(intent);
                finish();
            }
        });
    }
}
