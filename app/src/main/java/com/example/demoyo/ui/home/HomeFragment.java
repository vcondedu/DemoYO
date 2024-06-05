package com.example.demoyo.ui.home;

import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoyo.DoctorService;
import com.example.demoyo.EspecialidadService;
import com.example.demoyo.clases.ClsDoctor;
import com.example.demoyo.clases.ClsEspecialidad;
import com.example.demoyo.databinding.FragmentHomeBinding;
import com.example.demoyo.Adapter.TrendsAdapter;
import com.example.demoyo.clases.ClsTrendsDomain;
import com.example.demoyo.R;

import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<ClsEspecialidad> especialidadesList = new ArrayList<>();  // Lista completa de datos
    private List<ClsEspecialidad> filteredList = new ArrayList<>();  // Lista filtrada que se mostrará

    private List<ClsDoctor> doctoresList = new ArrayList<>();  // Lista completa de datos
    //private List<ClsDoctor> filteredDoctoresList = new ArrayList<>();  // Lista filtrada que se mostrará

    //private RecyclerView.Adapter adapterTrends;
   // private RecyclerView recyclerViewTrends;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        fetchEspecialidades();
        fetchDoctorTop();

        //recyclerViewTrends = binding.view1;

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        //initRecyclerView();
        return root;
    }

    private void filter(String text) {
        filteredList.clear(); // limpia la lista filtrada anteriormente
        //filteredDoctoresList.clear();
        if (text.isEmpty()) {
            filteredList.addAll(especialidadesList); // si no hay texto, añade todos los elementos
            //filteredDoctoresList.addAll(doctoresList);
        } else {
            for (ClsEspecialidad item : especialidadesList) {
                if (item.getNombre_especialidad().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(item); // filtra según el nombre de la especialidad
                }
            }
        }
        //initRecyclerView();
        populateCards(filteredList); // actualiza las tarjetas con los elementos filtrados
    }
    public void fetchEspecialidades() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/") // Usa 10.0.2.2 para localhost desde el emulador de Android
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EspecialidadService service = retrofit.create(EspecialidadService.class);
        Call<List<ClsEspecialidad>> call = service.getEspecialidades();

        call.enqueue(new Callback<List<ClsEspecialidad>>() {
            @Override
            public void onResponse(Call<List<ClsEspecialidad>> call, Response<List<ClsEspecialidad>> response) {
                if (response.isSuccessful()) {
                    especialidadesList = response.body(); // Asegúrate de actualizar la lista principal
                    filteredList.clear();
                    filteredList.addAll(especialidadesList); // Inicializa la lista filtrada con todos los elementos
                    populateCards(filteredList); // Puebla la vista con la lista inicial
                }
            }

            @Override
            public void onFailure(Call<List<ClsEspecialidad>> call, Throwable t) {
                // Manejar fallo en la llamada
            }
        });
    }

    public void fetchDoctorTop() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/") // Usa 10.0.2.2 para localhost desde el emulador de Android
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DoctorService service = retrofit.create(DoctorService.class);
        Call<List<ClsDoctor>> call = service.getDoctores();

        call.enqueue(new Callback<List<ClsDoctor>>() {
            @Override
            public void onResponse(Call<List<ClsDoctor>> call, Response<List<ClsDoctor>> response) {
                if (response.isSuccessful()) {
                    doctoresList = response.body(); // Asegúrate de actualizar la lista principal
                    System.out.println("nombre:" + doctoresList.get(1).getNombre_solo());
                    populateDoctores(doctoresList);
                }
            }

            @Override
            public void onFailure(Call<List<ClsDoctor>> call, Throwable t) {
                // Manejar fallo en la llamada
            }
        });
    }
    private void populateCards(List<ClsEspecialidad> items) {
        LinearLayout layout = binding.linearLayoutCards;
        layout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (ClsEspecialidad item : items) {
            View cardView = inflater.inflate(R.layout.card_item, layout, false);
            ImageView imageView = cardView.findViewById(R.id.imageView11);
            TextView textView = cardView.findViewById(R.id.textView9);

            int resId = getResources().getIdentifier(item.getIcono_especialidad().replace(".png", ""), "drawable", getContext().getPackageName());
            imageView.setImageResource(resId);
            textView.setText(item.getNombre_especialidad());

            layout.addView(cardView);
        }
    }

    private void populateDoctores(List<ClsDoctor> items) {
        LinearLayout layout = binding.linearLayoutTopdoctors;
        layout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (ClsDoctor item : items) {
            String nombre = item.getNombre_solo();
            String apellido = item.getApellido_solo();
            String nombreFormateado = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
            String apellidoFormateado = apellido.substring(0, 1).toUpperCase() + apellido.substring(1).toLowerCase();
            System.out.println(item.getNombre_solo());
            View constraintLayout = inflater.inflate(R.layout.topdoctor_item, layout, false);
            //ImageView imageView = cardView.findViewById(R.id.imageViewdoc3); //imagen
            TextView textViewnom = constraintLayout.findViewById(R.id.textViewdocnom6); //nombre
            TextView textViewesp = constraintLayout.findViewById(R.id.textViewdocesp7); //especialidad
            TextView textViewhora = constraintLayout.findViewById(R.id.textViewclock8); //horario
            textViewnom.setText("Dr(a) " + nombreFormateado  +" " +  apellidoFormateado);
            textViewesp.setText(item.getNombre_especialidad());
            textViewhora.setText(item.getHorario_disponible());
            layout.addView(constraintLayout);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}