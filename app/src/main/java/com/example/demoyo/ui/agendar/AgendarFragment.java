package com.example.demoyo.ui.agendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoyo.databinding.FragmentAgendarBinding;

public class AgendarFragment extends Fragment {

    private FragmentAgendarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AgendarViewModel agendarViewModel =
                new ViewModelProvider(this).get(AgendarViewModel.class);

        binding = FragmentAgendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textAgendar;
        //agendarViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}