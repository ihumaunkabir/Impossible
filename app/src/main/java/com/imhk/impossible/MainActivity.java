package com.imhk.impossible;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView hplayer,rplayer;
    TextView htext, rtext;
    int hscr=0, rscr=0;
    Random rands;
    Button bf,bh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        htext = (TextView) findViewById(R.id.hScore);
        rtext = (TextView) findViewById(R.id.rScore);

        hplayer = (ImageView) findViewById(R.id.humanTurn);
        rplayer = (ImageView) findViewById(R.id.robotTurn);
        rands = new Random();
        bf = (Button) findViewById(R.id.finish);

        hplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int robot,player;
                robot = rands.nextInt(6) + 1;
                player =rands.nextInt(6) + 1;

                setRobot(robot);
                setHuman(player);

                if(robot < player ) {
                    hscr++;
                }
                if(player < robot ) {
                    rscr++;
                }

                if(rscr==10 || hscr==10 ){

                    if(hscr == rscr ) Toast.makeText(MainActivity.this,"Drawn !", Toast.LENGTH_LONG).show();
                    if(hscr > rscr ) Toast.makeText(MainActivity.this,"You lose !", Toast.LENGTH_LONG).show();
                    else  Toast.makeText(MainActivity.this,"You Win ! ",Toast.LENGTH_LONG).show();
                    rscr=0;
                    hscr=0;

                    rtext.setText("Robot: "+rscr);
                    htext.setText("You: "+hscr);

                }


                rtext.setText("Robot: "+hscr);
                htext.setText("You: "+rscr);
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);

                hplayer.startAnimation(rotate);
                rplayer.startAnimation(rotate);


            }
        });

        //win or lose
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hscr == rscr ) Toast.makeText(MainActivity.this,"Drawn !", Toast.LENGTH_LONG).show();
                if(hscr > rscr ) Toast.makeText(MainActivity.this,"You lose !", Toast.LENGTH_LONG).show();
                else  Toast.makeText(MainActivity.this,"You Win ! ",Toast.LENGTH_LONG).show();
                rscr=0;
                hscr=0;

                rtext.setText("Robot: "+rscr);
                htext.setText("You: "+hscr);
            }
        });



    }
    public void onHelp(View v) {
        Intent helpIntent = new Intent(this, helpInfo.class);
        startActivity(helpIntent);
    }

    public void setRobot(int n){

            switch (n){
                case 1:
                    hplayer.setImageResource(R.drawable.one);
                    break;
                case 2:
                    hplayer.setImageResource(R.drawable.two);
                    break;
                case 3:
                    hplayer.setImageResource(R.drawable.three);
                    break;
                case 4:
                    hplayer.setImageResource(R.drawable.four);
                    break;
                case 5:
                    hplayer.setImageResource(R.drawable.five);
                    break;
                case 6:
                    hplayer.setImageResource(R.drawable.six);
                    break;
            }

    }


    public void setHuman(int n){

        switch (n){
            case 1:
                rplayer.setImageResource(R.drawable.one);
                break;
            case 2:
                rplayer.setImageResource(R.drawable.two);
                break;
            case 3:
                rplayer.setImageResource(R.drawable.three);
                break;
            case 4:
                rplayer.setImageResource(R.drawable.four);
                break;
            case 5:
                rplayer.setImageResource(R.drawable.five);
                break;
            case 6:
                rplayer.setImageResource(R.drawable.six);
                break;
        }

    }

}
