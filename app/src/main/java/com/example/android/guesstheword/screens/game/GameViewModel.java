package com.example.android.guesstheword.screens.game;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameViewModel extends ViewModel {

   // The current word
   private String mWord;

   public String getWord() {
      return mWord;
   }

   public int getScore() {
      return mScore;
   }

   // The current score
   private int mScore;

   // The list of words - the front of the list is the next word to guess
   private List<String> mWordList;

   public GameViewModel() {
      resetList();
      nextWord();
   }

   /**
    * Resets the list of words and randomizes the order
    */
   private void resetList() {
      mWordList = new ArrayList<>(Arrays.asList(
              "queen",
              "hospital",
              "basketball",
              "cat",
              "change",
              "snail",
              "soup",
              "calendar",
              "sad",
              "desk",
              "guitar",
              "home",
              "railway",
              "zebra",
              "jelly",
              "car",
              "crow",
              "trade",
              "bag",
              "roll",
              "bubble"
      ));
      Collections.shuffle(mWordList);
   }

   /** Methods for buttons presses **/

   public void onSkip() {
      mScore--;
      nextWord();
   }

   public void onCorrect() {
      mScore++;
      nextWord();
   }

   /**
    * Moves to the next word in the list
    */
   private void nextWord() {
      if (!mWordList.isEmpty()) {
         //Select and remove a word from the list
         mWord = mWordList.remove(0);
      }
   }

}
