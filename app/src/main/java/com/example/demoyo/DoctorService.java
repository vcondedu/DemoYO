package com.example.demoyo;

import com.example.demoyo.clases.ClsDoctor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DoctorService {
    @GET("doctor/listardoctorestop")
    Call<List<ClsDoctor>> getDoctores();
}
