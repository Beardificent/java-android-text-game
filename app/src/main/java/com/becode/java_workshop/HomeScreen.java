package com.becode.java_workshop;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class HomeScreen extends AppCompatActivity {

    // This code makes you go from start screen to the first play screen.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //connect to home_screen.xml
        setContentView(R.layout.activity_home_screen);

        //instantiate the TextView from home_screen_xml
        TextView titleText = (TextView)findViewById(R.id.title_text);
        //change title screen text on start up
        titleText.setText("Pokémon Java");

        //instantiate the Button from home_screen_xml
        Button startButton = (Button) findViewById(R.id.button_start);
        //remove start text from button on start up by replacing with an empty string
        startButton.setText(" ");

    }
    //by passing "View randomName" as  argument, this method becomes visible in .xml onClick
    public void startButtonClicked(View game){
    //To switch screens after pressing our button we create a new Intent and pass "this, name of .java file followed by .class.
        Intent newGameScreen = new Intent(this, GameScreen.class);
        //Then we call on start activity with our screen (.java file) as argument.
        startActivity(newGameScreen);
    }


}