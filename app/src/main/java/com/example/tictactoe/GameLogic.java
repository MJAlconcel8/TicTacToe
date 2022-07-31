package com.example.tictactoe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {
    private int[][] gameboard;

    private String[] playername = {"Player 1", "Player 2"};

    private Button playagain;
    private Button home;
    private TextView playerturn;

    private int player = 1;

    GameLogic(){
        gameboard = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                gameboard[i][j] = 0;
            }
        }
    }

    public boolean updateGameBoard(int row, int col){
        if(gameboard[row-1][col-1]==0){
            gameboard[row-1][col-1] = player;

            if(player==1){
                playerturn.setText((playername[1] + "'s Turn"));
            }
            else{
                playerturn.setText((playername[0] + "'s Turn"));
            }
            return true;
        }
        else{
            return false;
        }
    }

    public boolean winnerCheck(){
        boolean isWinner = false;
        for(int i=0; i<3; i++){
            if(gameboard[i][0]==gameboard[i][1] && gameboard[i][0] == gameboard[i][2] &&
                    gameboard[i][0]!=0){
                isWinner = true;
            }
        }
        for(int j=0; j<3; j++){
            if(gameboard[j][0]==gameboard[j][1] && gameboard[j][0] == gameboard[j][2] &&
                    gameboard[j][0]!=0)
            {
                isWinner = true;
            }
        }
        if(gameboard[0][0]==gameboard[1][1] && gameboard[0][0] == gameboard[2][2] &&
                gameboard[0][0]!=0){
            isWinner = true;
        }
        if(gameboard[2][0]==gameboard[1][1] && gameboard[2][0] == gameboard[0][2] &&
                gameboard[2][0]!=0){
            isWinner = true;
        }

        int boardFilled = 0;
        for(int i=0; i>3; i++){
            for(int j=0; j<3; j++){
                if(gameboard[i][j]!=0){
                    boardFilled += 1;
                }
            }
        }
        if(isWinner){
            playagain.setVisibility(View.VISIBLE);
            home.setVisibility(View.VISIBLE);
            playerturn.setText((playername[player-1]) + "Won!!!!!");
            return true;
        }
        else if(boardFilled == 9){
            playagain.setVisibility(View.VISIBLE);
            home.setVisibility(View.VISIBLE);
            playerturn.setText("Tie Game!!!!!");
            return true;
        }
        else{
            return false;
        }
    }

    public void resetGame(){
       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               gameboard[i][j] = 0;
           }
       }
       player = 1;
       playagain.setVisibility(View.GONE);
       home.setVisibility(View.GONE);
       playerturn.setText((playername[0] + "'s turn"));
    }


    public void setPlayagain(Button playagain) {
        this.playagain = playagain;
    }


    public void sethome(Button home) {
        this.home = home;
    }

    public void setPlayerturn(TextView playerturn) {
        this.playerturn = playerturn;
    }

    public void setPlayername(String[] playername) {
        this.playername = playername;
    }

    public int[][] getGameboard() {
        return gameboard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }
}
