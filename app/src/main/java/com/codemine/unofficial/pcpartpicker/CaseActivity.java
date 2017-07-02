package com.codemine.unofficial.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class CaseActivity extends ComputerPartActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_case, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    void createDialog() {

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
