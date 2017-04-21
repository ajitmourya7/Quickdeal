package com.example.ajitm.quickdeal;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class Home1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Activity activity = this;
        setContentView(R.layout.activity_home1);
        activity.setTitle("Home");

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED) {


            TextView tv = (TextView) findViewById(R.id.showop);

            tv.setText(R.string.connected);

            TextView sv = (TextView) findViewById(R.id.showopp);

            sv.setText(R.string.wait);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent i=new Intent(Home1.this,Services1.class);
                    startActivity(i);
                }
            }, 5000);

        } else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {

            TextView tv = (TextView) findViewById(R.id.showop);

            tv.setText(R.string.oppp);

            TextView sv = (TextView) findViewById(R.id.showopp);

            sv.setText(R.string.no_internet);

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

}
