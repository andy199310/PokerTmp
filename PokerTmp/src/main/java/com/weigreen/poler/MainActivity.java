package com.weigreen.poler;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    private final String TAG = "BLUETOOTHT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }

        /*Card[][] data = Functions.dealCard();
        for (int i=0; i<data.length; i++){
            for (int j=0; j<data[i].length; j++){
                Log.d("Person" + i, String.valueOf(data[i][j].getSuit()) + String.format("%2d", data[i][j].getNumber()));
            }
        }*/

    }



}
