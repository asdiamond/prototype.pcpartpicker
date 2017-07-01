package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.codemine.unofficial.pcpartpicker.R;

public class MonitorActivity extends ComputerPartActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monitor_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    void createDialog() {

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
