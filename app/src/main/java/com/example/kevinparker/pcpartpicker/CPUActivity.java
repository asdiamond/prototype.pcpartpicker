package com.example.kevinparker.pcpartpicker;

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

    private String baseUrl = "https://pcpartpicker.com/products/cpu/fetch/?mode=list&xslug=&search=";

    private String ascendingNameUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=name&page=1&mode=list&xslug=&search=";
    private String descendingNameUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=-name&page=1&mode=list&xslug=&search=";

    private String ascendingSpeedUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=clock&page=1&mode=list&xslug=&search=";
    private String descendingSpeedUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=-clock&page=1&mode=list&xslug=&search=";

    private String ascendingCoresUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=cores&page=1&mode=list&xslug=&search=";
    private String descendingCoresUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=-cores&page=1&mode=list&xslug=&search=";

    private String ascendingTDPUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=tdp&page=1&mode=list&xslug=&search=";
    private String descendingTDPUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=-tdp&page=1&mode=list&xslug=&search=";

    private String ascendingPriceUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=price&page=1&mode=list&xslug=&search=";
    private String descendingPriceUrl = "https://pcpartpicker.com/products/cpu/fetch/?sort=-price&page=1&mode=list&xslug=&search=";

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.filter_menu_item:
                cpuFilterDialog.show();//shows the dialogue for filtering items
                break;
            case R.id.cpu_name_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(ascendingNameUrl);
                } else {
                    populateCardview(descendingNameUrl);
                }
                swapMenuItemTitle(item);
                break;
            case R.id.cpu_speed_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(ascendingSpeedUrl);
                } else {
                    populateCardview(descendingSpeedUrl);
                }
                swapMenuItemTitle(item);
                break;
            case R.id.cpu_cores_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(ascendingCoresUrl);
                } else {
                    populateCardview(descendingCoresUrl);
                }
                swapMenuItemTitle(item);
                break;
            case R.id.cpu_tdp_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(ascendingTDPUrl);
                } else {
                    populateCardview(descendingTDPUrl);
                }
                swapMenuItemTitle(item);
               break;
            case R.id.cpu_price_mi:
                if(item.getTitle().toString().contains("Ascending")){
                    populateCardview(ascendingPriceUrl);
                } else {
                    populateCardview(descendingPriceUrl);
                }
                swapMenuItemTitle(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Choose a CPU");//sets title on activity.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//this enables the back button in the toolbar. IMPORTANT, in order for this to work
        // you must specify android:parentActivityName in the android manifest under the activity you are referencing.
        setContentView(R.layout.activity_cpu);

//        lowestPriceDisplyTV = (TextView) findViewById(R.id.lowestpricedisplay);

        createCardview(R.id.cpu_recycler_view);
        createDialog();
        populateCardview(baseUrl);
    }
}
