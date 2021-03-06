package com.freetek.freeapp.greatgriotapp.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.freetek.freeapp.greatgriotapp.Interface.ItemClickListener;
import com.freetek.freeapp.greatgriotapp.Model.Categories;
import com.freetek.freeapp.greatgriotapp.R;
import com.freetek.freeapp.greatgriotapp.ViewHolder.CategoriesViewHolder;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.Wave;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class AudioBooksCategories extends AppCompatActivity {

    private ActionBar toolbar;

    //View
    RecyclerView recycler_menu;

    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference CategoriesList;
    FirebaseRecyclerAdapter<Categories, CategoriesViewHolder> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audiobook_category_activity);


        toolbar = getSupportActionBar();
        toolbar.setTitle("Audio Book Categories");

        //Initialise Firebase
        database = FirebaseDatabase.getInstance();
        CategoriesList = database.getReference("categories");


        progressBar = (ProgressBar)findViewById(R.id.progress);

        Sprite doubleBounce = new DoubleBounce();
        progressBar.setIndeterminateDrawable(doubleBounce);
        doubleBounce.setColor(R.color.colorPrimaryDark);
        progressBar.setIndeterminateDrawable(doubleBounce);



        recycler_menu = (RecyclerView) findViewById(R.id.recycler);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(AudioBooksCategories.this, 2);
        recycler_menu.setLayoutManager(mLayoutManager);
        recycler_menu.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recycler_menu.setItemAnimator(new DefaultItemAnimator());
        recycler_menu.setNestedScrollingEnabled(false);
        loadMenu();


    }

    /**
     * Converting dp to pixel
     */

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private void loadMenu() {

        //TODO: Categories changed to trending products change later
        adapter = new FirebaseRecyclerAdapter<Categories, CategoriesViewHolder>(
                Categories.class,
                R.layout.categories_card,
                CategoriesViewHolder.class,
                CategoriesList

        ) {

            @Override
            protected void populateViewHolder(final CategoriesViewHolder viewHolder, Categories model, int position) {
                viewHolder.name.setText(model.getName());
                Picasso.with(AudioBooksCategories.this).load(model.getImageUrl())
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
                        String biography = "Biography";
                        String Business = "Business";
                        String Fiction = "Fiction";
                        String Health = "Health and Lifestyle";
                        String History = "History";
                        String Marriage = "Marriage and Relationship";
                        String NonFiction = "Non fiction";
                        String Others = "Others";
                        String Religion = "Religion";
                        String Scifi = "Scifi";

                        String type = String.valueOf(viewHolder.name.getText());

                        if(type.equals(biography)){
                            Intent ibiography = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            ibiography.putExtra("Key", "01");
                            startActivity(ibiography);
                        }else if(type.equals(Business)) {
                            Intent ibusiness = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            ibusiness.putExtra("Key", "02");
                            startActivity(ibusiness);
                        }else if(type.equals(Fiction)) {
                            Intent iFiction = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iFiction.putExtra("Key", "04");
                            startActivity(iFiction);
                        }else if(type.equals(Health)) {
                            Intent iHealth = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iHealth.putExtra("Key", "05");
                            startActivity(iHealth);
                        }else if(type.equals(History)) {
                            Intent iHistory = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iHistory.putExtra("Key", "06");
                            startActivity(iHistory);
                        }else if(type.equals(Marriage)) {
                            Intent iMarriage = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iMarriage.putExtra("Key", "07");
                            startActivity(iMarriage);
                        }else if(type.equals(NonFiction)) {
                            Intent iNonFiction = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iNonFiction.putExtra("Key", "03");
                            startActivity(iNonFiction);
                        }else if(type.equals(Others)) {
                            Intent iOthers = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iOthers.putExtra("Key", "10");
                            startActivity(iOthers);
                        }else if(type.equals(Religion)) {
                            Intent iReligion = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iReligion.putExtra("Key", "08");
                            startActivity(iReligion);
                        }else if(type.equals(Scifi)) {
                            Intent iScifi = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iScifi.putExtra("Key", "09");
                            startActivity(iScifi);
                        }
                    }
                });


                viewHolder.image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String biography = "Biography";
                        String Business = "Business";
                        String Fiction = "Fiction";
                        String Health = "Health and Lifestyle";
                        String History = "History";
                        String Marriage = "Marriage and Relationship";
                        String NonFiction = "Non fiction";
                        String Others = "Others";
                        String Religion = "Religion";
                        String Scifi = "Scifi";

                        String type = String.valueOf(viewHolder.name.getText());


                        if(type.equals(biography)){
                            Intent ibiography = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            ibiography.putExtra("Key", "01");
                            startActivity(ibiography);
                        }else if(type.equals(Business)) {
                            //pass an intent to male Fashion category
                            Intent ibusiness = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            ibusiness.putExtra("Key", "02");
                            startActivity(ibusiness);
                        }else if(type.equals(Fiction)) {
                            //pass an intent to male Fashion category
                            Intent iFiction = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iFiction.putExtra("Key", "04");
                            startActivity(iFiction);
                        }else if(type.equals(Health)) {
                            //pass an intent to male Fashion category
                            Intent iHealth = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iHealth.putExtra("Key", "05");
                            startActivity(iHealth);
                        }else if(type.equals(History)) {
                            //pass an intent to male Fashion category
                            Intent iHistory = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iHistory.putExtra("Key", "06");
                            startActivity(iHistory);
                        }else if(type.equals(Marriage)) {
                            //pass an intent to male Fashion category
                            Intent iMarriage = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iMarriage.putExtra("Key", "07");
                            startActivity(iMarriage);
                        }else if(type.equals(NonFiction)) {
                            //pass an intent to male Fashion category
                            Intent iNonFiction = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iNonFiction.putExtra("Key", "03");
                            startActivity(iNonFiction);
                        }else if(type.equals(Others)) {
                            //pass an intent to male Fashion category
                            Intent iOthers = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iOthers.putExtra("Key", "10");
                            startActivity(iOthers);
                        }else if(type.equals(Religion)) {
                            //pass an intent to male Fashion category
                            Intent iReligion = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iReligion.putExtra("Key", "08");
                            startActivity(iReligion);
                        }else if(type.equals(Scifi)) {
                            //pass an intent to male Fashion category
                            Intent iScifi = new Intent(AudioBooksCategories.this, AudioBookListByCategories.class);
                            iScifi.putExtra("Key", "09");
                            startActivity(iScifi);
                        }
                    }
                });

            }

        };

        adapter.notifyDataSetChanged(); //Refresh data if changed
        recycler_menu.setAdapter(adapter);

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
                Intent main = new Intent (AudioBooksCategories.this, NavigationActivity.class);
                startActivity(main);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }


    }
}