package com.example.kevinparker.pcpartpicker;

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
        switch (item.getItemId()){
            case R.id.filter_menu_itemmemory:
                break;
            case R.id.ram_name_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=name"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-name"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_speed_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=speed"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-speed"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_type_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=formfactor"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-formfactor"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_cas_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=cas"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-cas"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_modules_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=modules"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-modules"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_size_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=capacity"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-capacity"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_priceGB_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=ppgb"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-ppgb"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.ram_price_mi:
                if(item.getTitle().toString().contains("Ascedning")){
                    populateCardview(baseUrl.replace("sort=", "sort=price"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-price"));
                }
                swapMenuItemTitle(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        getSupportActionBar().setTitle("Choose a memory");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDialog();
        createCardview(R.id.memory_recycler_view);
        populateCardview(baseUrl);
    }
}
