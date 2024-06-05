package com.example.demoyo.ui.proximascitas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoyo.databinding.FragmentProximascitasBinding;

public class ProximascitasFragment extends Fragment {

    private FragmentProximascitasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProximascitasViewModel proximascitasViewModel =
                new ViewModelProvider(this).get(ProximascitasViewModel.class);

        binding = FragmentProximascitasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textProximascitas;
        //proximascitasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}