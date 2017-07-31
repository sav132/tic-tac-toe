package com.example.savio.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//here 0 = o and 1= x

    int active = 0;
    int activePlayer=0;
    boolean gameIsActive = true;
    // 2 means unplayed and 1 means played
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};



    public void drop(View view) {

        ImageView counter = (ImageView) view;
        int tapcount = Integer.parseInt(counter.getTag().toString());
        int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

        if (gameState[tapcount] == 2) {
            gameState[tapcount] = active;

            counter.setTranslationY(-1000f);
            if (active == 0) {
                counter.setImageResource(R.drawable.o);
                active = 1;
            } else {
                counter.setImageResource(R.drawable.x);
                active = 0;
            }

        counter.animate().translationYBy(1000f).setDuration(300);
        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                    gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                    gameState[winningPosition[0]] != 2) {

                gameIsActive = false;
                String winner;
                if(gameState[winningPosition[0]]==1) {
                    winner = "X has won";
                }
                  else if (gameState[winningPosition[0]] == 0) {

                    winner = "O has won";

                   }
                else{
                    winner = "game is draw";
                }


                TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                winnerMessage.setText(winner );

                LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);

                layout.setVisibility(View.VISIBLE);

            }


        }
        }
    }





        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



        }
    }
