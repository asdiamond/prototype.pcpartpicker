package com.codemine.unofficial.pcpartpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CPUActivity extends ComputerPartActivity {
    Dialog cpuFilterDialog;
    String lowestPriceStr;
    EditText lowestPriceET;
    ImageView dismissBTN;

    @Override
    public void createDialog() {
        cpuFilterDialog = new Dialog(this);//android context.
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.cpu_dialogue, (ViewGroup) findViewById(R.id.customDialog_root_element));

        cpuFilterDialog.setContentView(layout);

        lowestPriceET = (EditText) cpuFilterDialog.findViewById(R.id.lowestpricecpu);
        dismissBTN = (ImageView) cpuFilterDialog.findViewById(R.id.closeButton);//the "x" image in the top left
        dismissBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowestPriceStr = lowestPriceET.getText().toString();
                //lowestPriceDisplyTV.setText("Dismissed");
                //Toast.makeText(CPUActivity.this, lowestPriceET.getText().toString(), Toast.LENGTH_SHORT).show();
                cpuFilterDialog.dismiss();
            }
        });

        cpuFilterDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
//                lowestPriceET = (EditText)cpuFilterDialog.findViewById(R.id.lowestprice);
//                lowestPriceStr = lowestPriceET.getText().toString();
                Toast.makeText(CPUActivity.this, lowestPriceET.getText().toString(), Toast.LENGTH_SHORT).show();
//                lowestPriceDisplyTV.setText(lowestPriceET.getText().toString());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.cpu_activity_menu, menu);//the menu being created
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * To be clear, what you are doing here is making queries to the pcpartpicker server.
     * The  base url makes a blank or base query, queries require parameters but the base url
     * leaves them blank. You are essentially inserting a parameter into the url to query the
     * part database. Notice the negative signs for the inverted queries.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        swapMenuItemTitle(item);
        switch (item.getItemId()) {
//            case R.id.filter_menu_item:
//                cpuFilterDialog.show();//shows the dialogue for filtering items
//                break;
            case R.id.cpu_info_mi:
                infoDialog.show();
                break;
            case R.id.cpu_name_mi:
                populateCardview(getSortedURL(item, "name"));
                break;
            case R.id.cpu_speed_mi:
                populateCardview(getSortedURL(item, "clock"));
                break;
            case R.id.cpu_cores_mi:
                populateCardview(getSortedURL(item, "cores"));
                break;
            case R.id.cpu_tdp_mi:
                populateCardview(getSortedURL(item, "tdp"));
               break;
            case R.id.cpu_price_mi:
                populateCardview(getSortedURL(item, "price"));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("CPUs");//sets title on activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//this enables the back button in the toolbar. IMPORTANT, in order for this to work
        // you must specify android:parentActivityName in the android manifest under the activity you are referencing.
        setContentView(R.layout.activity_cpu);

        //this seem to work as a good base url to change for the different search queries instead of
        //manually grabbing urls this one can be modified pretty reliably.
        super.baseUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=&page=&mode=list&xslug=&search=";

        createDialog();
        createRecyclerView(R.id.cpu_recycler_view);
        populateCardview(baseUrl);
        createInfoDialog(new String[]{"CPU Name", "Speed", "Cores", "TDP", "Price"});
    }
}
