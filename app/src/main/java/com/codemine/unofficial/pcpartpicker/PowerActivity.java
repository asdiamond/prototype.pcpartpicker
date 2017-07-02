package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PowerActivity extends ComputerPartActivity {

    @Override
    void createDialog() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_power, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        swapMenuItemTitle(item);

        switch (item.getItemId()){
            case R.id.psupply_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.psupply_series_mi:
                populateCardview(getSortedURL(item, "series"));
                break;
            case R.id.psupply_form_mi:
                populateCardview(getSortedURL(item, "formfactor"));
                break;
            case R.id.psupply_efficiency_mi:
                populateCardview(getSortedURL(item, "efficiency"));
                break;
            case R.id.psupply_watts_mi:
                populateCardview(getSortedURL(item, "watts"));
                break;
            case R.id.psupply_modular_mi:
                populateCardview(getSortedURL(item, "modular"));
                break;
            case R.id.psupply_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
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
