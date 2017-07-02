package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MonitorActivity extends ComputerPartActivity {

    @Override
    void createDialog() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_monitor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        swapMenuItemTitle(item);
        switch (item.getItemId()){
            case R.id.monitor_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.monitor_res_mi:
                populateCardview(getSortedURL(item, "resolution"));
                break;
            case R.id.monitor_size_mi:
                populateCardview(getSortedURL(item, "size"));
                break;
            case R.id.monitor_resptime_mi:
                populateCardview(getSortedURL(item, "responsetime"));
                break;
            case R.id.monitor_ips_mi:
                populateCardview(getSortedURL(item, "ips"));
                break;
            case R.id.monitor_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        getSupportActionBar().setTitle("Choose a Monitor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.baseUrl = "https://pcpartpicker.com/products/monitor/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createCardview(R.id.monitor_recycler_view);
        populateCardview(baseUrl);
    }

}
