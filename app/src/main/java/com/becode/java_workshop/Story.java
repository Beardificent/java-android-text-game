package com.becode.java_workshop;


import android.content.res.TypedArray;
import android.view.View;

import java.util.Random;

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
            case "outside pallet town":
                palletEntrance();
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
            case "squirtle received":
                receiveSquirtle();
                break;
            case "bulbasaur received":
                receiveBulbasaur();
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

        nextMove1 = "outside pallet town";
        nextMove2 = "lab";
        nextMove3 = "lake";
        nextMove4 = "knock doors";
    }

    //
    //
    // GO BACK => PALLET ENTRANCE
    //
    //

    public void palletEntrance() {

        if (!metOak) {
            metOak = true;
            gameScreen.image.setImageResource(R.drawable.profoak);
            gameScreen.text.setText("Don't go out! It's unsafe! Wild Pokémon live in tall grass! You need your own Pokémon for your protection.\n\n Meet me at my lab.");

            gameScreen.button1.setText("Go back");
            //gameScreen.button1.setTransformationMethod(null);

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
        } else if (pokemonReceived == true) {
            gameScreen.image.setImageResource(R.drawable.outsidepallet);
            gameScreen.text.setText("You look around and see a beautiful forest, what was that old man on about? " +
                    "\n\nThere's a sign in front of you");

            gameScreen.button1.setText("Read sign");
            //gameScreen.button1.setTransformationMethod(null);

            gameScreen.button2.setText("Go north");
            gameScreen.button2.setVisibility(View.VISIBLE);

            gameScreen.button3.setText("Go east");
            gameScreen.button3.setVisibility(View.VISIBLE);

            gameScreen.button4.setText("Go back");
            gameScreen.button4.setVisibility(View.VISIBLE);

            nextMove1 = "viridian forest sign";
            nextMove2 = "caterpie";
            nextMove3 = "trainer";
            nextMove4 = "pallet town";
        } else {

            int[] possibleEncounters = {R.drawable.pidgey, R.drawable.rattata, R.drawable.caterpie, R.drawable.outsidepallet};
            Random rand = new Random();
            int encounter = new Random().nextInt(possibleEncounters.length);
            gameScreen.image.setImageResource(possibleEncounters[encounter]);

            switch (encounter) {
                case 0:
                    gameScreen.text.setText("A wild Pidgey appears out of nowhere, gusting everywhere! You're startled, you run back to Pallet Town.");

                    gameScreen.button1.setText("Go back");
                    //gameScreen.button1.setTransformationMethod(null);

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
                    break;
                case 1:
                    gameScreen.text.setText("A Rattata jumps in front of you and bares his fangs. As he prepares to attack, you squeal.\n\n" +
                            "Rattata got weirded out for a minute, this gave you time to tuck tail and run back to town.");

                    gameScreen.button1.setText("Go back");
                    //gameScreen.button1.setTransformationMethod(null);

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
                    break;
                case 2:
                    gameScreen.text.setText("Oh, a Caterpie! Well...*enter excuse why you couldn't possible brave a Caterpie*\n\n\nA CATERPIE!");

                    gameScreen.button1.setText("Go back");
                    //gameScreen.button1.setTransformationMethod(null);

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
                    break;
                default:
                    gameScreen.text.setText("This is so peaceful. All Pikachu, frolicking in the forest. You'd like to join them.");

                    gameScreen.button1.setText("Go back");
                    //gameScreen.button1.setTransformationMethod(null);

                    gameScreen.button2.setText("frolic");
                    gameScreen.button2.setVisibility(View.VISIBLE);

                    gameScreen.button3.setText("");
                    gameScreen.button3.setVisibility(View.INVISIBLE);

                    gameScreen.button4.setText("");
                    gameScreen.button4.setVisibility(View.INVISIBLE);

                    nextMove1 = "pallet town";
                    nextMove2 = "join Pikachu";
                    nextMove3 = "";
                    nextMove4 = "";

            }

        }

    }


    //
    //
    // VISIT THE LAB
    //
    //

    public void oakLab() {


        if (!metOak || pokemonReceived) {

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
            nextMove2 = "squirtle received";
            nextMove3 = "bulbasaur received";
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

    public void receiveCharmander() {
        pokemonReceived = true;
        pokemon = "Charmander";
        gameScreen.image.setImageResource(R.drawable.charmander);
        gameScreen.text.setText("Say hello to best Pokémon, ever! \n\nWelcome Charmander!");
        gameScreen.button1.setText("Nice!");

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

    public void receiveSquirtle() {
        pokemonReceived = true;
        pokemon = "Squirtle";
        gameScreen.image.setImageResource(R.drawable.squirtle);
        gameScreen.text.setText("Hope you're in for one 'Shell' of a time! \n\nMeet Squirtle!");
        gameScreen.button1.setText("Cool!");

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

    public void receiveBulbasaur() {
        pokemonReceived = true;
        pokemon = "Bulbasaur";
        gameScreen.image.setImageResource(R.drawable.bulbasaur);
        gameScreen.text.setText("Once you go green, you're never mean, unless you get mad! \n\nBig applause for Bulbasaur!");
        gameScreen.button1.setText("Groovy!");

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