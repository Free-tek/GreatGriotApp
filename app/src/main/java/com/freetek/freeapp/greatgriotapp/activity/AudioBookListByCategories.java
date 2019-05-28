package com.freetek.freeapp.greatgriotapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.freetek.freeapp.greatgriotapp.Interface.ItemClickListener;
import com.freetek.freeapp.greatgriotapp.Model.AudioBookListByCategoriesModel;
import com.freetek.freeapp.greatgriotapp.R;
import com.freetek.freeapp.greatgriotapp.ViewHolder.AudioBookListByCategoriesViewHolder;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class AudioBookListByCategories extends AppCompatActivity {

    private ActionBar toolbar;

    //View
    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;

    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference AudioBookList;
    FirebaseRecyclerAdapter<AudioBookListByCategoriesModel, AudioBookListByCategoriesViewHolder> adapter;

    String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiobook_category_activity);


        toolbar = getSupportActionBar();
        toolbar.setTitle("Audio Books");

        Bundle bundle = getIntent().getExtras();
        category = bundle.getString("Key");


        //Initialise Firebase
        database = FirebaseDatabase.getInstance();
        AudioBookList = database.getReference("Audiobooks");


        progressBar = (ProgressBar) findViewById(R.id.progress);

        Sprite doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        doubleBounce.setColor(R.color.colorPrimaryDark);
        progressBar.setIndeterminateDrawable(doubleBounce);


        recycler_menu = (RecyclerView) findViewById(R.id.recycler);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);
        loadMenu();


    }

    private void loadMenu() {

        //TODO: Categories changed to trending products change later
        adapter = new FirebaseRecyclerAdapter<AudioBookListByCategoriesModel, AudioBookListByCategoriesViewHolder>(
                AudioBookListByCategoriesModel.class,
                R.layout.audio_book_item,
                AudioBookListByCategoriesViewHolder.class,
                AudioBookList.orderByChild("category").equalTo(category)

        ) {

            @Override
            protected void populateViewHolder(AudioBookListByCategoriesViewHolder viewHolder, AudioBookListByCategoriesModel model, int position) {
                viewHolder.name.setText(model.getName());
                viewHolder.author.setText(model.getAuthor());
                viewHolder.publisher.setText(model.getPublisher());

                Picasso.with(AudioBookListByCategories.this).load(model.getImage())
                        .into(viewHolder.image, new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {
                                progressBar.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError() {

                            }
                        });

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent intent = new Intent(AudioBookListByCategories.this, AudioBookClickedDetail.class);
                        intent.putExtra("Key",  adapter.getRef(position).getKey());
                        intent.putExtra("Category", category);
                        startActivity(intent);
                    }
                });


                viewHolder.image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

            }


        };

        adapter.notifyDataSetChanged(); //Refresh data if changed
        recycler_menu.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
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
                Intent main = new Intent(AudioBookListByCategories.this, AudioBooksCategories.class);
                startActivity(main);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}