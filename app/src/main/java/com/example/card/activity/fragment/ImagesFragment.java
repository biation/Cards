package com.example.card.activity.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.card.adapter.ImageAdapter;
import com.example.card.databinding.FragmentImagesBinding;
import com.example.card.model.Hit;
import com.example.card.viewmodel.PixaBayViewModel;

import java.util.ArrayList;

public class ImagesFragment extends BaseFragment<FragmentImagesBinding> {
    ImageAdapter adapter;
    PixaBayViewModel viewModel;
    private Handler handler;
    

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PixaBayViewModel.class);
//        viewModel = ViewModelProviders.of(requireParentFragment()).get(PixaBayViewModel.class);
        initListener();
        initAdapter();
    }

    private void initListener() {
        binding.imageEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (handler != null){
                    handler= null;
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.progressBar.setVisibility(View.VISIBLE);
                viewModel.getImages(binding.imageEd.getText().toString()).observe(getViewLifecycleOwner(), hits -> {
                    if (hits != null) {
                        binding.progressBar.setVisibility(View.GONE);
                        binding.recycler.setAdapter(adapter);
                        adapter.setData((ArrayList<Hit>) hits);
                    }
                });
                    }
                }, 2000);
            }
        });
    }

    private void initAdapter() {
        adapter = new ImageAdapter();
    }


    @Override
    FragmentImagesBinding bind() {
        return FragmentImagesBinding.inflate(getLayoutInflater());
    }
}