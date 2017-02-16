package com.example.kevinparker.pcpartpicker;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CPUActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cpu);

        getSupportActionBar().setTitle("Choose a CPU");//sets title on activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//this enables the back button in the toolbar. IMPORTANT, in order for this to work
        // you must specify android:parentActivityName in the android manifest under the activity you are referencing.
    }
}
