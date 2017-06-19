package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class StorageActivity extends ComputerPartActivity {


    @Override
    void createDialog() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.storage_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.storage_name_mi:
                populateCardview(getSortedURL(item, "name"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_series_mi:
                populateCardview(getSortedURL(item, "series"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_form_mi:
                populateCardview(getSortedURL(item, "formfactor"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_type_mi:
                populateCardview(getSortedURL(item, "type"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_capacity_mi:
                populateCardview(getSortedURL(item, "capacity"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_cache_mi:
                populateCardview(getSortedURL(item, "cache"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_priceGB_mi:
                populateCardview(getSortedURL(item, "ppgb"));
                swapMenuItemTitle(item);
                break;
            case R.id.storage_price_mi:
                populateCardview(getSortedURL(item, "price"));
                swapMenuItemTitle(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        getSupportActionBar().setTitle("Choose Storage");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.baseUrl = "https://pcpartpicker.com/products/internal-hard-drive/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createCardview(R.id.storage_recycler_view);
        populateCardview(baseUrl);
    }
}
