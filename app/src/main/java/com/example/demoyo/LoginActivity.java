package com.example.demoyo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demoyo.clases.ClsUsuario;
import com.example.demoyo.clases.ClsUsuarioRequest;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtEmail;
    EditText txtPassword;
    Button btnIngresar;
    HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        btnIngresar.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        String email = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        if (!email.isEmpty() && !password.isEmpty()) {
            ClsUsuarioRequest usuarioRequest = new ClsUsuarioRequest(email, password);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(loggin);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:3000/usuario/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            ApiClient validarusuario=retrofit.create(ApiClient.class);

            Call<ClsUsuario> call=validarusuario.VALIDARUSUARIO(usuarioRequest);
            call.enqueue(new Callback<ClsUsuario>() {
                @Override
                public void onResponse(Call<ClsUsuario> call, Response<ClsUsuario> response) {
                    txtEmail.getText().clear();
                    txtPassword.getText().clear();
                    //System.out.println(response);
                    if(response.isSuccessful() && response.body() != null && response.code() ==  200){
                        /*startActivity(R.layout.activity_main);*/
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        btnIngresar.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                        finish();
                    }else if( response.code() ==  201){
                        Toast.makeText(getApplicationContext(),"No existe el usuario:"+email+" , por favor registrese",Toast.LENGTH_SHORT).show();
                    }else if( response.code() ==  202){
                        Toast.makeText(getApplicationContext(),"Datos incorrectos",Toast.LENGTH_SHORT).show();
                    }
                    btnIngresar.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(Call<ClsUsuario> call, Throwable throwable) {
                    btnIngresar.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),throwable.getMessage(),Toast.LENGTH_LONG).show();
                }
            });

        } else {
            btnIngresar.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Email o contraseña vacíos", Toast.LENGTH_SHORT).show();
        }

    }
}