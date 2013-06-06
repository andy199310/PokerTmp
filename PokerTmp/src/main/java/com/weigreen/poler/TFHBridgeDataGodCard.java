package com.weigreen.poler;

/**
 * Created by wind on 2013/6/7.
 */
public class TFHBridgeDataGodCard implements java.io.Serializable
{
    private final short GOD_CARD_SUIT;
    private final short HEAP;

    public TFHBridgeDataGodCard(short godCardSuit, short heap)
    {
        this.GOD_CARD_SUIT = godCardSuit;
        this.HEAP = heap;
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
