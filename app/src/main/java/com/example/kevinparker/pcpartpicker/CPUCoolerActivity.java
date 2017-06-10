package com.example.kevinparker.pcpartpicker;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class CPUCoolerActivity extends AppCompatActivity {
    Dialog cpuCoolerFilterDialog;
    ImageView closeBtn;

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
                Toast.makeText(this, "Filter Selected", Toast.LENGTH_SHORT).show();
                cpuCoolerFilterDialog.show();
                break;
            case R.id.temp1:
                Toast.makeText(this, "Temp1 Selected", Toast.LENGTH_SHORT).show();
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
    }
}
