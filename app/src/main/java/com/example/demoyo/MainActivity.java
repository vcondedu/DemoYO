package com.example.demoyo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.demoyo.ui.agendar.AgendarFragment;
import com.example.demoyo.ui.home.HomeFragment;
import com.example.demoyo.ui.miscitas.MiscitasFragment;
import com.example.demoyo.ui.perfil.PerfilFragment;
import com.example.demoyo.ui.proximascitas.ProximascitasFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.demoyo.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //replaceFragment(new HomeFragment());

        binding.navView.setBackground(null);
        binding.navView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.navigation_home) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.navigation_miscitas) {
                replaceFragment(new MiscitasFragment());
            } else if (item.getItemId() == R.id.navigation_agendar) {
                replaceFragment(new AgendarFragment());
            } else if (item.getItemId() == R.id.navigation_proximascitas) {
                replaceFragment(new ProximascitasFragment());
            } else if (item.getItemId() == R.id.navigation_perfil) {
                replaceFragment(new PerfilFragment());
            } else {
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }

            return true;
        });

        binding.fabAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new AgendarFragment());
            }
        });
    }
    private  void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commitNow();
    }
}