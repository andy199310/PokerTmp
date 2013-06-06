package com.weigreen.poler;

/**
 * Created by wind on 2013/6/6.
 */
public class TFHBridgeDataCard implements java.io.Serializable
{
    private final Card[][] CARD_DATA;

    public TFHBridgeDataCard(Card[][] cardData)
    {
        this.CARD_DATA = cardData;
    }

    public Card[][] getCardData()
    {
        return this.CARD_DATA;
    }
}
