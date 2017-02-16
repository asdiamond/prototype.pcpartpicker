package com.example.kevinparker.pcpartpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button cpuBtn;
    public void createCPUBtn(){
        cpuBtn = (Button) findViewById(R.id.cpu_btn);
        final Intent startActivityIntent = new Intent(MainActivity.this, CPUActivity.class);//needs to be final for some stupid fucking reason
        cpuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Starting CPU activity", Toast.LENGTH_SHORT).show();
                MainActivity.this.startActivity(startActivityIntent);
            }
        });
    }

    Button cpuCoolerBtn;
    public void createCPUCoolerBtn(){}

    Button moboBtn;
    public void createMotherboardBtn(){}

    Button memoryBtn;
    public void createMemoryBtn(){}

    Button gpuBtn;
    public void createVideoCardBtn(){}

    Button oDriveBtn;
    public void createOpticalDriveBtn(){}

    Button monitorBtn;
    public void createMonitorBtn(){}

    Button peripheralsBtn;
    public void createPeripheralsBtn(){}

    Button osBtn;
    public void createOperatingSystemBtn(){}

    Button storageBtn;
    public void createStorageBtn(){}

    Button caseBtn;
    public void createCaseBtn(){}

    Button softwareBtn;
    public void createSoftwareBtn(){}

    Button externalStorageBtn;
    public void createExternalStorageBtn(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCPUBtn();
    }
}
