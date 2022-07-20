package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import gdx.simplify.lib.Point;

import java.util.ArrayList;

public class CardHand extends Group {

    int CARD_INVISIBLE = 1;

    int max_card_hand = 7;
    float handPosition = (float) (Gdx.graphics.getWidth() * 0.20);

    int circle_x;
    int circle_y ;
    float radius = 300;
    float RIGHT_ANGLE = 0.275f;
    float ARC_ANGLE = 0.45f;

    int translationY;

    ShapeRenderer circle;
    public CardHand(){

        circle = new ShapeRenderer();

        //set the circle for use top arc
        circle_x = Gdx.graphics.getWidth()/2;
        circle_y = Gdx.graphics.getHeight()/2;

        Point center = new Point(circle_x, circle_y);
        translationY = getTranslationY(radius, center);
        setCardOnArc(15 + CARD_INVISIBLE, radius,center);

        setCardRotation();

    }



    public void setCardRotation(){

    }

    public void setCardOnArc(int nbPoints, double radius, Point center){
        double slice = (Math.PI * ARC_ANGLE) / nbPoints;



        for (int i = nbPoints - 1; i > 0; i--)
        {
            double angle = slice * i + (Math.PI * RIGHT_ANGLE);
            System.out.println(-Math.cos(Math.toDegrees(angle)));
            int newX = (int)(center.x + radius * Math.cos(angle));
            int newY = (int)(center.y + radius * Math.sin(angle));
            Card card = new Card();
            card.setPosition(newX - card.getWidth()/2, newY - card.getHeight()/2 - translationY);
//            card.setRotation(-9);
            addActor( card );
        }

    }

    public int getTranslationY(double radius, Point center){
        ArrayList<Point> extremity = SetExtremity(radius, center);
        Point _center = getCenterBetweenPoint(extremity.get(0), extremity.get(1));
        return _center.y;
    }

    public Point getCenterBetweenPoint(Point left_point, Point right_point){
        Point center_point = new Point((left_point.x + right_point.x) /2,
                (left_point.y + right_point.y) /2);

        return center_point;
    }

    public ArrayList<Point> SetExtremity(double radius, Point center){
        ArrayList<Point> extremity = new ArrayList<>();

        double angle = Math.PI * RIGHT_ANGLE;
        Point right_point = angleRadiusToPoint(angle, radius, center);
        right_point.setColor(Color.GREEN);
        extremity.add(right_point);

        angle = Math.PI * (RIGHT_ANGLE + ARC_ANGLE);
        Point left_point = angleRadiusToPoint(angle, radius, center);
        left_point.setColor(Color.GREEN);
        extremity.add(left_point);

        return extremity;
    }

    public Point angleRadiusToPoint(double angle, double radius, Point center){
        int pos_x = (int)(center.x + radius * Math.cos(angle));
        int pos_y = (int)(center.y + radius * Math.sin(angle));

        return new Point(pos_x, pos_y);
    }





}
