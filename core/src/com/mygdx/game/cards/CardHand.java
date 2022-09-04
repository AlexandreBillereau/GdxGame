package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;

public class CardHand extends Group {

    //Const
    private final float RIGHT_ANGLE = 0.275f;
    private final float ARC_ANGLE = 0.45f;
    private final int CARD_ROTATION_MAX = 15;
    private final float RADIUS = 300;
    //Var
    private int translationY;
    private int dist_max;

    ArrayList<Card> hand;

    public CardHand() {

         hand = new ArrayList<>();
         initHand();

    }

    void initHand(){

      for(int i = 0; i < 5; i++){

        //todo: get random card form deck
        Card temp = new Card();
        // end get random card

        hand.add(temp);
        addActor(temp);


      }

      updateHand();

    }

    void updateHand(){
      int hand_length = hand.size();

      if( !isEven(hand_length) ){

        int middle = (hand_length / 2);

        Card card = hand.get(middle);
        int x = Gdx.graphics.getWidth()/2;
        float y = 0;
        card.setPosition(x, y);

        updatePreviousCard(middle - 1, x, y);
        updateNextCard(middle + 1, x, y);


      }
//      else {
//
//      }


    }

    void updatePreviousCard(int previous, float x, float y){
      if(previous >= 0){
        System.out.println("previous :" + previous);
        Card card = hand.get(previous);
        x = x - 40;
        card.setPosition( x , y);
        updatePreviousCard(previous - 1, x, y);
      }
    }


    void updateNextCard(int next, float x, float y){
      if( next < hand.size() ){
        System.out.println("Next :" + next);
        Card card = hand.get(next);
        x = x + 40;
        card.setPosition( x , y);
        updateNextCard(next + 1, x, y);
      }
    }

    boolean isEven(int number){
      return number % 2 == 0;
    }


}









