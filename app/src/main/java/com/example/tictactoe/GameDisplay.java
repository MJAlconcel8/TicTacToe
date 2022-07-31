package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {

    private TicTacToeBoard ticTacToeBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        Button playagain = findViewById(R.id.button3);
        Button home = findViewById(R.id.button4);
        TextView playerTurn = findViewById(R.id.textView5);

        playagain.setVisibility(View.GONE);
        home.setVisibility(View.GONE);

        String[] playernames = getIntent().getStringArrayExtra("PLAYER_NAMES");

        if(playernames!= null){
            playerTurn.setText(playernames[0] + "'s Turn");
        }

        ticTacToeBoard = findViewById(R.id.ticTacToeBoard4);

        ticTacToeBoard.setUpGame(playagain, home, playerTurn, playernames);

    }
    public void playAgainButtonClick(View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();

    }
    public void homeButtonClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}