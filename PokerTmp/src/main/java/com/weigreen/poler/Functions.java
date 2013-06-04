package com.weigreen.poler;

import java.util.Random;

/**
 * Created by Green on 2013/6/4.
 */
public class Functions {
    /**
     * This function return 4*13 Card array
     * @return
     */
    public static Card[][] dealCard(){
        // Save each person have how many cards
        short[] eachPersonCard = new short[4];

        // The 4*13 Card array
        Card[][] data = new Card[4][13];

        // Random
        Random random = new Random();

        for (short i=1; i<5; i++){
            for (short j=1; j<14; j++){
                short thisTime = (short) random.nextInt(4);
                while (eachPersonCard[thisTime] > 12){
                    thisTime = (short) random.nextInt(4);
                }
                data[thisTime][eachPersonCard[thisTime]++] = new Card(i, j);
            }
        }

        return data;
    }

}
