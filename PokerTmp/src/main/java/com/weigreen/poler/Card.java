package com.weigreen.poler;

/**
 * Created by wind on 2013/6/4.
 */
public class Card
{
    private short id;

    public Card(short id)
    {
        this.id = id;
    }

    public short getId()
    {
        return id;
    }

    /**
     * @return the suit of card, 1 is spade,
     * 2 is heart, 3 is diamond, 4 is club
     */
    public short getSuit()
    {
        short Suit = (short) (id / 100);
        return Suit;
    }

    /**
     * @return the number of card, 10 is J, 11 is Q, 12 is K, 13 is A
     */
    public short getNumber()
    {
        short Number = (short) (id % 100);
        return Number;
    }
}
