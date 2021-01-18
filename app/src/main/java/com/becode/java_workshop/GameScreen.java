package com.becode.java_workshop;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class GameScreen extends AppCompatActivity {

    ImageView image;
    TextView text;
    Button button1, button2, button3, button4;

    //After creating your Story class instantiate it and pass "this screen"(check Story.java) as argument .
    Story story = new Story(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        image = (ImageView) findViewById(R.id.gameImage);
        text = (TextView) findViewById(R.id.gameText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        //call upon story to get the story rolling.
        story.startingPoint();
    }

    public void selectedButton1(View game){

        story.selectPosition(story.nextMove1);

    }

    public void selectedButton2(View game){

        story.selectPosition(story.nextMove2);
    }

    public void selectedButton3(View game){

        story.selectPosition(story.nextMove3);

    }

    public void selectedButton4(View game){

        story.selectPosition(story.nextMove4);

    }
}