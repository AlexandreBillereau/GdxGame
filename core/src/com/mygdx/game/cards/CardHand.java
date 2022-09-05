package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;

public class CardHand extends Group {

    ArrayList<Card> hand;
    final int DIST_BETWEEN_CARD = 40;
    final int DIST_BETWEEN_CARD_ON_FOCUS = 60;

    public CardHand() {

         hand = new ArrayList<>();
         initHand();
         Pointer.player_hand = this;

    }

    void initHand(){

      for(int i = 0; i < 5; i++){

        //todo: get random card form deck
        Card card = new Card();
        // end get random card

        hand.add(card);
        addActor(card);

      }

      updateHand();

    }

    void updateHand(){
      int hand_length = hand.size();

      if( !isEven(hand_length) )
      {

        int middle = (hand_length / 2);

        Card card = hand.get(middle);
        float x = Gdx.graphics.getWidth()/2;
        float y = 0;
        card.moveTo(x,y,1);

        updateHand(middle - 1, middle + 1, x, x, y);
      }
      else
      {

        int middle_right = (hand_length / 2);
        int middle_left = middle_right - 1;

        Card card = hand.get(middle_left);
        float x_left = Gdx.graphics.getWidth()/2 - DIST_BETWEEN_CARD/2;
        float y = 0;
        card.moveTo(x_left,y,1);

        card = hand.get(middle_right);
        float x_right = Gdx.graphics.getWidth()/2 + DIST_BETWEEN_CARD/2;
        card.moveTo(x_right,y,1);

        updateHand(middle_left - 1, middle_right + 1, x_left, x_right, y);

      }


    }

    void updateHand(int previous, int next, float previous_x, float next_x, float y){

      previous_x -= DIST_BETWEEN_CARD;
      next_x += DIST_BETWEEN_CARD;

      updatePreviousCard(previous, previous_x, y);
      updateNextCard(next, next_x, y);

      if(previous >= 0 || next < hand.size()) {
        updateHand(previous - 1, next + 1, previous_x, next_x, y);
      }
    }


    void updateHandOnFocusEnter(int previous, int next, float previous_x, float next_x, float y)
    {
      previous_x -= DIST_BETWEEN_CARD_ON_FOCUS;
      next_x += DIST_BETWEEN_CARD_ON_FOCUS;


      updatePreviousCard(previous, previous_x, y);
      updateNextCard(next, next_x, y);

      if(previous >= 0 || next < hand.size()) {
        updateHand(previous - 1, next + 1, previous_x, next_x, y);
      }
    }


  void updateHandOnFocusEnd(int previous, int next, float previous_x, float next_x, float y)
  {
    previous_x += DIST_BETWEEN_CARD/2;
    next_x -= DIST_BETWEEN_CARD/2;


    updatePreviousCard(previous, previous_x, y);
    updateNextCard(next, next_x, y);

    if(previous >= 0 || next < hand.size()) {
      updateHand(previous - 1, next + 1, previous_x, next_x, y);
    }
  }





    void updatePreviousCard(int previous, float x, float y){
        if (previous >= 0){
          Card card = hand.get(previous);
          card.moveTo(x,y,1);
        }
    }

    void updateNextCard(int next, float x, float y){

      if( next < hand.size()){
        Card card = hand.get(next);
        card.moveTo(x,y,1);
      }

    }

    boolean isEven(int number){
      return number % 2 == 0;
    }





}









