package com.example.macas.codemenu;

import android.os.AsyncTask;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by macas on 19/11/17.
 */

public class asyncTask extends AsyncTask<Object, Object, String> {


    @Override
    protected String doInBackground(Object... params) {
        // Esta etapa é usada para executar a tarefa em background ou fazer a chamada           para o webservice


        return null;
    }

    @Override
    protected void onPostExecute(String id) {
        // Faça alguma coisa com os dados
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
