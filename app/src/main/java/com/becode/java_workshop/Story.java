package com.becode.java_workshop;


import android.view.View;

public class Story {

    // create our gameScreen that will be passed to the instantiated Story in GameScreen.java
    // when this is done, we can start accessing our GameScreen class.
    GameScreen gameScreen;
    String pokemon = "";
    String nextMove1, nextMove2, nextMove3, nextMove4;

    boolean bookshelvesOakVisited = false;
    boolean pokemonReceived = false;
    boolean metOak = false;


    public Story(GameScreen gameScreen) {

        this.gameScreen = gameScreen;
    }

    public void selectPosition(String position) {
        switch (position) {
            case "pallet town":
                startingPoint();
                break;
            case "lab":
                oakLab();
                break;
            case "bookshelvesOak":
                bookshelvesOak();
                break;
            case "charmander received":
                receiveCharmander();
                break;
        }
    }

    //Now that we can access our GameScreen class, let's create a method for our starting location (set     story and set button options)
    public void startingPoint() {

        gameScreen.image.setImageResource(R.drawable.pallettown);

        gameScreen.text.setText(R.string.new_start_text);

        gameScreen.button1.setText(R.string.new_game_button_one);
        //gameScreen.button1.setTransformationMethod(null);

        gameScreen.button2.setText(R.string.new_game_button_two);
        gameScreen.button2.setVisibility(View.VISIBLE);

        gameScreen.button3.setText(R.string.new_game_button_three);
        gameScreen.button3.setVisibility(View.VISIBLE);

        gameScreen.button4.setText(R.string.new_game_button_four);
        gameScreen.button4.setVisibility(View.VISIBLE);

        nextMove1 = "outside town";
        nextMove2 = "lab";
        nextMove3 = "lake";
        nextMove4 = "knock doors";
    }

    public void oakLab() {


        if(!metOak || pokemonReceived) {

            gameScreen.image.setImageResource(R.drawable.labnooak);
            gameScreen.text.setText("There's no one here...");
            gameScreen.button1.setText("Go back");

            gameScreen.button2.setText("Look around");
            gameScreen.button2.setVisibility(View.VISIBLE);

            gameScreen.button3.setText("");
            gameScreen.button3.setVisibility(View.INVISIBLE);

            gameScreen.button4.setText("");
            gameScreen.button4.setVisibility(View.INVISIBLE);

            nextMove1 = "pallet town";
            nextMove2 = "bookshelvesOak";
            nextMove3 = "";
            nextMove4 = "";

        } else {

            gameScreen.image.setImageResource(R.drawable.labwithoak);
            gameScreen.text.setText(R.string.oaksQuestion);
            gameScreen.button1.setText("Red");

            gameScreen.button2.setText("Blue");
            gameScreen.button2.setVisibility(View.VISIBLE);

            gameScreen.button3.setText("Green");
            gameScreen.button3.setVisibility(View.VISIBLE);

            gameScreen.button4.setText("Slowly back away");
            gameScreen.button4.setVisibility(View.VISIBLE);

            nextMove1 = "charmander received";
            nextMove2 = "starter pokemon received";
            nextMove3 = "starter pokemon received";
            nextMove4 = "pallet town";

        }

    }

    public void bookshelvesOak() {

        if (!bookshelvesOakVisited) {
            bookshelvesOakVisited = true;
            gameScreen.text.setText(R.string.oaksBookshelfUnvisited);

        } else {
            gameScreen.text.setText(R.string.oaksBookshelfVisited);

        }
        gameScreen.button1.setText("Go back");
        gameScreen.button2.setText("");
        gameScreen.button2.setVisibility(View.INVISIBLE);
        gameScreen.button3.setText("");
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.button4.setText("");
        gameScreen.button4.setVisibility(View.INVISIBLE);
        nextMove1 = "lab";
        nextMove2 = "";
        nextMove3 = "";
        nextMove4 = "";
    }

    public void receiveCharmander(){
        gameScreen.image.setImageResource(R.drawable.charmander);
        gameScreen.text.setText(R.string.oaksQuestion);
        gameScreen.button1.setText("Leave");

        gameScreen.button2.setText("");
        gameScreen.button2.setVisibility(View.INVISIBLE);

        gameScreen.button3.setText("");
        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.button4.setText("");
        gameScreen.button4.setVisibility(View.INVISIBLE);

        nextMove1 = "pallet town";
        nextMove2 = "";
        nextMove3 = "";
        nextMove4 = "";
    }


}


//Tips

// All button text is default in ALL CAPS. Should you want to write in lower caps:
// EXAMPLE:: gameScreen.button1.setTransformationMethod(null);

// HIDE or SHOW a certain element? Try:
// VISIBLE :: gameScreen.button1.setVisibility(View.VISIBLE);
// OR
// INVISIBLE :: gameScreen.button1.setVisibility(View.INVISIBLE);