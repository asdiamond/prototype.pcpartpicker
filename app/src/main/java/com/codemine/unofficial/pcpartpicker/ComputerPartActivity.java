package com.codemine.unofficial.pcpartpicker;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codemine.unofficial.pcpartpicker.part_picker_api.PartPickerScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * The superclass of all activities that display computer parts.
 * This includes all methods to sort throught urls, populate recyclerviews as
 * well as some code that makes sorting from the overlow menu cleaner.
 * This also includes the async task that grabs the Urls and raw data to be displayed.
 */

public abstract class ComputerPartActivity extends AppCompatActivity {
    //cardview and recyclerview variables
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager layoutManager;
    String baseUrl;

    //for info Dialog
    Dialog infoDialog;

    public void createInfoDialog(String[] info){
        infoDialog = new Dialog(this);//do not change this to getApplicationContext() it breaks the constructor.
        LayoutInflater layoutInflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.info_dialog, (ViewGroup)findViewById(R.id.info_dialog_rootelement));
        infoDialog.setContentView(layout);
        TextView[] textViews = new TextView[info.length + 2];

        LinearLayout linearLayout = (LinearLayout)layout.findViewById(R.id.info_card_view_linear_layout);
        ImageView computerPartImage = (ImageView)layout.findViewById(R.id.info_card_view_img);
        computerPartImage.setImageResource(R.drawable.no_image);

        for (int i = 0; i < textViews.length; i++) {
            textViews[i] = new TextView(getApplicationContext());
            linearLayout.setBackgroundColor(Color.TRANSPARENT);
            linearLayout.addView(textViews[i]);
        }

        for (int i = 0; i < info.length; i++) {
            textViews[i + 1].setText(info[i]);
        }
    }

    public String getSortedURL(MenuItem item, String query){
        if(item.getTitle().toString().contains("Ascending")){
            return baseUrl.replace("sort=", "sort=" + query);
        } else {
            return baseUrl.replace("sort=", "sort=-" + query);
        }
    }

    public void createRecyclerView(int recyclerViewID) {
        recyclerView = (RecyclerView)findViewById(recyclerViewID);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    abstract void createDialog();

    public void populateCardview(String url){
        new Populater().execute(url);
    }

    public void swapMenuItemTitle(MenuItem item) {
        if (item.getTitle() == null) {
            //IMPORTANT this prevents crashes when onOptionsItemSelected() is called from
            //the user pressing the back button or the info dialog.
            //if this is removed the other checks throw nullpointers, so keep it here.
        }
        else if(item.getTitle().toString().contains("Ascending")){
            item.setTitle(item.getTitle().toString().replace("Ascending", "Descending"));
        }
        else if (item.getTitle().toString().contains("Descending")){//the filter items will contain neither.
            item.setTitle(item.getTitle().toString().replace("Descending", "Ascending"));
        }
    }

    class Populater extends AsyncTask<String, Void, String> {
        String[][] rawData;
        ProgressDialog progressDialog;
        ArrayList<String> urls;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(ComputerPartActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            System.setProperty("http.agent", "Chrome");
            try {
                Document doc = Jsoup.parse(new URL(params[0]).openStream(), "UTF-8", "", Parser.xmlParser());
                rawData = PartPickerScraper.getRawData(doc);
                urls = PartPickerScraper.getUrlsFromDoc(doc);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            adapter = new ComputerPartAdapter(rawData, urls, getApplicationContext());
            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }
}
