package com.example.card.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.card.model.Hit;
import com.example.card.repository.PixaBayRepository;

import java.util.List;

public class PixaBayViewModel extends ViewModel {

    public MutableLiveData<List<Hit>> hitMutableLiveData = new MutableLiveData<>();

    PixaBayRepository repository = PixaBayRepository.getInstance();


    public MutableLiveData<List<Hit>> getImages(String word) {
       hitMutableLiveData = repository.getImages(word);
       return hitMutableLiveData;
    }
}
