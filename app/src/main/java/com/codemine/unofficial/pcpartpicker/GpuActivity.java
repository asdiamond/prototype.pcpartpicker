package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class GpuActivity extends ComputerPartActivity {

    @Override
    public void createDialog() {
        //put the code to create the filter dialog here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "inside onCreateOptionsMenu", Toast.LENGTH_SHORT).show();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gpu_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filterGPUactivity:
                //TODO make this filter
                break;
            case R.id.gpu_name_mi:
                populateCardview(getSortedURL(item, "name"));
                swapMenuItemTitle(item);
                break;
            case R.id.gpu_series_mi:
                populateCardview(getSortedURL(item, "series"));
                swapMenuItemTitle(item);
                break;
            case R.id.gpu_chipset_mi:
                populateCardview(getSortedURL(item, "chipset"));
                swapMenuItemTitle(item);
                break;
            case R.id.gpu_memory_mi:
                populateCardview(getSortedURL(item, "memory"));
                swapMenuItemTitle(item);
                break;
            case R.id.gpu_clock_mi:
                populateCardview(getSortedURL(item, "clock"));
                swapMenuItemTitle(item);
                break;
            case R.id.gpu_price_mi:
                populateCardview(getSortedURL(item, "price"));
                swapMenuItemTitle(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Choose a GPU");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_gpu);

        super.baseUrl = "https://pcpartpicker.com/products/video-card/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createCardview(R.id.gpu_recycler_view);
        populateCardview(baseUrl);
    }
}
