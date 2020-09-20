/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.codingdojo.students;


import fr.rphstudio.codingdojo.game.Pod;
import fr.rphstudio.codingdojo.game.PodPlugIn;

import java.awt.*;

/**
 *
 * @author Romuald GRIGNON
 */



public class Student27 extends PodPlugIn {
    public Student27(Pod p){
        super(p);
    }


    // LVL 9
    boolean chargefull = true;


    boolean needcharge() {
        if (getShipBatteryLevel() < 30) {
            chargefull = true;
        } else if (getShipBatteryLevel() > 95) {
            chargefull = false;
        }
        if (chargefull && getShipBatteryLevel() < 95) {
            return true;
        } else {
            return false;
        }
    }

    int chargingChekPoint() {
        int nbcp = 1;
        while (isCheckPointCharging(nbcp) != true) {
            nbcp = nbcp + 1;
        }
        return nbcp;
    }

    float mouvOne () {

        float ShipAngle = getShipAngle();
        float sPositionX = getShipPositionX();
        float sPositionY = getShipPositionY();

        int next_cp_index = getNextCheckPointIndex();

        float angleX = getCheckPointX(next_cp_index);
        float angleY = getCheckPointY(next_cp_index);


        float calculangle = getAbsoluteAngleFromPositions(sPositionX, sPositionY, angleX, angleY);
        float relativeAngleDif = getRelativeAngleDifference(ShipAngle, calculangle);
        return relativeAngleDif;
    }
    float mouvTwo(){
        int maxcp = getNbRaceCheckPoints();
        int nextChargingCP = 0;
        for (int i = 0; i < maxcp ; i ++) {
            if (isCheckPointCharging(i)){
                nextChargingCP = i;
            }

        }

        float ChargAngleShip = getShipAngle();
        float ChargeShipX = getShipPositionX();
        float ChargeShipY = getShipPositionY();



        float chargecpX = getCheckPointX(nextChargingCP);
        float chargecpY = getCheckPointY(nextChargingCP);

        float calculAngle2 = getAbsoluteAngleFromPositions(ChargeShipX,ChargeShipY, chargecpX, chargecpY);
        float relativeAngleDif1 = getRelativeAngleDifference(ChargAngleShip,calculAngle2);
        return relativeAngleDif1;





    }


    //------- else ------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE


    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta)
    {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("CappyHS");
        selectShip(3);
        setPlayerColor(255,102,153,255);
        //moveAndRecharge(0.7f, 20, 95);



        /**
         * Exo 9
         */
        if (needcharge()== true){
            turn(mouvTwo());
            accelerateOrBrake(0.59f);
            setPlayerColor(245, 229, 27, 1);
        }else {
            turn(mouvOne());
            accelerateOrBrake(0.76f);


        }


        // END OF CODE AREA
        //-------------------------------------------------------
    }


}

