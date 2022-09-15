package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.Context;

import java.awt.*;
import java.util.ArrayList;

public class CardHand extends Group {

    ArrayList<Card> hand;
    final int DIST_BETWEEN_CARD = 60;
    final int EVEN_GAP =  20;
    final int CARD_OFFSET = 40;
    final int OUT = 1;
    final float DURATION = 0.2f;

    public CardHand() {

        Pointer.player_hand = this;
        hand = new ArrayList<>();
        initHand();

    }

    void initHand(){

      for(int i = 0; i < 5; i++){

        //todo: get random card form deck
        Card card = new Card();
        // end get random card

        hand.add(card);
        addActor(card);

      }

      updateHand(findPosition());

    }

    ArrayList<Point> findPosition(){
      int hand_length = hand.size();
      ArrayList<Point> position  = new ArrayList<>();

      int middle = (hand_length / 2);
      int start = -middle;

      while (start != middle + OUT) {
        if(isEven(hand_length)){
          position.add(new Point(fromCenterAdd(start * DIST_BETWEEN_CARD +  EVEN_GAP), 0));
        }
        else {
          position.add(new Point(fromCenterAdd(start * DIST_BETWEEN_CARD), 0));
        }
        start++;
      }

      return position;

    }

    ArrayList<Point> findPosition(int cardIndex){
      ArrayList<Point> points = findPosition();

      for(int i = 0 ; i < points.size(); i++) {
          if (i < cardIndex) {
              points.get(i).x -= CARD_OFFSET;
          }
          if (i == 0) {
              points.get(cardIndex).y = (int) hand.get(cardIndex).getHeight() / 2;
          }
          if (i > cardIndex) {
              points.get(i).x += CARD_OFFSET;
          }
      }
      return points;
    }

    void updateHand(ArrayList<Point> positions){

      for(int i = 0; i < hand.size(); i++){
        hand.get(i).moveToInit(positions.get(i).x, positions.get(i).y, DURATION);
      }

    }



    boolean isEven(int number){
      return number % 2 == 0;
    }

    int fromCenterAdd(float dist){
      return (int)(Context.viewPortWidth/2 + dist);
    }





}









