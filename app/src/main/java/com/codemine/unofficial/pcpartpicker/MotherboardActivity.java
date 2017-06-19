package com.codemine.unofficial.pcpartpicker;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MotherboardActivity extends ComputerPartActivity {
    Dialog motherboardActivityDialog;
    ImageView closeBtn;
    String baseUrl = "https://pcpartpicker.com/products/motherboard/fetch/?sort=&page=&mode=list&xslug=&search=";

    public void createDialog() {
        motherboardActivityDialog = new Dialog(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout =  inflater.inflate(R.layout.motherboard_filter_dialogue,(ViewGroup) findViewById(R.id.motherboardFilterDialogRootElement));
        motherboardActivityDialog.setContentView(layout);

        closeBtn = (ImageView)motherboardActivityDialog.findViewById(R.id.motherboardcloseButton);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                motherboardActivityDialog.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.motherboard_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.filter_menu_motherboard:
                motherboardActivityDialog.show();
                break;
            case R.id.mobo_name_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=name"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-name"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.mobo_socket_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=socket"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-socket"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.mobo_formfactor_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=formfactor"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-formfactor"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.mobo_ramslots_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=ramslots"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-ramslots"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.mobo_maxram_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(baseUrl.replace("sort=", "sort=rammax"));
                } else {
                    populateCardview(baseUrl.replace("sort=", "sort=-rammax"));
                }
                swapMenuItemTitle(item);
                break;
            case R.id.mobo_price_mi:
                if(item.getTitle().toString().contains("Ascending")){
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
        setContentView(R.layout.activity_motherboard);

        getSupportActionBar().setTitle("Choose a Motherboard");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDialog();
        createCardview(R.id.mobo_recycler_view);
        populateCardview(baseUrl);
    }
}
