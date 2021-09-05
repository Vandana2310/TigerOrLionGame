package com.example.tigerorlion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    private GridLayout mGridLayout;
    enum Player {

        ONE , TWO ,NO

    }

    Player currentPlayer = Player.ONE;

       Player[] playerChoices= new Player[9];
       int [][] winnerRowsAndColumn ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
       private boolean gameOver = false;
       Button btnReset;
       
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        playerChoices[0]=Player.NO;
//        playerChoices[1]=Player.NO;
//        playerChoices[2]=Player.NO;
//        playerChoices[3]=Player.NO;
//        playerChoices[4]=Player.NO;
//        playerChoices[5]=Player.NO;
//        playerChoices[6]=Player.NO;
//        playerChoices[7]=Player.NO;
//        playerChoices[8]=Player.NO;

        mTextView =findViewById(R.id.textView);
        mTextView.animate().rotationX(40).translationY(50).setDuration(3000);

        for(int index = 0 ;index<playerChoices.length;index++){
            playerChoices[index] =Player.NO;
        }

        btnReset=findViewById(R.id.btnReset);
        mGridLayout=findViewById(R.id.gridLayout);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             resetTheGame();
            }
        });


    }

    public void imgViewISTapped(View imgView){

        ImageView tappedImgView =(ImageView)imgView;

        int tiTag =Integer.parseInt(tappedImgView.getTag().toString());

        if(playerChoices[tiTag]==Player.NO && gameOver==false) {
            tappedImgView.setTranslationX(-2000);


            playerChoices[tiTag] = currentPlayer;

            if (currentPlayer == Player.ONE) {
                tappedImgView.setImageResource(R.drawable.lion);
                currentPlayer = Player.TWO;
            } else if (currentPlayer == Player.TWO) {
                tappedImgView.setImageResource(R.drawable.tiger);
                currentPlayer = Player.ONE;
            }
            tappedImgView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
//
//            for (int[] winnerColumn : winnerRowsAndColumn) {
//
//                if (playerChoices[winnerColumn[0]] == playerChoices[winnerColumn[1]] &&
//                        playerChoices[winnerColumn[1]] == playerChoices[winnerColumn[2]] && playerChoices[winnerColumn[0]] != Player.NO) {
//                        btnReset.setVisibility(View.VISIBLE);//when winner wins button should be visible
//                         gameOver=true;
//                    if (currentPlayer == Player.ONE)
//                        Toast.makeText(this, "Player 2 is the Winner", Toast.LENGTH_SHORT).show();
//                    else
//                        Toast.makeText(this, "Player 1 is the winner", Toast.LENGTH_SHORT).show();
//
//
//                }

            for(int i =0;i<winnerRowsAndColumn.length;i++) {
                for (int j = 0; j < winnerRowsAndColumn.length; j++) {
                    if (playerChoices[winnerRowsAndColumn[i][0]] == playerChoices[winnerRowsAndColumn[i][1]] &&
                            playerChoices[winnerRowsAndColumn[i][1]] == playerChoices[winnerRowsAndColumn[i][2]] && playerChoices[winnerRowsAndColumn[i][0]] != Player.NO)
                    {
                        if(currentPlayer==Player.ONE)
                        {
                            Toast.makeText(this, "Player two wins the game\",\"What you want to do?", Toast.LENGTH_SHORT).show();
                            btnReset.setVisibility(View.VISIBLE);//when winner wins button should be visible
                            gameOver=true;
                           // AlertDisplay("Player two wins the game","What you want to do?");
                        }
                        else if(currentPlayer==Player.TWO)
                        {

                            Toast.makeText(this, "Player one wins the game\",\"What you want to do?", Toast.LENGTH_SHORT).show();
                            btnReset.setVisibility(View.VISIBLE);//when winner wins button should be visible
                             gameOver=true;
                            //AlertDisplay("Player one wins the game","What you want to do?");
                        }
                    }
                }
            }

            if(playerChoices[0]!= Player.NO && playerChoices[1]!= Player.NO && playerChoices[2]!= Player.NO &&
                    playerChoices[3]!= Player.NO &&playerChoices[4]!= Player.NO &&playerChoices[5]!= Player.NO &&
                    playerChoices[6]!= Player.NO &&playerChoices[7]!= Player.NO &&playerChoices[8]!= Player.NO )
            {

                Toast.makeText(this, "Game Draw!!!\",\"Let's find who is better!!", Toast.LENGTH_SHORT).show();
                //AlertDisplay("Match Draw!!!","Let's find who is better!!");
                btnReset.setVisibility(View.VISIBLE);
            }

        }

            }




   public void resetTheGame(){
        for(int index=0;index<mGridLayout.getChildCount();index++){
            ImageView imageView =(ImageView) mGridLayout.getChildAt(index);
            imageView.setImageDrawable(null);
            imageView.setAlpha(0.2f);
        }
       currentPlayer = Player.ONE;

      /* playerChoices[0]=Player.NO;
       playerChoices[1]=Player.NO;
       playerChoices[2]=Player.NO;
       playerChoices[3]=Player.NO;
       playerChoices[4]=Player.NO;
       playerChoices[5]=Player.NO;
       playerChoices[6]=Player.NO;
       playerChoices[7]=Player.NO;
       playerChoices[8]=Player.NO;
      */
       for(int index = 0 ;index<playerChoices.length;index++){
           playerChoices[index] =Player.NO;
       }
       gameOver=false;
   }


}