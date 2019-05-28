package com.freetek.freeapp.greatgriotapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.freetek.freeapp.greatgriotapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Report extends AppCompatActivity {

    private ActionBar toolbar;
    EditText report_box;
    Button send;


    FirebaseDatabase database;
    DatabaseReference Reports;

    private int reportCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        send = (Button) findViewById(R.id.send);
        report_box = (EditText) findViewById(R.id.report_box);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Reports");


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reports.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        reportCount = (int) dataSnapshot.getChildrenCount();
                        reportCount = reportCount++;
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                String report = String.valueOf(report_box.getText());
                Reports.child(String.valueOf(reportCount)).child("report").setValue(report);
                report_box.setText("");
                Toast.makeText(Report.this, "message Sent",
                        Toast.LENGTH_SHORT).show();

            }
        });

    }



    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back_button, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.back_button:

                //back button has been pressed take user to main activity
                Intent main = new Intent (Report.this, NavigationActivity.class);
                startActivity(main);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}