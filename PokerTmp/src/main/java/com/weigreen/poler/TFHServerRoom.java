package com.weigreen.poler;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by wind on 2013/6/7.
 */
public class TFHServerRoom
{
    private final String LOG_TAG = "TFHServerRoom.java";

    private short pass = 0; // pass times

    // godCard
    private short callPlayerNumber; // the player number which call
    private short godCardSuit = 0;
    private short heap = 0;

    // play
    private short part = 0;
    private short initialCardSuit; // the first suit per stage
    private short[] stageCardIds = new short[4];
    private short initialPlayerNumber;
    private short easternHeap = 0;
    private short northernHeap = 0;


    // unfinished!!!!!!!!!!!
    public TFHServerRoom()
    {

    }
/*
    public void haveNewData(TFHBridgeMain main)
    {
        Log.d(LOG_TAG, "haveNewData()");

        short command = main.getCommand();

        if(command == TFHComm.GOD_CARD_DATA)
        {
            Log.d(LOG_TAG, "TFHComm.GOD_CARD_DATA");

            TFHBridgeDataGodCard godCardData = (TFHBridgeDataGodCard) main.getData();

            short newCallPlayerNumber = godCardData.getPlayerNumber();
            short newGodCardSuit = godCardData.getGodCardSuit();
            short newHeap = godCardData.getHeap();

            if(newHeap == 0)
            {
                Log.d(LOG_TAG, "Player passed");

                pass++;

                if(pass >= 3)
                {
                    Log.d(LOG_TAG, "triple pass, over to call god card");

                    initialPlayerNumber = callPlayerNumber;

                    TFHBridgeDataGodCard newGodCardData = new TFHBridgeDataGodCard("OVER", callPlayerNumber, godCardSuit, heap);
                    TFHBridgeMain newMain = new TFHBridgeMain(TFHComm.GOD_CARD_DATA, newGodCardData);

                    server.sendToAll(newMain);
                }
                else
                {
                    Log.d(LOG_TAG, "pass < 3");

                    TFHBridgeDataGodCard newGodCardData = new TFHBridgeDataGodCard("KEEP", newCallPlayerNumber, newGodCardSuit, newHeap);
                    TFHBridgeMain newMain = new TFHBridgeMain(TFHComm.GOD_CARD_DATA, newGodCardData);

                    server.sendToAll(newMain);
                }
            }
            else
            {
                Log.d(LOG_TAG, "no pass, keep call");

                pass = 0;

                callPlayerNumber = newCallPlayerNumber;
                godCardSuit = newGodCardSuit;
                heap = newHeap;

                TFHBridgeDataGodCard newGodCardData = new TFHBridgeDataGodCard("KEEP", callPlayerNumber, godCardSuit, heap);
                TFHBridgeMain newMain = new TFHBridgeMain(TFHComm.GOD_CARD_DATA, newGodCardData);

                server.sendToAll(newMain);
            }
        }


        if(command == TFHComm.PLAYER_DATA)
        {
            Log.d(LOG_TAG, "TFHComm.PLAYER_DATA");

            TFHBridgeDataPlayer playerData = (TFHBridgeDataPlayer) main.getData();

            TFHBridgeDataRoom roomData = analyze(playerData);
            TFHBridgeMain newMain = new TFHBridgeMain(TFHComm.ROOM_DATA, roomData);

            server.sendToAll(newMain);
        }

        if(command == TFHComm.CARD_DATA)
        {
            Log.d(LOG_TAG, "TFHComm.CARD_DATA");

            TFHBridgeDataCard cardData = new TFHBridgeDataCard(Functions.dealCard());
            TFHBridgeMain newMain = new TFHBridgeMain(TFHComm.CARD_DATA, cardData);

            server.sendToAll(newMain);
        }
    }
*/

