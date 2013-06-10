package com.weigreen.poler;

/**
 * Created by wind on 2013/6/10.
 */
public class TFHBridgeDataNewPlayer implements java.io.Serializable
{
    private final short NEW_PLAYER_NUMBER;

    public TFHBridgeDataNewPlayer(short newPlayerNumber)
    {
        this.NEW_PLAYER_NUMBER = newPlayerNumber;
    }

    public short getNewPlayerNumber()
    {
        return this.NEW_PLAYER_NUMBER;
    }
}
