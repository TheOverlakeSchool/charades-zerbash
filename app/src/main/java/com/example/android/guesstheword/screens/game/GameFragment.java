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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.android.guesstheword.R;
import com.example.android.guesstheword.databinding.GameFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Fragment where the game is played
 */
public class GameFragment extends Fragment {

    private GameFragmentBinding mBinding;
    private GameViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = GameFragmentBinding.inflate(inflater);
        mViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        mBinding.correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.onCorrect();
                updated();
            }
        });
        mBinding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.onSkip();
                updated();
            }
        });
        mBinding.endGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameFinished();
            }
        });
        updated();
        return mBinding.getRoot();
    }

    private void gameFinished() {
        GameFragmentDirections.ActionGameToScore action = GameFragmentDirections.actionGameToScore();
        action.setScore(mViewModel.getScore());
        NavHostFragment.findNavController(this).navigate(action);
    }

    private void updated() {
        updateScoreText();
        updateWordText();
    }


    /** Methods for updating the UI **/

    private void updateWordText() {
        mBinding.wordText.setText(mViewModel.getWord());
    }

    private void updateScoreText() {
        mBinding.scoreText.setText(String.valueOf(mViewModel.getScore()));
    }
}
