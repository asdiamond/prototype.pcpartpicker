package com.codemine.unofficial.pcpartpicker;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.codemine.unofficial.pcpartpicker.part_picker_api.Main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Aleksandr on 6/10/2017.
 */

public abstract class ComputerPartActivity extends AppCompatActivity {
    //cardview and recyclerview variables
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager layoutManager;
    String baseUrl;

    public String getSortedURL(MenuItem item, String query){
        if(item.getTitle().toString().contains("Ascending")){
            return baseUrl.replace("sort=", "sort=" + query);
        } else {
            return baseUrl.replace("sort=", "sort=-" + query);
        }
    }

    public void createCardview(int recyclerViewID) {
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
            //the user pressing the back button.
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
                rawData = Main.getRawData(doc);
                urls = Main.getUrlsFromDoc(doc);
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
