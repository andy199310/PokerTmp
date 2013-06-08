package com.weigreen.poler;

/**
 * Created by wind on 2013/6/7.
 */
public class TFHBridgeDataPlayer implements java.io.Serializable
{
    private final short PLAYER_NUMBER;
    private final short CARD_ID;

    public TFHBridgeDataPlayer(short playerNumber, short cardId)
    {
        this.PLAYER_NUMBER = playerNumber;
        this.CARD_ID = cardId;
    }

    public short getPlayerNumber()
    {
        return this.PLAYER_NUMBER;
    }

    public short getCardId()
    {
        return this.CARD_ID;
    }


}
