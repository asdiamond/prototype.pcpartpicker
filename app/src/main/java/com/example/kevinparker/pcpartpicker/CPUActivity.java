package com.example.kevinparker.pcpartpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CPUActivity extends AppCompatActivity {
    Dialog yourDialog;
    TextView tv;
    String str;
    String lowestPrice;
    EditText lowestPriceet;
    TextView lowestpricedisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cpu);

        getSupportActionBar().setTitle("Choose a CPU");//sets title on activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//this enables the back button in the toolbar. IMPORTANT, in order for this to work
        // you must specify android:parentActivityName in the android manifest under the activity you are referencing.


        lowestpricedisplay = (TextView)findViewById(R.id.lowestprice);

        tv = (TextView)findViewById(R.id.textView);
        yourDialog = new Dialog(this);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.my_custom_dialog, (ViewGroup)findViewById(R.id.customDialog_root_element));
        yourDialog.setContentView(layout);
        yourDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
//                lowestPriceet = (EditText)yourDialog.findViewById(R.id.lowestprice);
//                lowestPrice = lowestPriceet.getText().toString();

                Toast.makeText(CPUActivity.this, "Dismissed", Toast.LENGTH_SHORT).show();

            }
        });



    }

    //creates option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cpu_activity_menu, menu);//the menu being created
        return super.onCreateOptionsMenu(menu);
    }

    //callback for menu item selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filter_menu_item:
                Toast.makeText(this, "Filter Item Selected", Toast.LENGTH_SHORT).show();
                //TODO deliver event to a fragment for displaying the filtered items

                //for the custom dialog
                yourDialog.show();

                ImageView dismissButton = (ImageView)yourDialog.findViewById(R.id.closeButton);
                dismissButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        lowestPrice = lowestPriceet.getText().toString();
                        lowestPrice = "anything";
                        yourDialog.dismiss();
                        lowestpricedisplay.setText(lowestPrice);
                        Toast.makeText(CPUActivity.this, "Dismissed", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.temp:
                Toast.makeText(this, "Temp item selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
