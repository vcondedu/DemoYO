package com.example.demoyo.ui.miscitas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.demoyo.databinding.FragmentMiscitasBinding;

public class MiscitasFragment extends Fragment {

    private FragmentMiscitasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MiscitasViewModel miscitasViewModel =
                new ViewModelProvider(this).get(MiscitasViewModel.class);

        binding = FragmentMiscitasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textMicitas;
        //miscitasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}