package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.codemine.unofficial.pcpartpicker.R;

public class PowerActivity extends ComputerPartActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.power_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    void createDialog() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        getSupportActionBar().setTitle("Choose a Power Supply");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.baseUrl = "https://pcpartpicker.com/products/power-supply/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createCardview(R.id.power_recycler_view);
        populateCardview(baseUrl);
    }
}
