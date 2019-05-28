package com.freetek.freeapp.greatgriotapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.freetek.freeapp.greatgriotapp.Interface.ItemClickListener;
import com.freetek.freeapp.greatgriotapp.Model.CommentModel;
import com.freetek.freeapp.greatgriotapp.R;
import com.freetek.freeapp.greatgriotapp.ViewHolder.CommentViewHolder;
import com.github.ybq.android.spinkit.style.Wave;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Comments extends AppCompatActivity {

    private ActionBar toolbar;

    //View
    RecyclerView recycler_menu;
    EditText comment_box;
    RecyclerView.LayoutManager layoutManager;

    ProgressBar progressBar;

    FirebaseDatabase database;
    DatabaseReference Comment;
    FirebaseRecyclerAdapter<CommentModel, CommentViewHolder> adapter;

    private String bookType, key, category;

    private ImageView send;
    private EditText commentBox;
    int commentCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments_activity);


        toolbar = getSupportActionBar();
        toolbar.setTitle("Comments");


        Bundle bundle = getIntent().getExtras();
        bookType = bundle.getString("BookType");
        key =  bundle.getString("Key");
        category = bundle.getString("Category");


        send = (ImageView) findViewById(R.id.send);
        commentBox = (EditText) findViewById(R.id.comment_box);

        //Initialise Firebase
        database = FirebaseDatabase.getInstance();
        Comment = database.getReference(bookType).child(key).child("comments");

        progressBar = (ProgressBar) findViewById(R.id.progress);

        progressBar = (ProgressBar)findViewById(R.id.progress);
        Wave mWave = new Wave();
        mWave.setBounds(0,0,100,100);
        mWave.setColor(R.color.colorAccent);
        progressBar.setIndeterminateDrawable(mWave);


        recycler_menu = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_menu.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);
        loadMenu();


        commentCount = 0;
        Comment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                commentCount = (int) dataSnapshot.getChildrenCount();
                commentCount = commentCount++;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveComment();
            }
        });
    }

    private void saveComment() {
        final String comment;
        comment = String.valueOf(commentBox.getText());
        Comment.child(String.valueOf(commentCount)).setValue(comment);
        commentBox.setText("");
        Toast.makeText(Comments.this, "comment Sent",
                Toast.LENGTH_SHORT).show();
    }


    private void loadMenu(){
        //TODO: Categories changed to trending products change later
        adapter = new FirebaseRecyclerAdapter<CommentModel, CommentViewHolder>(
                CommentModel.class,
                R.layout.comment_item,
                CommentViewHolder.class,
                Comment

        ) {

            @Override
            protected void populateViewHolder(CommentViewHolder viewHolder, CommentModel model, int position) {
                viewHolder.user.setText(model.getUser());
                viewHolder.comment.setText(model.getComment());


                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                    }
                });

            }


        };

        adapter.notifyDataSetChanged(); //Refresh data if changed
        recycler_menu.setAdapter(adapter);
    }

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

                Bundle bundle = getIntent().getExtras();
                key = bundle.getString("Key");
                category = bundle.getString("Category");

                //back button has been pressed take user to main activity
                Intent main = new Intent(Comments.this, EBookClickedDetail.class);
                main.putExtra("Key", key);
                main.putExtra("Category", category );
                startActivity(main);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}