package com.freetek.freeapp.greatgriotapp.activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.freetek.freeapp.greatgriotapp.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViewPdf extends AppCompatActivity {

    private TextView bookName, chapterNo;
    private ProgressDialog progress;
    private PDFView pdfView;

    FirebaseDatabase database;
    DatabaseReference $book;


    private String key,chapter,book,url;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);


        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("Key");
        chapter = bundle.getString("Chapter");
        book = bundle.getString("Book");
        url = bundle.getString("Url");


        bookName = (TextView) findViewById(R.id.bookName);
        chapterNo = (TextView) findViewById(R.id.chapterNo);
        pdfView = (PDFView) findViewById(R.id.pdfview);

        progress = ProgressDialog.show(this, "", "Loading. Please wait...", true);


        database = FirebaseDatabase.getInstance();
        $book = database.getReference("Ebooks");

        $book.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                url = String.valueOf(dataSnapshot.child(key).child(chapter).getValue());
                new RetrivePdfStream().execute(url);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        bookName.setText(book);
        chapterNo.setText(chapter);


        new RetrivePdfStream().execute(url);

    }

        class RetrivePdfStream extends AsyncTask<String, Void, InputStream> {
            RetrivePdfStream() {
            }

            protected InputStream doInBackground(String... strings) {
                InputStream inputStream = null;
                try {
                    HttpURLConnection urlConnection = (HttpURLConnection) new URL(strings[0]).openConnection();
                    if (urlConnection.getResponseCode() == 200) {
                        inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    }
                    return inputStream;
                } catch (IOException e) {
                    return null;
                }
            }

            protected void onPostExecute(InputStream inputStream) {
                progress.dismiss();
                pdfView.fromStream(inputStream).load();
            }
        }


}

