package com.example.macas.codemenu;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by macas on 30/11/17.
 */

public interface pagamentoService {

    @GET(" /listaPagamento ")
    Call<List<pagamento>> listaPagamento();
}
