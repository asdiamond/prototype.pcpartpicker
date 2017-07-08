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
        swapMenuItemTitle(item);
        switch(item.getItemId()){
            case R.id.storage_info_mi:
                infoDialog.show();
                break;
            case R.id.storage_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.storage_series_mi:
                populateCardview(getSortedURL(item, "series"));
                break;
            case R.id.storage_form_mi:
                populateCardview(getSortedURL(item, "formfactor"));
                break;
            case R.id.storage_type_mi:
                populateCardview(getSortedURL(item, "type"));
                break;
            case R.id.storage_capacity_mi:
                populateCardview(getSortedURL(item, "capacity"));
                break;
            case R.id.storage_cache_mi:
                populateCardview(getSortedURL(item, "cache"));
                break;
            case R.id.storage_priceGB_mi:
                populateCardview(getSortedURL(item, "ppgb"));
                break;
            case R.id.storage_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        getSupportActionBar().setTitle("Storage");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.baseUrl = "https://pcpartpicker.com/products/internal-hard-drive/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createRecyclerView(R.id.storage_recycler_view);
        populateCardview(baseUrl);
        createInfoDialog(new String[]{"Name", "Series", "Form", "Type", "Capacity", "Cache", "Price/GB", "Price"});
    }
}
