package com.example.kevinparker.pcpartpicker;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CPUCoolerActivity extends ComputerPartActivity {
    Dialog cpuCoolerFilterDialog;
    ImageView closeBtn;

    private String baseUrl = "https://pcpartpicker.com/products/cpu-cooler/fetch/?sort=&page=&mode=list&xslug=&search=";

    public void createDialog() {
        cpuCoolerFilterDialog = new Dialog(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.cpu_cooler_filter_dialog, (ViewGroup) findViewById(R.id.cpuCoolerRootElement));
        cpuCoolerFilterDialog.setContentView(layout);
        closeBtn = (ImageView) cpuCoolerFilterDialog.findViewById(R.id.cpuCoolerCloseButton);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpuCoolerFilterDialog.dismiss();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cpu_coolermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.filter_menu_itemcpucooler:
                cpuCoolerFilterDialog.show();
                break;
            case R.id.cooler_name_mi:
                swapMenuItemTitle(item);
                break;
            case R.id.cooler_rpm_mi:
                swapMenuItemTitle(item);
                break;
            case R.id.cooler_noise_mi:
                swapMenuItemTitle(item);
                break;
            case R.id.cooler_price_mi:
                swapMenuItemTitle(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpucooler);

        getSupportActionBar().setTitle("Choose A CPU Cooler");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDialog();
        createCardview(R.id.cpu_cooler_recycler_view);
        populateCardview(baseUrl);
    }
}
