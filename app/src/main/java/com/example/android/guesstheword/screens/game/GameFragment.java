/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.guesstheword.databinding.GameFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Fragment where the game is played
 */
public class GameFragment extends Fragment {

    // The current word
    private String mWord;

    // The current score
    private int mScore;

    // The list of words - the front of the list is the next word to guess
    private List<String> mWordList;

    private GameFragmentBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = GameFragmentBinding.inflate(inflater);
        resetList();
        nextWord();
        mBinding.correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCorrect();
            }
        });
        mBinding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSkip();
            }
        });
        updateScoreText();
        updateWordText();
        return mBinding.getRoot();
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

    private void onSkip() {
        mScore--;
        nextWord();
    }

    private void onCorrect() {
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
        updateWordText();
        updateScoreText();
    }


    /** Methods for updating the UI **/

    private void updateWordText() {
        mBinding.wordText.setText(mWord);
    }

    private void updateScoreText() {
        mBinding.scoreText.setText(String.valueOf(mScore));
    }
}
