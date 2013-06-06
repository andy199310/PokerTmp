package com.weigreen.poler;

/**
 * Created by wind on 2013/6/7.
 */
public class TFHBridgeDataPlayer implements java.io.Serializable
{
    private final short PLAYER_NUMBER;
    private final short CARD_SUIT;
    private final short CARD_NUMBER;

    public TFHBridgeDataPlayer(short playerNumber, short cardSuit, short cardNumber)
    {
        this.PLAYER_NUMBER = playerNumber;
        this.CARD_SUIT = cardSuit;
        this.CARD_NUMBER = cardNumber;
    }

    public short getPlayerNumber()
    {
        return this.PLAYER_NUMBER;
    }

    public short getCardSuit()
    {
        return this.CARD_SUIT;
    }

    public short getCardNumber()
    {
        return this.CARD_NUMBER;
    }


}
