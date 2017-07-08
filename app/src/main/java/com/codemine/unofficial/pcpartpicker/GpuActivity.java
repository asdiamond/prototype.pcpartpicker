package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GpuActivity extends ComputerPartActivity {

    @Override
    public void createDialog() {
        //put the code to create the filter dialog here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gpu_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        swapMenuItemTitle(item);
        switch (item.getItemId()) {
//            case R.id.filterGPUactivity:
//                break;
            case R.id.gpu_info_mi:
                infoDialog.show();
                break;
            case R.id.gpu_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.gpu_series_mi:
                populateCardview(getSortedURL(item, "series"));
                break;
            case R.id.gpu_chipset_mi:
                populateCardview(getSortedURL(item, "chipset"));
                break;
            case R.id.gpu_memory_mi:
                populateCardview(getSortedURL(item, "memory"));
                break;
            case R.id.gpu_clock_mi:
                populateCardview(getSortedURL(item, "clock"));
                break;
            case R.id.gpu_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("GPUs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_gpu);

        super.baseUrl = "https://pcpartpicker.com/products/video-card/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createRecyclerView(R.id.gpu_recycler_view);
        populateCardview(baseUrl);
        createInfoDialog(new String[]{"Name", "Series", "Chipset", "Memory", "Core Clock", "Price"});
    }
}
