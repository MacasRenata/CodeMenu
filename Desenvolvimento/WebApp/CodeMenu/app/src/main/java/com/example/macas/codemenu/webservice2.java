package com.example.macas.codemenu;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by macas on 19/11/17.
 */

public class webservice2 {


    class JsonRequest {
        public String request(String uri) throws Exception {

            URL url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader r = new BufferedReader(new InputStreamReader(in));

            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                jsonString.append(line);
            }

            urlConnection.disconnect();

            return jsonString.toString();
        }
    }

}
