package com.example.macas.codemenu;

import android.os.AsyncTask;

import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class cardapio extends AsyncTask<Void, Void, String> {

    private Long id;
    private String nome;
    private int tipo;
    private double preco;
    private String urlImagem;

    MainActivity context;
    private String retorno;
    ArrayList<cardapio> item;


    public cardapio(){
        super();
    }

    public cardapio(Long id, String nome, int tipo, double preco, String urlImagem) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.urlImagem = urlImagem;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected String doInBackground(Void... params) {
     //   webservice2 client = new webservice2("http://8080.COdeMenu.java/cardapio/item/"+context.id);
    //    retorno = client.JsonRequest();
        return retorno;
    }

    protected void onPostExecute(String results) {
        if (results != null) {
            String id;
            String nome;
            item = new ArrayList<cardapio>();
            try { //Aqui funciona
                JSONObject obj = new JSONObject(results);
                for (int i = 0; i < obj.length(); i++) {
                //    cardapio.execute(item); = obj.getJSONArray("" + i);
              //      JSONObject obj2 = new JSONObject(item);
                    //nome= obj2.getString("nome");
            //        JSONObject.add(new cardapio(obj2.getString("nome"), obj2.getString("id")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        //    ArrayAdapter<cardapio> ad = new PageCardapio(context, R.layout.page_cardapio, item);
       //     context.lv.setAdapter(ad);
       //     context.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           //     @Override
          //      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //        Intent intencao = new Intent(context, ListView.class);
            //        intencao.putExtra("id", item.get(position).cod);
            //        intencao.putExtra("img", context.id);
             //       context.btCardapio.getAccessibilityClassName(cardapio).toString();
          //      }
         //   });

        }

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


}
