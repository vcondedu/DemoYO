package com.example.demoyo;

import com.example.demoyo.clases.ClsEspecialidad;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EspecialidadService {
    @GET("especialidad/listarespecialidades")
    Call<List<ClsEspecialidad>> getEspecialidades();
}
