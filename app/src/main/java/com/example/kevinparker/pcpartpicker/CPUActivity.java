package com.example.kevinparker.pcpartpicker;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevinparker.pcpartpicker.part_picker_api.ComputerPart;
import com.example.kevinparker.pcpartpicker.part_picker_api.Main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CPUActivity extends AppCompatActivity {
    Dialog cpuFilterDialog;
    String lowestPriceStr;
    EditText lowestPriceET;
    ImageView dismissBTN;

    //cardView Variables
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager layoutManager;

    public void createCardView(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        String url = "https://pcpartpicker.com/products/cpu/fetch/?mode=list&xslug=&search=";
        new Populater().execute(url);
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

    private class Populater extends AsyncTask<String, Void, String> {
        String[][] rawData;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(CPUActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            System.setProperty("http.agent", "Chrome");
            Document doc = null;
            try {
                doc = Jsoup.parse(new URL(params[0]).openStream(), "UTF-8", "", Parser.xmlParser());
            } catch (IOException e) {
                e.printStackTrace();
            }
            rawData = Main.getRawData(doc);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            adapter = new ComputerPartAdapter(rawData);
            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }
}
