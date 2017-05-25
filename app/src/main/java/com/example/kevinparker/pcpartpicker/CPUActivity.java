package com.example.kevinparker.pcpartpicker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CPUActivity extends AppCompatActivity {
    Dialog cpuFilterDialog;
    String lowestPriceStr;
    EditText lowestPriceET;
    TextView lowestPriceDisplyTV;
    ImageView dismissBTN;

    //cardView Variables
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager layoutManager;
    ArrayList<Contact> list = new ArrayList<Contact>();
    int[] image_id = {R.drawable.jesus};
    String[] name = new String[]{"Kevin", "Alek", "Wolf", "Carlos","Jean"};
    String[] email = new String[]{"Kevin_Creeping", "Alek_Coding", "Wolf_Bitching", "Carlos_Yes", "Jean_Doggin"};
    String[] number = new String[]{"9156668945", "9157845123", "9156847951", "915856321", "9154789652"};

    public void createCardView(){
/*
        name = getResources().getStringArray(R.array.person_name);
        email = getResources().getStringArray(R.array.person_email);
        mobile = getResources().getStringArray(R.array.person_number);*/
        int count = 0;

        for (String curr : name)
        {
            Contact contact = new Contact(image_id[0],curr,email[count],number[count]);
            count++;
            list.add(contact);
        }
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ContactAdapter(list);
        recyclerView.setAdapter(adapter);
    }


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
                cpuFilterDialog.show();//shows the dialogue for filtering items
                break;
            case R.id.temp:
                Toast.makeText(this, "Temp item selected", Toast.LENGTH_SHORT).show();
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

        createDialog();
        createCardView();
    }


}
