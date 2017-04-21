package com.example.ajitm.quickdeal;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.LinearLayout;

public class Services1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Activity activity = this;
        setSupportActionBar(toolbar);
        activity.setTitle("Services");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final BottomSheetDialogFragment myBottomSheet = MyBottomSheetDialogFragment.newInstance("Modal Bottom Sheet");

        LinearLayout button = (LinearLayout) findViewById(R.id.g1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBottomSheet.show(getSupportFragmentManager(), myBottomSheet.getTag());
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

}
