package com.weigreen.poler;

/**
 * Created by wind on 2013/6/4.
 */
public class Card
{
    private short Id;

    public short getSuit()
    {
        short Suit = (short) (Id / 100);
        return Suit;
    }

    public short getNumber()
    {
        short Number = (short) (Id % 100);
        return Number;
    }
}
