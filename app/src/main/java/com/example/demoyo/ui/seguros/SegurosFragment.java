package com.example.demoyo.ui.seguros;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoyo.databinding.FragmentSegurosBinding;

public class SegurosFragment extends Fragment {

    private FragmentSegurosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SegurosViewModel segurosViewModel =
                new ViewModelProvider(this).get(SegurosViewModel.class);

        binding = FragmentSegurosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSeguros;
        segurosViewModel.getText().observe(getViewLifecycleOwner(),  new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
                Log.d("SegurosFragment", "Data changed in ViewModel, new text: " + s);
            }
        });
        Log.d("SegurosFragment", "Fragment View created");
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}