    private TFHBridgeDataRoom analyze(TFHBridgeDataPlayer playerData)
    {
        Log.d(LOG_TAG, "analyze()");

        short playerNumber = playerData.getPlayerNumber();
        short cardId = playerData.getCardId();

        if(++part == 1)
        {
            Log.d(LOG_TAG, "first player");

            initialCardSuit = (short)(cardId / 100);
            stageCardIds[playerNumber] = cardId;

            TFHBridgeDataRoom roomData = new TFHBridgeDataRoom("KEEP", initialPlayerNumber, (short) ((initialPlayerNumber + part) % 4), cardId, easternHeap, northernHeap);
            return roomData;
        }
        else if(part < 4)
        {
            Log.d(LOG_TAG, "other players");

            stageCardIds[playerNumber] = cardId;

            TFHBridgeDataRoom roomData = new TFHBridgeDataRoom("KEEP", initialPlayerNumber, (short) ((initialPlayerNumber + part) % 4), cardId, easternHeap, northernHeap);
            return roomData;
        }
        else
        {
            Log.d(LOG_TAG, "forth player, start a new game");

            part = 0;

            stageCardIds[playerNumber] = cardId;

            short winPlayerId = getWinPlayerNumber(stageCardIds);

            if(winPlayerId == 0 || winPlayerId == 2)
            {
                Log.d(LOG_TAG, "east and west players WIN");

                easternHeap++;
            }
            else
            {
                Log.d(LOG_TAG, "north and south players WIN");

                northernHeap++;
            }

            TFHBridgeDataRoom roomData = new TFHBridgeDataRoom("START", winPlayerId, winPlayerId, cardId, easternHeap, northernHeap);

            return roomData;
        }
    }


    private short getWinPlayerNumber(short[] stageCardIds)
    {
        Log.d(LOG_TAG, "getWinPlayerNumber()");

        short[] cardSuit = new short[4];
        short[] cardNumber = new short[4];

        LinkedList<Short> godCardPlayerList = new LinkedList<Short>();
        LinkedList<Short> normalCardPlayerList = new LinkedList<Short>();

        Log.d(LOG_TAG, "get suits and numbers of cards");
        for(int i = 0; i < 4; i++)
        {
            cardSuit[i] = (short)(stageCardIds[i] / 100);
            cardNumber[i] = (short)(stageCardIds[i] % 100);

            if(cardSuit[i] == godCardSuit)
            {
                godCardPlayerList.add((short)i);
            }
            else if(cardSuit[i] == initialCardSuit)
            {
                normalCardPlayerList.add((short)i);
            }
        }

        if(!godCardPlayerList.isEmpty())
        {
            Log.d(LOG_TAG, "biggest card is god card");

            if(godCardPlayerList.size() > 1)
            {
                ListIterator<Short> iterator = godCardPlayerList.listIterator();

                List<Short> godCardNumbers = new ArrayList<Short>();

                while(iterator.hasNext())
                {
                    Log.d(LOG_TAG, "godCardNumber: " + cardNumber[iterator.next()]);

                    godCardNumbers.add(cardNumber[iterator.next()]);
                }

                short winCardId = (short)(godCardSuit * 100 + Collections.max(godCardNumbers));

                Log.d(LOG_TAG, "winCardId is " + winCardId);

                for(int i = 0; i < 4; i++)
                {
                    if(stageCardIds[i] == winCardId)
                    {
                        Log.d(LOG_TAG, "winner is " + i);

                        return (short)i;
                    }
                }
            }
            else
            {
                return godCardPlayerList.get(0);
            }
        }
        else
        {
            if(normalCardPlayerList.size() > 1)
            {
                ListIterator<Short> iterator = normalCardPlayerList.listIterator();

                List<Short> normalCardNumbers = new ArrayList<Short>();

                while(iterator.hasNext())
                {
                    Log.d(LOG_TAG, "normalCardNumber: " + cardNumber[iterator.next()]);

                    normalCardNumbers.add(cardNumber[iterator.next()]);
                }

                short winCardId = (short)(initialCardSuit * 100 + Collections.max(normalCardNumbers));

                Log.d(LOG_TAG, "winCardId is " + winCardId);

                for(int i = 0; i < 4; i++)
                {
                    if(stageCardIds[i] == winCardId)
                    {
                        Log.d(LOG_TAG, "winner is " + i);

                        return (short)i;
                    }
                }
            }
            else
            {
                return normalCardPlayerList.get(0);
            }
        }
        Log.d(LOG_TAG, "error happened, return -1");

        return -1; // error happened
    }
}
