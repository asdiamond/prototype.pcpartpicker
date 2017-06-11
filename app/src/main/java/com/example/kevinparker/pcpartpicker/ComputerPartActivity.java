package com.example.kevinparker.pcpartpicker;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.kevinparker.pcpartpicker.part_picker_api.Main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Aleksandr on 6/10/2017.
 */

public abstract class ComputerPartActivity extends AppCompatActivity {
    //cardview and recyclerview variables
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager layoutManager;

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
        if(item.getTitle().toString().contains("Ascending")){
            item.setTitle(item.getTitle().toString().replace("Ascending", "Descending"));
        }
        else {
            item.setTitle(item.getTitle().toString().replace("Descending", "Ascending"));
        }
    }

    class Populater extends AsyncTask<String, Void, String> {
        String[][] rawData;
        ProgressDialog progressDialog;

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
            } catch (IOException e) {
                e.printStackTrace();
            }
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
