package com.becode.java_workshop;


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
    boolean gameOver = false;


    public Story(GameScreen gameScreen) {

        this.gameScreen = gameScreen;
    }

    public void selectPosition(String position) {
        switch (position) {
            case "pallet town":
                startingPoint();
                break;
            case "knock doors":
                palletKnockDoors();
                break;
                //OAKS LAB
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
            case "game over":
                gameScreen.homeScreen();
                break;
                //PALLET ENTRANCE
            case "outside pallet town":
                palletEntrance();
                break;
            case "join pikachu":
                frolicWithPikachu();
                break;
        }
    }

    //Now that we can access our GameScreen class, let's create a method for our starting location (set     story and set button options)
    public void startingPoint() {

        gameScreen.image.setImageResource(R.drawable.pallettown);

        gameScreen.text.setText(R.string.new_start_text);

        gameScreen.button1.setText(R.string.goBack);
        //gameScreen.button1.setTransformationMethod(null);

        gameScreen.button2.setText(R.string.visitLab);

        gameScreen.button3.setText(R.string.visitLake);

        gameScreen.button4.setText(R.string.knockDoors);

        showAllButtons();

        nextMove1 = "outside pallet town";
        nextMove2 = "lab";
        nextMove3 = "lake";
        nextMove4 = "knock doors";
    }

//
//
// INSIDE PALLET TOWN
//
//

    public void palletKnockDoors(){

        gameScreen.image.setImageResource(R.drawable.schoolboy);

        gameScreen.text.setText(R.string.palletSchoolBoy);

        gameScreen.button1.setText(R.string.goBack);
        //gameScreen.button1.setTransformationMethod(null);
        gameScreen.button2.setText(R.string.visitLab);

        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.button4.setVisibility(View.INVISIBLE);

        nextMove1 = "pallet town";
        nextMove2 = "lab";
        nextMove3 = "";
        nextMove4 = "";

    }

