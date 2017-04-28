package com.example.kevinparker.pcpartpicker;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class MotherboardActivity extends AppCompatActivity {
    Dialog motherboardActivityDialog;
    ImageView closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard);

        getSupportActionBar().setTitle("Choose a Motherboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        motherboardActivityDialog = new Dialog(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout =  inflater.inflate(R.layout.motherboard_filter_dialogue,(ViewGroup) findViewById(R.id.motherboardFilterDialogRootElement));
        motherboardActivityDialog.setContentView(layout);

        closeBtn = (ImageView)motherboardActivityDialog.findViewById(R.id.motherboardcloseButton);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motherboardActivityDialog.dismiss();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.motherboard_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.filter_menu_motherboard:
                Toast.makeText(this, "Filter selected", Toast.LENGTH_SHORT).show();
                motherboardActivityDialog.show();
                break;
            case R.id.temp2:
                Toast.makeText(this, "Temp2 selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
