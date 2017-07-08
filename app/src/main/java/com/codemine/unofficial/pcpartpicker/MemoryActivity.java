package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MemoryActivity extends ComputerPartActivity {
    String baseUrl = "https://pcpartpicker.com/products/memory/fetch/?sort=&page=&mode=list&xslug=&search=";

    public void createDialog() {
        //put the code to create the filter dialog here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.memory_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        swapMenuItemTitle(item);
        switch (item.getItemId()){
//            case R.id.filter_menu_itemmemory:
//                break;
            case R.id.ram_info_mi:
                infoDialog.show();
                break;
            case R.id.ram_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.ram_speed_mi:
                populateCardview(getSortedURL(item, "speed"));
                break;
            case R.id.ram_type_mi:
                populateCardview(getSortedURL(item, "formfactor"));
                break;
            case R.id.ram_cas_mi:
                populateCardview(getSortedURL(item, "cas"));
                break;
            case R.id.ram_modules_mi:
                populateCardview(getSortedURL(item, "modules"));
                break;
            case R.id.ram_size_mi:
                populateCardview(getSortedURL(item, "capacity"));
                break;
            case R.id.ram_priceGB_mi:
                populateCardview(getSortedURL(item, "ppgb"));
                break;
            case R.id.ram_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        getSupportActionBar().setTitle("Memory");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDialog();
        createRecyclerView(R.id.memory_recycler_view);
        populateCardview(baseUrl);
        createInfoDialog(new String[]{"Name", "Speed", "Type", "CAS", "Modules", "Size", "Price/GB", "Price"});
    }
}
