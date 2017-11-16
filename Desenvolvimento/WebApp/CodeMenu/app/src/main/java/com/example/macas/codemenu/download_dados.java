package com.example.macas.codemenu;

import android.os.AsyncTask;
import com.example.macas.codemenu.menu_principal;
import com.example.macas.codemenu.pedidos;
import com.example.macas.codemenu.webservice;
import com.example.macas.codemenu.cardapio_ref;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.ArrayAdapter;

/**
 * Created by macas on 13/11/17.
 */

public class download_dados extends AsyncTask<Object, Object, String> {

    private webservice.MainActivity<menu_principal> activity;

    public download_dados(menu_principal activity ){
        this.activity = new webservice<menu_principal>( activity );
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        activity.get().lockFields( true );
    }


    @Override
    protected String doInBackground(void item ) {
        // Esta etapa é usada para executar a tarefa em background ou fazer a chamada           para o webservice

        try{
            String jsonString = JsonRequest.request( activity.get().getUriRequest() );
            Gson gson = new Gson();

            return gson.fromJson(jsonString, Address.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /*
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String linha;
            StringBuffer buffer = new StringBuffer();
            while((linha = reader.readLine()) != null) {
                buffer.append(linha);
                buffer.append("\n");
            }

            return buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        return null;
    }

    */

    @Override
    protected void onPostExecute(String id) {
        // Faça alguma coisa com os dados

        super.onPostExecute(menu_principal);

        if( activity.get() != null ){
            activity.get().lockFields( false );

            if( menu_principal != null ){
                activity.get().setMenu_pricipalFields(address);
            }
        }
    }



}

    @Override
    protected void onPreExecute () {
        // Este passo é usado para configurar a tarefa, por exemplo, mostrando uma barra de progresso na interface do usuário.
    }

    @Override
    protected void onProgressUpdate (Progress... values) {
        // Este método é usado para exibir qualquer forma de progresso na interface do usuário, enquanto a tarefa ainda está em execução.
    }

    @Override
    protected void onPostExecute (Result result) {
        // O resultado da execução em background é passado para este passo como um parâmetro.
    }

}
