package com.example.macas.codemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class pedidos extends AppCompatActivity {

    private Long id;
    private Date data;
    private int status;
    private double valor;
    private int quantidade;


    public pedidos(){
        super();
    }


    public pedidos(Long id, Date data, double valor, int quantidade) {
        this.id = id;
        this.data = data;
        status = 1;
        this.valor = valor;
        this.quantidade = quantidade;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int sta) {
        if(sta < 2)
            status = sta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }



    Button btAddItens, btMenuPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos);

        btMenuPrincipal = (Button) findViewById(R.id.btMenuPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(pedidos.this, menu_principal.class);
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
                intent.setClass(pedidos.this, cardapio_ref.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
