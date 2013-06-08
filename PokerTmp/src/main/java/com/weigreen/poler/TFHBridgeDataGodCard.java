package com.weigreen.poler;

/**
 * Created by wind on 2013/6/7.
 */
public class TFHBridgeDataGodCard implements java.io.Serializable
{
    private final String COMMAND;
    private final short PLAYER_NUMBER;
    private final short GOD_CARD_SUIT;
    private final short HEAP;

    public TFHBridgeDataGodCard(String command, short playerNumber, short godCardSuit, short heap)
    {
        this.COMMAND = command;
        this.PLAYER_NUMBER = playerNumber;
        this.GOD_CARD_SUIT = godCardSuit;
        this.HEAP = heap;
    }

    public String getCommand()
    {
        return this.COMMAND;
    }

    public short getPlayerNumber()
    {
        return this.PLAYER_NUMBER;
    }

    public short getGodCardSuit()
    {
        return this.GOD_CARD_SUIT;
    }

    public short getHeap()
    {
        return this.HEAP;
    }
}
