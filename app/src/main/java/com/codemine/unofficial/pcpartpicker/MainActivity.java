package com.codemine.unofficial.pcpartpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button cpuBtn;
    public void createCPUBtn(){
        cpuBtn = (Button) findViewById(R.id.cpu_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, CPUActivity.class);//needs to be final for some stupid fucking reason
        cpuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button cpuCoolerBtn;
    public void createCPUCoolerBtn(){
        cpuCoolerBtn = (Button)findViewById(R.id.cooler_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, CPUCoolerActivity.class);
        cpuCoolerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button motherBoardBtn;
    public void createMotherboardBtn(){
        motherBoardBtn = (Button)findViewById(R.id.motherb_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, MotherboardActivity.class);
        motherBoardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button memoryBtn;
    public void createMemoryBtn(){
        memoryBtn = (Button)findViewById(R.id.memory_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, MemoryActivity.class);
        memoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button storageBtn;
    public void createStorageBtn(){
        storageBtn = (Button)findViewById(R.id.storage_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, StorageActivity.class);
        storageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button gpuBtn;
    public void createVideoCardBtn() {
        gpuBtn = (Button) findViewById(R.id.gpu_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, GpuActivity.class);
        gpuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button caseBtn;
    public void createCaseBtn(){
        caseBtn = (Button) findViewById(R.id.case_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, CaseActivity.class);
        caseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);

            }
        });
    }

    Button powerSBtn;
    public void createPowerSBtn(){
        powerSBtn = (Button) findViewById(R.id.powersup_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, PowerActivity.class);
        powerSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button monitorBtn;
    public void createMonitorBtn(){
        monitorBtn = (Button) findViewById(R.id.monitor_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, MonitorActivity.class);
        monitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCPUBtn();
        createCPUCoolerBtn();
        createMotherboardBtn();
        createMemoryBtn();
        createStorageBtn();
        createVideoCardBtn();
        createCaseBtn();
        createPowerSBtn();
        createMonitorBtn();
    }
}
