package com.example.android.guesstheword.screens.game;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {
   public GameViewModel() {
      Log.i("GameViewModel", "GameViewModel created!");
   }

   @Override
   protected void onCleared() {
      super.onCleared();
      Log.i("GameViewModel", "GameViewModel destroyed");
   }
}
