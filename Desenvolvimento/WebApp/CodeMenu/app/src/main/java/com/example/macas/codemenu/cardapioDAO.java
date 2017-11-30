package com.example.macas.codemenu;

import android.provider.ContactsContract;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by macas on 30/11/17.
 */

public class cardapioDAO {

    private static final String TAG = cardapioDAO.class.getSimpleName();

    private static final String BASE_URL = "https://";

    private cardapioService service;

    public cardapioDAO() {
        Factory jsonFactory = GsonConverterFactory.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(jsonFactory)
                .build();

        this.service = retrofit.create(cardapioService.class);
    }

    public List<cardapio> readAllNotes() {   // mudança do '<ContactsContract.CommonDataKinds.Note>'
        Call<List<cardapio>> call = this.service.listCardapio();
        List<cardapio> notes = null;

        try {
            Response<List<cardapio>> res = call.execute();

            if (res.isSuccessful()) {
                notes = res.body();
            } else {
                String errorBody = res.errorBody().string();
                int errorCode = res.code();
                String errorMessage = res.message();

                Log.e(TAG, "Request not successful - "
                        + errorBody + ": "
                        + errorCode
                        + "(" + errorMessage + ")");
            }
        } catch (IOException exc){
            Log.e(TAG, "IO error during REST operation.", exc);
        }
        return notes;
    }

    public cardapio createNote(cardapio note) {
        Call<cardapio> call = this.service.createCardapio(note);  //alterado o tipo
        cardapio newNote = null;

        try {
            Response<cardapio> res = call.execute();

            if (res.isSuccessful()) {
                newNote = res.body();
            } else {
                String errorBody = res.errorBody().string();
                int errorCode = res.code();
                String errorMessage = res.message();

                Log.e(TAG, "Request not successful - "
                        + errorBody + ": "
                        + errorCode
                        + " (" + errorMessage + ")");
            }
        } catch (IOException exc) {
            Log.e(TAG, "IO error during REST operation.", exc);
        }
        return newNote;
    }
}
