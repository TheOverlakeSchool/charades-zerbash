package com.example.android.guesstheword.screens.score;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ScoreViewModelFactory implements ViewModelProvider.Factory {

    int mScore;

    public ScoreViewModelFactory(int score) {
        mScore = score;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ScoreViewModel(mScore);
    }
}
