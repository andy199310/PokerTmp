package com.weigreen.poler;

/**
 * Created by wind on 2013/6/7.
 */
public class TFHBridgeMain
{
    private final short COMMAND;
    private final Object DATA;

    public TFHBridgeMain(short command, Object data)
    {
        this.COMMAND = command;
        this.DATA = data;
    }

    public short getCommand()
    {
        return this.COMMAND;
    }

    public Object getData()
    {
        return this.DATA;
    }
}
