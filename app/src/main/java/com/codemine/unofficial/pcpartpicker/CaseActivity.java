package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CaseActivity extends ComputerPartActivity {

    @Override
    void createDialog() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_case, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        swapMenuItemTitle(item);
        switch(item.getItemId()){
            case R.id.case_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.case_type_mi:
                populateCardview(getSortedURL(item, "type"));
                break;
            case R.id.case_fiveinch_mi:
                populateCardview(getSortedURL(item, "ext525"));
                break;
            case R.id.case_threeinch_mi:
                populateCardview(getSortedURL(item, "int350"));
                break;
            case R.id.case_psupply_mi:
                populateCardview(getSortedURL(item, "psu"));
                break;
            case R.id.case_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case);
        getSupportActionBar().setTitle("Choose a Case");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.baseUrl = "https://pcpartpicker.com/products/case/fetch/?sort=&page=&mode=list&xslug=&search=";
        createDialog();
        createCardview(R.id.case_recycler_view);
        populateCardview(baseUrl);
    }
}