//
//
// PALLET ENTRANCE
//
//

    public void palletEntrance() {

        if (!metOak) {
            metOak = true;
            gameScreen.image.setImageResource(R.drawable.profoak);
            gameScreen.text.setText(R.string.palletOaksWarning);

            gameScreen.button1.setText(R.string.goBack);
            //gameScreen.button1.setTransformationMethod(null);

            gameScreen.button2.setVisibility(View.INVISIBLE);

            gameScreen.button3.setVisibility(View.INVISIBLE);

            gameScreen.button4.setVisibility(View.INVISIBLE);

            nextMove1 = "pallet town";
            nextMove2 = "";
            nextMove3 = "";
            nextMove4 = "";
        } else if (pokemonReceived) {
            gameScreen.image.setImageResource(R.drawable.outsidepallet);
            gameScreen.text.setText(R.string.outsidePalletPikachu);

            gameScreen.button1.setText(R.string.readSign);
            //gameScreen.button1.setTransformationMethod(null);

            gameScreen.button2.setText(R.string.frolic);

            gameScreen.button3.setText(R.string.goEast);

            gameScreen.button4.setText(R.string.goBack);

            showAllButtons();

            nextMove1 = "viridian forest sign";
            nextMove2 = "join pikachu";
            nextMove3 = "trainer";
            nextMove4 = "pallet town";
        } else {

            int[] possibleEncounters =
                    {
                            R.drawable.pidgey,
                            R.drawable.rattata,
                            R.drawable.caterpie,
                            R.drawable.outsidepallet};

            int encounter = new Random().nextInt(possibleEncounters.length);
            gameScreen.image.setImageResource(possibleEncounters[encounter]);

            switch (encounter) {
                case 0:
                    gameScreen.text.setText("A wild Pidgey appears out of nowhere, gusting everywhere! You're startled, you run back to Pallet Town.");

                    gameScreen.button1.setText(R.string.goBack);
                    //gameScreen.button1.setTransformationMethod(null);

                    gameScreen.button2.setVisibility(View.INVISIBLE);

                    gameScreen.button3.setVisibility(View.INVISIBLE);

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
                    gameScreen.button2.setVisibility(View.INVISIBLE);
                    gameScreen.button3.setVisibility(View.INVISIBLE);
                    gameScreen.button4.setVisibility(View.INVISIBLE);

                    nextMove1 = "pallet town";
                    nextMove2 = "";
                    nextMove3 = "";
                    nextMove4 = "";
                    break;
                case 2:
                    gameScreen.text.setText("Oh, a Caterpie! Well...*enter excuse why you couldn't possible brave a Caterpie*\n\n\nA CATERPIE!");

                    gameScreen.button1.setText(R.string.goBack);
                    //gameScreen.button1.setTransformationMethod(null);

                    gameScreen.button2.setVisibility(View.INVISIBLE);

                    gameScreen.button3.setVisibility(View.INVISIBLE);

                    gameScreen.button4.setVisibility(View.INVISIBLE);

                    nextMove1 = "pallet town";
                    nextMove2 = "";
                    nextMove3 = "";
                    nextMove4 = "";
                    break;
                default:
                    gameScreen.text.setText("This is so peaceful. All Pikachu, frolicking in the forest. You'd like to join them.");

                    gameScreen.button1.setText(R.string.goBack);
                    //gameScreen.button1.setTransformationMethod(null);

                    gameScreen.button2.setText("frolic");

                    gameScreen.button2.setVisibility(View.VISIBLE);
                    gameScreen.button3.setVisibility(View.INVISIBLE);
                    gameScreen.button4.setVisibility(View.INVISIBLE);

                    nextMove1 = "pallet town";
                    nextMove2 = "join pikachu";
                    nextMove3 = "";
                    nextMove4 = "";

            }

        }

    }

    public void frolicWithPikachu() {
        if (pokemonReceived) {
            gameScreen.image.setImageResource(R.drawable.emptyspot);
            gameScreen.text.setText("The Pikachu notice your " + pokemon + ", they quickly run and hide.");
            gameScreen.button1.setText("Continue");
            //gameScreen.button1.setTransformationMethod(null);

            gameScreen.button2.setText(R.string.goBack);
            gameScreen.button2.setVisibility(View.VISIBLE);

            gameScreen.button3.setVisibility(View.INVISIBLE);

            gameScreen.button4.setVisibility(View.INVISIBLE);

            nextMove1 = "viridian city";
            nextMove2 = "outside pallet town";
        } else {
            gameScreen.image.setImageResource(R.drawable.pikachu);
            gameScreen.text.setText("One weirdly dressed Pikachu runs up to you, before you know it, you've been shocked and robbed of your kidneys.\n\n You died.");
            gameOver = true;
            gameScreen.button1.setText("Back to Menu");
            //gameScreen.button1.setTransformationMethod(null);

            gameScreen.button2.setVisibility(View.INVISIBLE);

            gameScreen.button3.setVisibility(View.INVISIBLE);

            gameScreen.button4.setVisibility(View.INVISIBLE);

            nextMove1 = "game over";
            nextMove2 = "";
        }
        nextMove3 = "";
        nextMove4 = "";
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

            gameScreen.button3.setText("Green");

            gameScreen.button4.setText("Slowly back away");

            showAllButtons();

            nextMove1 = "charmander received";
            nextMove2 = "squirtle received";
            nextMove3 = "bulbasaur received";
            nextMove4 = "pallet town";

        }

    }

    public void bookshelvesOak() {

        if (!bookshelvesOakVisited) {
            bookshelvesOakVisited = true;
            gameScreen.text.setText(R.string.palletOaksBookshelfUnvisited);

        } else {
            gameScreen.text.setText(R.string.palletOaksBookshelfVisited);

        }
        gameScreen.button1.setText(R.string.goBack);

        gameScreen.button2.setVisibility(View.INVISIBLE);

        gameScreen.button3.setVisibility(View.INVISIBLE);

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


        gameScreen.button2.setVisibility(View.INVISIBLE);


        gameScreen.button3.setVisibility(View.INVISIBLE);


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


        gameScreen.button2.setVisibility(View.INVISIBLE);

        gameScreen.button3.setVisibility(View.INVISIBLE);

        gameScreen.button4.setVisibility(View.INVISIBLE);

        nextMove1 = "pallet town";
        nextMove2 = "";
        nextMove3 = "";
        nextMove4 = "";
    }


//
//
// GAME OVER
//
//



//
//
// SHOW ALL BUTTONS
//
//

    public void showAllButtons() {
        gameScreen.button1.setVisibility(View.VISIBLE);
        gameScreen.button2.setVisibility(View.VISIBLE);
        gameScreen.button3.setVisibility(View.VISIBLE);
        gameScreen.button4.setVisibility(View.VISIBLE);
    }
}


// All button text is default in ALL CAPS. Should you want to write in lower caps:
// EXAMPLE:: gameScreen.button1.setTransformationMethod(null);

// HIDE or SHOW a certain element? Try:
// VISIBLE :: gameScreen.button1.setVisibility(View.VISIBLE);
// OR
// INVISIBLE :: gameScreen.button1.setVisibility(View.INVISIBLE);