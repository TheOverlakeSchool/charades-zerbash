package com.example.android.guesstheword.screens.score;

import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    public int getScore() {
        return mScore;
    }

    int mScore;

   public ScoreViewModel(int score) {
       mScore = score;
   }
}
