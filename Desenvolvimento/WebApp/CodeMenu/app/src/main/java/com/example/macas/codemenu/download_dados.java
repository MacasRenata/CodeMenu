package com.example.macas.codemenu;

import com.example.macas.codemenu.webservice;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by macas on 13/11/17.
 */

public class download_dados extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... params) {
        // Esta etapa é usada para executar a tarefa em background ou fazer a chamada           para o webservice
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL("http://pokeapi.co/api/v2/pokemon/1/");
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

    @Override
    protected void onPostExecute(String dados) {
        // Faça alguma coisa com os dados

        protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);

            Trend trend = (Trend)l.getAdapter().getItem(position);

            Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(trend.url));
            startActivity(it);
        }

        protected List<Trend> doInBackground(String... params) {
            String urlString = params[0];

            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(urlString);

            try {
                HttpResponse response = httpclient.execute(httpget);

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream instream = entity.getContent();

                    String json = toString(instream);
                    instream.close();

                    List<Trend> trends = getTrends(json);

                    return trends;
                }
            } catch (Exception e) {
                Log.e("DEVMEDIA", "Falha ao acessar Web service", e);
            }
            return null;
        }

        private List<Trend> getTrends(String jsonString) {

            List<Trend> trends = new ArrayList<Trend>();

            try {
                JSONArray trendLists = new JSONArray(jsonString);
                JSONObject trendList = trendLists.getJSONObject(0);
                JSONArray trendsArray = trendList.getJSONArray("trends");

                JSONObject trend;

                for (int i = 0; i < trendsArray.length(); i++) {
                    trend = new JSONObject(trendsArray.getString(i));

                    Log.i("DEVMEDIA", "nome=" + trend.getString("name"));

                    Trend objetoTrend = new Trend();
                    objetoTrend.name = trend.getString("name");
                    objetoTrend.url = trend.getString("url");

                    trends.add(objetoTrend);
                }
            } catch (JSONException e) {
                Log.e("DEVMEDIA", "Erro no parsing do JSON", e);
            }

            return trends;
        }


    protected void onPostExecute(List<Trend> result) {
        super.onPostExecute(result);
        dialog.dismiss();
        if (result.size() > 0) {
            ArrayAdapter<Trend> adapter = new ArrayAdapter<Trend>(
                    ConsumirJsonTwitterActivity.this,
                    android.R.layout.simple_list_item_1, result);
            setListAdapter(adapter);

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    ConsumirJsonTwitterActivity.this).setTitle("Atenção")
                    .setMessage("Não foi possivel acessar essas informções...")
                    .setPositiveButton("OK", null);
            builder.create().show();
        }
    }

    private String toString(InputStream is) throws IOException {

        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }
}

}

class Trend {
    String name;
    String url;

    @Override
    public String toString() {
        return name;
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
