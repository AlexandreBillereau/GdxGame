package com.mygdx.game.cards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import gdx.simplify.lib.Point;

public class CardHand extends Group {

    //Const
    private final int CARD_INVISIBLE = 1;
    private final float RIGHT_ANGLE = 0.275f;
    private final float ARC_ANGLE = 0.45f;
    private final int CARD_ROTATION_MAX = 15;
    private final float RADIUS = 300;
    //Var
    private final Point centerCircle;
    private int translationY;
    private int dist_max;
    private Point left_extremity;
    private Point right_extremity;
    private Point center_arc;

    public CardHand(){
        //set the circle for use top arc to put card on.
        centerCircle = new Point(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        // need extremity to calculate dist and Y translation
        initExtremity(centerCircle);

        //Set the distance on arc between the center and extremity
        //-- We need this dist for create a ratio to calculate card rotation.
        putCardOnArc(15, RADIUS, centerCircle);
    }

    public void putCardOnArc(int nbPoints, double radius, Point center){

        setCenterArc();
        setDistMax();

        double slice = (Math.PI * ARC_ANGLE) / nbPoints;

        Point pos;
        for (int i = nbPoints; i >= 0; i--)
        {
            double angle = slice * i + (Math.PI * RIGHT_ANGLE);
            pos = angleRadiusToPoint(angle, radius, center);
            Card card = new Card();
            card.setPosition(pos.x - card.getWidth()/2, pos.y - card.getHeight()/2 - translationY);
            card.setRotation(getRotation(getCurrentDist(pos)));
            addActor( card );
            System.out.println("Z-index-" + i + " : " + card.getZIndex());
        }

    }

    public void setCenterArc(){
        center_arc = angleRadiusToPointTranslate(Math.toRadians(90), RADIUS, centerCircle);
    }

    public void setDistMax(){
        dist_max = ( center_arc.x - left_extremity.x );
    }

    public double getCurrentDist(Point current){
        return center_arc.x - current.x;
    }

    public float getRotation(double dist){
        return (float)((dist/dist_max) * CARD_ROTATION_MAX);
    }

    public void setTranslationY(){
        Point _center = getCenterBetweenPoint(right_extremity,left_extremity);
        translationY = _center.y;
    }

    public Point getCenterBetweenPoint(Point left_point, Point right_point){
        Point center_point = new Point((left_point.x + right_point.x) /2,
                (left_point.y + right_point.y) /2);

        return center_point;
    }

    public void initExtremity(Point center){

        double angle = Math.PI * RIGHT_ANGLE;
        Point right_point = angleRadiusToPoint(angle, RADIUS, center);

        angle = Math.PI * (RIGHT_ANGLE + ARC_ANGLE);
        Point left_point = angleRadiusToPoint(angle, RADIUS, center);

        right_extremity = right_point;
        left_extremity = left_point;

        //Get the real Position with add the translation.
        setTranslationY();

        right_extremity.y -= translationY;
        left_extremity.y -= translationY;




    }

    public Point angleRadiusToPoint(double angle, double radius, Point center){
        int pos_x = (int)(center.x + radius * Math.cos(angle));
        int pos_y = (int)(center.y + radius * Math.sin(angle));

        return new Point(pos_x, pos_y);
    }

    public Point angleRadiusToPointTranslate(double angle, double radius, Point center){
        int pos_x = (int)(center.x + radius * Math.cos(angle));
        int pos_y = (int)(center.y + radius * Math.sin(angle)) - translationY;

        return new Point(pos_x, pos_y);
    }





}
