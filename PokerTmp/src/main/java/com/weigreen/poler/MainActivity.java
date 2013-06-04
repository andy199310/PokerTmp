package com.weigreen.poler;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Card[][] data = Functions.dealCard();
        for (int i=0; i<data.length; i++){
            for (int j=0; j<data[i].length; j++){
                Log.d("Person" + i, String.valueOf(data[i][j].getSuit()) + String.format("%2d", data[i][j].getNumber()));
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
