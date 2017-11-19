package com.example.macas.codemenu;

import android.os.AsyncTask;

/**
 * Created by macas on 19/11/17.
 */

public class asyncTask extends AsyncTask<Object, Object, String> {


    @Override
    protected String doInBackground(Object... params) {
        // Esta etapa é usada para executar a tarefa em background ou fazer a chamada           para o webservice

/*

        try{
            String jsonString = JsonRequest.request( activity.get().getUriRequest() );
            Gson gson = new Gson();

            return gson.fromJson(jsonString, Address.class);
        }
        catch (Exception e){
            e.printStackTrace();
        } */

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
/*
        super.onPostExecute(menu_principal);

        if( activity.get() != null ){
            activity.get().lockFields( false );

            if( menu_principal != null ){
                activity.get().setMenu_pricipalFields(address);
            }
        } */
    }


    @Override
    protected void onPreExecute() {
        // Este passo é usado para configurar a tarefa, por exemplo, mostrando uma barra de progresso na interface do usuário.
    }
/*
    @Override
    protected void onProgressUpdate() {
        // Este método é usado para exibir qualquer forma de progresso na interface do usuário, enquanto a tarefa ainda está em execução.
    }

    @Override
    protected void onPostExecute() {
        // O resultado da execução em background é passado para este passo como um parâmetro.
    }
*/

}
