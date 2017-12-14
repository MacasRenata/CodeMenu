package com.example.macas.codemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class PedidoActivity extends AppCompatActivity {

    private static final int REQUEST_CREATE = 1;

    private class pedidoTask extends AsyncTask<Void, Void, List<pedido>> {

        @Override
        public List<pedido> doInBackground(Void... params) {
            pedidoDAO dao = new pedidoDAO();
            List<pedido> pedidoList = null;

            pedidoList = dao.listarPedido();
            return pedidoList;
        }

        @Override
        public void onPostExecute(List<pedido> pedidoList) {
            pedidoArrayAdapter.addAll();
        }
    }

    private ArrayAdapter<pedido> pedidoArrayAdapter;
    ListView listaPedido;

    Button btPedir, btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);


        btPedir = (Button) findViewById(R.id.btPedir);

        btPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaPedido();
            }

            void chamaPedido() {
                Intent intent = new Intent();
                intent.setClass(PedidoActivity.this, PagamentoActivity.class);
                startActivity(intent);
                finish();

            }
        });

        btSair = (Button) findViewById(R.id.btSair);

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamaMenuPrincipal();
            }

            void chamaMenuPrincipal() {
                Intent intent = new Intent();
                intent.setClass(PedidoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
/*

        pedido ped = (pedido) super.getIntent().getSerializableExtra("pedido");
        ListView nome = (ListView) findViewById(R.id.listaItem);
        ListView tipo = (ListView) findViewById(R.id.listaItem);
        ListView preco = (ListView) findViewById(R.id.listaItem);
        ListView urlImagem = (ListView) findViewById(R.id.listaItem);

        nome.setFilterText(cardapio.class.getName());
        tipo.setFilterText(cardapio.class.getName());
        preco.setFilterText(cardapio.class.getName());
        urlImagem.setFilterText(cardapio.class.getName());

    }*/

        this.pedidoArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        this.listaPedido = (ListView) findViewById(R.id.listaPedido);
        this.listaPedido.setAdapter(pedidoArrayAdapter);
        this.listaPedido.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                PedidoSelecionado(position);
            }
        });


        new pedidoTask().execute();
    }

    private void PedidoSelecionado(int position) {
        pedido ped = pedidoArrayAdapter.getItem(position);
        Intent intent = new Intent(this, PagamentoActivity.class);

        intent.putExtra("pedido", ped);
        startActivity(intent);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        if ((requestCode == REQUEST_CREATE)
                && (resultCode == Activity.RESULT_OK)) {
            pedido newPedido = (pedido) data.getSerializableExtra("pedido");

            this.pedidoArrayAdapter.add(newPedido);
        }


    }

}
