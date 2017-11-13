package com.example.macas.codemenu;

import com.example.macas.codemenu.download_dados;

import org.xmlpull.v1.XmlPullParserException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/*
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

*/
/**
 * Created by macas on 02/10/17.
 */

public class webservice {

    public class MainActivity extends menu_principal {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.menu_principal);

            URL url = new URL("http://pokeapi.co/api/v2/pokemon/1/");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha;
            StringBuffer buffer = new StringBuffer();
            while ((linha = reader.readLine()) != null) {
                buffer.append(linha + "\n");
            }

            if (buffer.length() == 0) {
                return null;
            }

            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (reader != null) {

                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("Erro", "Erro fechando o stream", e);
                }

            }

        }

    }


}



