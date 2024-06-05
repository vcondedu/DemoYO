package com.example.demoyo;
import com.example.demoyo.clases.ClsEspecialidad;
import com.example.demoyo.clases.ClsUsuario;
import com.example.demoyo.clases.ClsUsuarioRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {
    @POST("validarusuario")
    Call<ClsUsuario> VALIDARUSUARIO(@Body ClsUsuarioRequest usuarioRequest);
};

;