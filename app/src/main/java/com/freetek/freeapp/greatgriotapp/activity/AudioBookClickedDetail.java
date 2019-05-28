package com.freetek.freeapp.greatgriotapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.freetek.freeapp.greatgriotapp.Model.AudioBookListByCategoriesModel;
import com.freetek.freeapp.greatgriotapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AudioBookClickedDetail extends AppCompatActivity {

    private ActionBar toolbar;


    FirebaseDatabase database;
    DatabaseReference AudioBookList;

    private String key, category, bookName;

    private ImageView image, star1, star2, star3, star4, star5, imageComment;

    private ImageView chapter1, chapter10, chapter11,chapter12,chapter13,chapter14,chapter15,chapter16,chapter17,chapter18,chapter19,chapter2,chapter20,chapter21,chapter22,chapter23,chapter24,chapter25,chapter26,chapter27,chapter28,chapter29,chapter3,chapter30,chapter4,chapter5,chapter6,chapter7,chapter8,chapter9;

    private TextView mchapter1, mchapter10, mchapter11,mchapter12,mchapter13,mchapter14,mchapter15,mchapter16,mchapter17,mchapter18,mchapter19,mchapter2,mchapter20,mchapter21,mchapter22,mchapter23,mchapter24,mchapter25,mchapter26,mchapter27,mchapter28,mchapter29,mchapter3,mchapter30,mchapter4,mchapter5,mchapter6,mchapter7,mchapter8,mchapter9;
    private TextView t_chapter1, t_chapter10, t_chapter11,t_chapter12,t_chapter13,t_chapter14,t_chapter15,t_chapter16,t_chapter17,t_chapter18,t_chapter19,t_chapter2,t_chapter20,t_chapter21,t_chapter22,t_chapter23,t_chapter24,t_chapter25,t_chapter26,t_chapter27,t_chapter28,t_chapter29,t_chapter3,t_chapter30,t_chapter4,t_chapter5,t_chapter6,t_chapter7,t_chapter8,t_chapter9;

    private String url,url1,url10,url11,url12,url13,url14,url15,url16,url17,url18,url19,url2,url20,url21,url22,url23,url24,url25,url26,url27,url28,url29,url3,url30,url4,url5,url6,url7,url8,url9;

    private TextView name, author, publisher, date, chapter, pages, textComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_book_clicked_details);


        toolbar = getSupportActionBar();
        toolbar.setTitle("Audio Books");

        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("Key");
        category = bundle.getString("Category");


        //Initialise Firebase
        database = FirebaseDatabase.getInstance();
        AudioBookList = database.getReference("Audiobooks");

        image = (ImageView) findViewById(R.id.image);
        star1 = (ImageView) findViewById(R.id.star1);
        star2 = (ImageView) findViewById(R.id.star2);
        star3 = (ImageView) findViewById(R.id.star3);
        star4 = (ImageView) findViewById(R.id.star4);
        star5 = (ImageView) findViewById(R.id.star5);


        name = (TextView) findViewById(R.id.name);
        author = (TextView) findViewById(R.id.name);
        publisher = (TextView) findViewById(R.id.publisher);
        date = (TextView) findViewById(R.id.date);
        chapter = (TextView) findViewById(R.id.chapter);
        pages = (TextView) findViewById(R.id.pages);
        textComment = (TextView) findViewById(R.id.textComment);
        imageComment = (ImageView) findViewById(R.id.imageComment);

        chapter1 = (ImageView) findViewById(R.id.chapter1);
        chapter2 = (ImageView) findViewById(R.id.chapter2);
        chapter3 = (ImageView) findViewById(R.id.chapter3);
        chapter4 = (ImageView) findViewById(R.id.chapter4);
        chapter5 = (ImageView) findViewById(R.id.chapter5);
        chapter6 = (ImageView) findViewById(R.id.chapter6);
        chapter7 = (ImageView) findViewById(R.id.chapter7);
        chapter8 = (ImageView) findViewById(R.id.chapter8);
        chapter9 = (ImageView) findViewById(R.id.chapter9);
        chapter10 = (ImageView) findViewById(R.id.chapter10);
        chapter11 = (ImageView) findViewById(R.id.chapter11);
        chapter12 = (ImageView) findViewById(R.id.chapter12);
        chapter13 = (ImageView) findViewById(R.id.chapter13);
        chapter14 = (ImageView) findViewById(R.id.chapter14);
        chapter15 = (ImageView) findViewById(R.id.chapter15);
        chapter16 = (ImageView) findViewById(R.id.chapter16);
        chapter17 = (ImageView) findViewById(R.id.chapter17);
        chapter18 = (ImageView) findViewById(R.id.chapter18);
        chapter19 = (ImageView) findViewById(R.id.chapter19);
        chapter20 = (ImageView) findViewById(R.id.chapter20);
        chapter21 = (ImageView) findViewById(R.id.chapter21);
        chapter22 = (ImageView) findViewById(R.id.chapter22);
        chapter23 = (ImageView) findViewById(R.id.chapter23);
        chapter24 = (ImageView) findViewById(R.id.chapter24);
        chapter25 = (ImageView) findViewById(R.id.chapter25);
        chapter26 = (ImageView) findViewById(R.id.chapter26);
        chapter27 = (ImageView) findViewById(R.id.chapter27);
        chapter28 = (ImageView) findViewById(R.id.chapter28);
        chapter29 = (ImageView) findViewById(R.id.chapter29);
        chapter30 = (ImageView) findViewById(R.id.chapter30);


        mchapter1 = (TextView) findViewById(R.id.mchapter1);
        mchapter2 = (TextView) findViewById(R.id.mchapter2);
        mchapter3 = (TextView) findViewById(R.id.mchapter3);
        mchapter4 = (TextView) findViewById(R.id.mchapter4);
        mchapter5 = (TextView) findViewById(R.id.mchapter5);
        mchapter6 = (TextView) findViewById(R.id.mchapter6);
        mchapter7 = (TextView) findViewById(R.id.mchapter7);
        mchapter8 = (TextView) findViewById(R.id.mchapter8);
        mchapter9 = (TextView) findViewById(R.id.mchapter9);
        mchapter10 = (TextView) findViewById(R.id.mchapter10);
        mchapter11 = (TextView) findViewById(R.id.mchapter11);
        mchapter12 = (TextView) findViewById(R.id.mchapter12);
        mchapter13 = (TextView) findViewById(R.id.mchapter13);
        mchapter14 = (TextView) findViewById(R.id.mchapter14);
        mchapter15 = (TextView) findViewById(R.id.mchapter15);
        mchapter16 = (TextView) findViewById(R.id.mchapter16);
        mchapter17 = (TextView) findViewById(R.id.mchapter17);
        mchapter18 = (TextView) findViewById(R.id.mchapter18);
        mchapter19 = (TextView) findViewById(R.id.mchapter19);
        mchapter20 = (TextView) findViewById(R.id.mchapter20);
        mchapter21 = (TextView) findViewById(R.id.mchapter21);
        mchapter22 = (TextView) findViewById(R.id.mchapter22);
        mchapter23 = (TextView) findViewById(R.id.mchapter23);
        mchapter24 = (TextView) findViewById(R.id.mchapter24);
        mchapter25 = (TextView) findViewById(R.id.mchapter25);
        mchapter26 = (TextView) findViewById(R.id.mchapter26);
        mchapter27 = (TextView) findViewById(R.id.mchapter27);
        mchapter28 = (TextView) findViewById(R.id.mchapter28);
        mchapter29 = (TextView) findViewById(R.id.mchapter29);
        mchapter30 = (TextView) findViewById(R.id.mchapter30);


        t_chapter1 = (TextView) findViewById(R.id.t_chapter1);
        t_chapter2 = (TextView) findViewById(R.id.t_chapter2);
        t_chapter3 = (TextView) findViewById(R.id.t_chapter3);
        t_chapter4 = (TextView) findViewById(R.id.t_chapter4);
        t_chapter5 = (TextView) findViewById(R.id.t_chapter5);
        t_chapter6 = (TextView) findViewById(R.id.t_chapter6);
        t_chapter7 = (TextView) findViewById(R.id.t_chapter7);
        t_chapter8 = (TextView) findViewById(R.id.t_chapter8);
        t_chapter9 = (TextView) findViewById(R.id.t_chapter9);
        t_chapter10 = (TextView) findViewById(R.id.t_chapter10);
        t_chapter11 = (TextView) findViewById(R.id.t_chapter11);
        t_chapter12 = (TextView) findViewById(R.id.t_chapter12);
        t_chapter13 = (TextView) findViewById(R.id.t_chapter13);
        t_chapter14 = (TextView) findViewById(R.id.t_chapter14);
        t_chapter15 = (TextView) findViewById(R.id.t_chapter15);
        t_chapter16 = (TextView) findViewById(R.id.t_chapter16);
        t_chapter17 = (TextView) findViewById(R.id.t_chapter17);
        t_chapter18 = (TextView) findViewById(R.id.t_chapter18);
        t_chapter19 = (TextView) findViewById(R.id.t_chapter19);
        t_chapter20 = (TextView) findViewById(R.id.t_chapter20);
        t_chapter21 = (TextView) findViewById(R.id.t_chapter21);
        t_chapter22 = (TextView) findViewById(R.id.t_chapter22);
        t_chapter23 = (TextView) findViewById(R.id.t_chapter23);
        t_chapter24 = (TextView) findViewById(R.id.t_chapter24);
        t_chapter25 = (TextView) findViewById(R.id.t_chapter25);
        t_chapter26 = (TextView) findViewById(R.id.t_chapter26);
        t_chapter27 = (TextView) findViewById(R.id.t_chapter27);
        t_chapter28 = (TextView) findViewById(R.id.t_chapter28);
        t_chapter29 = (TextView) findViewById(R.id.t_chapter29);
        t_chapter30 = (TextView) findViewById(R.id.t_chapter30);


        chapter1.setVisibility(View.INVISIBLE);
        chapter2.setVisibility(View.INVISIBLE);
        chapter3.setVisibility(View.INVISIBLE);
        chapter4.setVisibility(View.INVISIBLE);
        chapter5.setVisibility(View.INVISIBLE);
        chapter6.setVisibility(View.INVISIBLE);
        chapter7.setVisibility(View.INVISIBLE);
        chapter8.setVisibility(View.INVISIBLE);
        chapter9.setVisibility(View.INVISIBLE);
        chapter10.setVisibility(View.INVISIBLE);
        chapter11.setVisibility(View.INVISIBLE);
        chapter12.setVisibility(View.INVISIBLE);
        chapter13.setVisibility(View.INVISIBLE);
        chapter14.setVisibility(View.INVISIBLE);
        chapter15.setVisibility(View.INVISIBLE);
        chapter16.setVisibility(View.INVISIBLE);
        chapter17.setVisibility(View.INVISIBLE);
        chapter18.setVisibility(View.INVISIBLE);
        chapter19.setVisibility(View.INVISIBLE);
        chapter20.setVisibility(View.INVISIBLE);
        chapter21.setVisibility(View.INVISIBLE);
        chapter22.setVisibility(View.INVISIBLE);
        chapter23.setVisibility(View.INVISIBLE);
        chapter24.setVisibility(View.INVISIBLE);
        chapter25.setVisibility(View.INVISIBLE);
        chapter26.setVisibility(View.INVISIBLE);
        chapter27.setVisibility(View.INVISIBLE);
        chapter28.setVisibility(View.INVISIBLE);
        chapter29.setVisibility(View.INVISIBLE);
        chapter30.setVisibility(View.INVISIBLE);


        mchapter1.setVisibility(View.INVISIBLE);
        mchapter2.setVisibility(View.INVISIBLE);
        mchapter3.setVisibility(View.INVISIBLE);
        mchapter4.setVisibility(View.INVISIBLE);
        mchapter5.setVisibility(View.INVISIBLE);
        mchapter6.setVisibility(View.INVISIBLE);
        mchapter7.setVisibility(View.INVISIBLE);
        mchapter8.setVisibility(View.INVISIBLE);
        mchapter9.setVisibility(View.INVISIBLE);
        mchapter10.setVisibility(View.INVISIBLE);
        mchapter11.setVisibility(View.INVISIBLE);
        mchapter12.setVisibility(View.INVISIBLE);
        mchapter13.setVisibility(View.INVISIBLE);
        mchapter14.setVisibility(View.INVISIBLE);
        mchapter15.setVisibility(View.INVISIBLE);
        mchapter16.setVisibility(View.INVISIBLE);
        mchapter17.setVisibility(View.INVISIBLE);
        mchapter18.setVisibility(View.INVISIBLE);
        mchapter19.setVisibility(View.INVISIBLE);
        mchapter20.setVisibility(View.INVISIBLE);
        mchapter21.setVisibility(View.INVISIBLE);
        mchapter22.setVisibility(View.INVISIBLE);
        mchapter23.setVisibility(View.INVISIBLE);
        mchapter24.setVisibility(View.INVISIBLE);
        mchapter25.setVisibility(View.INVISIBLE);
        mchapter26.setVisibility(View.INVISIBLE);
        mchapter27.setVisibility(View.INVISIBLE);
        mchapter28.setVisibility(View.INVISIBLE);
        mchapter29.setVisibility(View.INVISIBLE);
        mchapter30.setVisibility(View.INVISIBLE);

        t_chapter1.setVisibility(View.INVISIBLE);
        t_chapter2.setVisibility(View.INVISIBLE);
        t_chapter3.setVisibility(View.INVISIBLE);
        t_chapter4.setVisibility(View.INVISIBLE);
        t_chapter5.setVisibility(View.INVISIBLE);
        t_chapter6.setVisibility(View.INVISIBLE);
        t_chapter7.setVisibility(View.INVISIBLE);
        t_chapter8.setVisibility(View.INVISIBLE);
        t_chapter9.setVisibility(View.INVISIBLE);
        t_chapter10.setVisibility(View.INVISIBLE);
        t_chapter11.setVisibility(View.INVISIBLE);
        t_chapter12.setVisibility(View.INVISIBLE);
        t_chapter13.setVisibility(View.INVISIBLE);
        t_chapter14.setVisibility(View.INVISIBLE);
        t_chapter15.setVisibility(View.INVISIBLE);
        t_chapter16.setVisibility(View.INVISIBLE);
        t_chapter17.setVisibility(View.INVISIBLE);
        t_chapter18.setVisibility(View.INVISIBLE);
        t_chapter19.setVisibility(View.INVISIBLE);
        t_chapter20.setVisibility(View.INVISIBLE);
        t_chapter21.setVisibility(View.INVISIBLE);
        t_chapter22.setVisibility(View.INVISIBLE);
        t_chapter23.setVisibility(View.INVISIBLE);
        t_chapter24.setVisibility(View.INVISIBLE);
        t_chapter25.setVisibility(View.INVISIBLE);
        t_chapter26.setVisibility(View.INVISIBLE);
        t_chapter27.setVisibility(View.INVISIBLE);
        t_chapter28.setVisibility(View.INVISIBLE);
        t_chapter29.setVisibility(View.INVISIBLE);
        t_chapter30.setVisibility(View.INVISIBLE);


       loadData(key);

        imageComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AudioBookClickedDetail.this, Comments.class);
                intent.putExtra("BookType", "Audiobooks");
                intent.putExtra("Key", key);
                intent.putExtra("Category", category);
                startActivity(intent);
            }
        });

        textComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AudioBookClickedDetail.this, Comments.class);
                intent.putExtra("BookType", "Audiobooks");
                intent.putExtra("Key", key);
                intent.putExtra("Category", category);
                startActivity(intent);
            }
        });


        chapter1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter1");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url1);
                startActivity(chapter);
            }
        });
        chapter2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter2");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url2);
                startActivity(chapter);
            }
        });
        chapter3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter3");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url3);
                startActivity(chapter);
            }
        });chapter4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter4");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url4);
                startActivity(chapter);
            }
        });
        chapter5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter5");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url5);
                startActivity(chapter);
            }
        });
        chapter6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter6");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url6);
                startActivity(chapter);
            }
        });
        chapter7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter7");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url7);
                startActivity(chapter);
            }
        });

        chapter8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter8");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url8);
                startActivity(chapter);
            }
        });
        chapter9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter9");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url9);
                startActivity(chapter);
            }
        });
        chapter10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter10");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url10);
                startActivity(chapter);
            }
        });
        chapter11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter11");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url11);
                startActivity(chapter);
            }
        });
        chapter12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter12");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url12);
                startActivity(chapter);
            }
        });
        chapter13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter13");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url13);
                startActivity(chapter);
            }
        });
        chapter14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter14");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url14);
                startActivity(chapter);
            }
        });
        chapter15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter15");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url15);
                startActivity(chapter);
            }
        });
        chapter16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter16");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url16);
                startActivity(chapter);
            }
        });
        chapter17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter17");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url17);
                startActivity(chapter);
            }
        });
        chapter18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter18");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url18);
                startActivity(chapter);
            }
        });
        chapter19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter19");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url19);
                startActivity(chapter);
            }
        });
        chapter20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter20");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url20);
                startActivity(chapter);
            }
        });
        chapter21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter21");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url21);
                startActivity(chapter);
            }
        });
        chapter22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter22");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url22);
                startActivity(chapter);
            }
        });
        chapter23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter23");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url23);
                startActivity(chapter);
            }
        });
        chapter24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter24");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url24);
                startActivity(chapter);
            }
        });
        chapter25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter25");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url25);
                startActivity(chapter);
            }
        });
        chapter26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter26");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url26);
                startActivity(chapter);
            }
        });
        chapter27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter27");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url27);
                startActivity(chapter);
            }
        });
        chapter28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter28");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url28);
                startActivity(chapter);
            }
        });
        chapter29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter29");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url29);
                startActivity(chapter);
            }
        });
        chapter30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter30");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url30);
                startActivity(chapter);
            }
        });chapter8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter8");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url8);
                startActivity(chapter);
            }
        });
        chapter9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter9");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url9);
                startActivity(chapter);
            }
        });
        chapter10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter10");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url10);
                startActivity(chapter);
            }
        });
        chapter11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter11");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url11);
                startActivity(chapter);
            }
        });
        chapter12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter12");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url12);
                startActivity(chapter);
            }
        });
        chapter13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter13");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url13);
                startActivity(chapter);
            }
        });
        chapter14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter14");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url14);
                startActivity(chapter);
            }
        });
        chapter15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter15");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url15);
                startActivity(chapter);
            }
        });
        chapter16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter16");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url16);
                startActivity(chapter);
            }
        });
        chapter17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter17");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url17);
                startActivity(chapter);
            }
        });
        chapter18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter18");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url18);
                startActivity(chapter);
            }
        });
        chapter19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter19");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url19);
                startActivity(chapter);
            }
        });
        chapter20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter20");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url20);
                startActivity(chapter);
            }
        });
        chapter21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter21");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url21);
                startActivity(chapter);
            }
        });
        chapter22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter22");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url22);
                startActivity(chapter);
            }
        });
        chapter23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter23");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url23);
                startActivity(chapter);
            }
        });
        chapter24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter24");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url24);
                startActivity(chapter);
            }
        });
        chapter25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter25");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url25);
                startActivity(chapter);
            }
        });
        chapter26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter26");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url26);
                startActivity(chapter);
            }
        });
        chapter27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter27");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url27);
                startActivity(chapter);
            }
        });
        chapter28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter28");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url28);
                startActivity(chapter);
            }
        });
        chapter29.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter29");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url29);
                startActivity(chapter);
            }
        });
        chapter30.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent chapter = new Intent(AudioBookClickedDetail.this, ListenToAudioBook.class);
                chapter.putExtra("Key", key);
                chapter.putExtra("Chapter", "chapter30");
                chapter.putExtra("Book", bookName);
                chapter.putExtra("Url", url30);
                startActivity(chapter);
            }
        });



    }

    private void loadData(final String key) {

        AudioBookList.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                AudioBookListByCategoriesModel model = (AudioBookListByCategoriesModel) dataSnapshot.child(key).getValue(AudioBookListByCategoriesModel.class);
                name.setText(model.getName());
                author.setText(model.getAuthor());
                publisher.setText(model.getPublisher());
                date.setText(model.getYear());
                chapter.setText(model.getChapters());
                pages.setText(model.getPages());

                Glide.with(image.getContext()).load(model.getImage()).into(image);



                int rating = Integer.parseInt(String.valueOf(dataSnapshot.child(key).child("rating").getValue()));

                if (rating == 1) {
                    star1.setVisibility(View.VISIBLE);
                } else if (rating == 2) {
                    star1.setVisibility(View.VISIBLE);
                    star2.setVisibility(View.VISIBLE);
                } else if (rating == 3) {
                    star1.setVisibility(View.VISIBLE);
                    star2.setVisibility(View.VISIBLE);
                    star3.setVisibility(View.VISIBLE);
                } else if (rating == 4) {
                    star1.setVisibility(View.VISIBLE);
                    star2.setVisibility(View.VISIBLE);
                    star3.setVisibility(View.VISIBLE);
                    star4.setVisibility(View.VISIBLE);
                } else if (rating == 5) {
                    star1.setVisibility(View.VISIBLE);
                    star2.setVisibility(View.VISIBLE);
                    star3.setVisibility(View.VISIBLE);
                    star4.setVisibility(View.VISIBLE);
                    star5.setVisibility(View.VISIBLE);
                }

                bookName = String.valueOf(name.getText());

                url1 = String.valueOf(dataSnapshot.child(key).child("chapter1").getValue());
                url2 = String.valueOf(dataSnapshot.child(key).child("chapter2").getValue());
                url3 = String.valueOf(dataSnapshot.child(key).child("chapter3").getValue());
                url4 = String.valueOf(dataSnapshot.child(key).child("chapter4").getValue());
                url5 = String.valueOf(dataSnapshot.child(key).child("chapter5").getValue());
                url6 = String.valueOf(dataSnapshot.child(key).child("chapter6").getValue());
                url7 = String.valueOf(dataSnapshot.child(key).child("chapter7").getValue());
                url8 = String.valueOf(dataSnapshot.child(key).child("chapter8").getValue());
                url9 = String.valueOf(dataSnapshot.child(key).child("chapter9").getValue());
                url10 = String.valueOf(dataSnapshot.child(key).child("chapter10").getValue());
                url11 = String.valueOf(dataSnapshot.child(key).child("chapter11").getValue());
                url12 = String.valueOf(dataSnapshot.child(key).child("chapter12").getValue());
                url13 = String.valueOf(dataSnapshot.child(key).child("chapter13").getValue());
                url14 = String.valueOf(dataSnapshot.child(key).child("chapter14").getValue());
                url15 = String.valueOf(dataSnapshot.child(key).child("chapter15").getValue());
                url16 = String.valueOf(dataSnapshot.child(key).child("chapter16").getValue());
                url17 = String.valueOf(dataSnapshot.child(key).child("chapter17").getValue());
                url18 = String.valueOf(dataSnapshot.child(key).child("chapter18").getValue());
                url19 = String.valueOf(dataSnapshot.child(key).child("chapter19").getValue());
                url20 = String.valueOf(dataSnapshot.child(key).child("chapter20").getValue());
                url21 = String.valueOf(dataSnapshot.child(key).child("chapter21").getValue());
                url22 = String.valueOf(dataSnapshot.child(key).child("chapter22").getValue());
                url23 = String.valueOf(dataSnapshot.child(key).child("chapter23").getValue());
                url24 = String.valueOf(dataSnapshot.child(key).child("chapter24").getValue());
                url25 = String.valueOf(dataSnapshot.child(key).child("chapter25").getValue());
                url26 = String.valueOf(dataSnapshot.child(key).child("chapter26").getValue());
                url27 = String.valueOf(dataSnapshot.child(key).child("chapter27").getValue());
                url28 = String.valueOf(dataSnapshot.child(key).child("chapter28").getValue());
                url29 = String.valueOf(dataSnapshot.child(key).child("chapter29").getValue());
                url30 = String.valueOf(dataSnapshot.child(key).child("chapter30").getValue());


                int noChapter = Integer.parseInt(model.getChapters());

                if (noChapter == 1) {
                    chapter1.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                } else if (noChapter == 2) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                } else if (noChapter == 3) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                } else if (noChapter == 4) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                } else if (noChapter == 5) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                } else if (noChapter == 6) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                } else if (noChapter == 7) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                } else if (noChapter == 8) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                } else if (noChapter == 9) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                } else if (noChapter == 10) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                } else if (noChapter == 11) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                } else if (noChapter == 12) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                } else if (noChapter == 13) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                } else if (noChapter == 14) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                } else if (noChapter == 15) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                } else if (noChapter == 16) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                } else if (noChapter == 17) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                } else if (noChapter == 18) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                } else if (noChapter == 19) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                } else if (noChapter == 20) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                } else if (noChapter == 21) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                } else if (noChapter == 22) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                } else if (noChapter == 23) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                } else if (noChapter == 24) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                } else if (noChapter == 25) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    chapter25.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    mchapter25.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                    t_chapter25.setVisibility(View.VISIBLE);
                } else if (noChapter == 26) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    chapter25.setVisibility(View.VISIBLE);
                    chapter26.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    mchapter25.setVisibility(View.VISIBLE);
                    mchapter26.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                    t_chapter25.setVisibility(View.VISIBLE);
                    t_chapter26.setVisibility(View.VISIBLE);
                } else if (noChapter == 27) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    chapter25.setVisibility(View.VISIBLE);
                    chapter26.setVisibility(View.VISIBLE);
                    chapter27.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    mchapter25.setVisibility(View.VISIBLE);
                    mchapter26.setVisibility(View.VISIBLE);
                    mchapter27.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                    t_chapter25.setVisibility(View.VISIBLE);
                    t_chapter26.setVisibility(View.VISIBLE);
                    t_chapter27.setVisibility(View.VISIBLE);
                } else if (noChapter == 28) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    chapter25.setVisibility(View.VISIBLE);
                    chapter26.setVisibility(View.VISIBLE);
                    chapter27.setVisibility(View.VISIBLE);
                    chapter28.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    mchapter25.setVisibility(View.VISIBLE);
                    mchapter26.setVisibility(View.VISIBLE);
                    mchapter27.setVisibility(View.VISIBLE);
                    mchapter28.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                    t_chapter25.setVisibility(View.VISIBLE);
                    t_chapter26.setVisibility(View.VISIBLE);
                    t_chapter27.setVisibility(View.VISIBLE);
                    t_chapter28.setVisibility(View.VISIBLE);
                } else if (noChapter == 29) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    chapter25.setVisibility(View.VISIBLE);
                    chapter26.setVisibility(View.VISIBLE);
                    chapter27.setVisibility(View.VISIBLE);
                    chapter28.setVisibility(View.VISIBLE);
                    chapter29.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    mchapter25.setVisibility(View.VISIBLE);
                    mchapter26.setVisibility(View.VISIBLE);
                    mchapter27.setVisibility(View.VISIBLE);
                    mchapter28.setVisibility(View.VISIBLE);
                    mchapter29.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                    t_chapter25.setVisibility(View.VISIBLE);
                    t_chapter26.setVisibility(View.VISIBLE);
                    t_chapter27.setVisibility(View.VISIBLE);
                    t_chapter28.setVisibility(View.VISIBLE);
                    t_chapter29.setVisibility(View.VISIBLE);
                } else if (noChapter == 30) {
                    chapter1.setVisibility(View.VISIBLE);
                    chapter2.setVisibility(View.VISIBLE);
                    chapter3.setVisibility(View.VISIBLE);
                    chapter4.setVisibility(View.VISIBLE);
                    chapter5.setVisibility(View.VISIBLE);
                    chapter6.setVisibility(View.VISIBLE);
                    chapter7.setVisibility(View.VISIBLE);
                    chapter8.setVisibility(View.VISIBLE);
                    chapter9.setVisibility(View.VISIBLE);
                    chapter10.setVisibility(View.VISIBLE);
                    chapter11.setVisibility(View.VISIBLE);
                    chapter12.setVisibility(View.VISIBLE);
                    chapter13.setVisibility(View.VISIBLE);
                    chapter14.setVisibility(View.VISIBLE);
                    chapter15.setVisibility(View.VISIBLE);
                    chapter16.setVisibility(View.VISIBLE);
                    chapter17.setVisibility(View.VISIBLE);
                    chapter18.setVisibility(View.VISIBLE);
                    chapter19.setVisibility(View.VISIBLE);
                    chapter20.setVisibility(View.VISIBLE);
                    chapter21.setVisibility(View.VISIBLE);
                    chapter22.setVisibility(View.VISIBLE);
                    chapter23.setVisibility(View.VISIBLE);
                    chapter24.setVisibility(View.VISIBLE);
                    chapter25.setVisibility(View.VISIBLE);
                    chapter26.setVisibility(View.VISIBLE);
                    chapter27.setVisibility(View.VISIBLE);
                    chapter28.setVisibility(View.VISIBLE);
                    chapter29.setVisibility(View.VISIBLE);
                    chapter30.setVisibility(View.VISIBLE);
                    mchapter1.setVisibility(View.VISIBLE);
                    mchapter2.setVisibility(View.VISIBLE);
                    mchapter3.setVisibility(View.VISIBLE);
                    mchapter4.setVisibility(View.VISIBLE);
                    mchapter5.setVisibility(View.VISIBLE);
                    mchapter6.setVisibility(View.VISIBLE);
                    mchapter7.setVisibility(View.VISIBLE);
                    mchapter8.setVisibility(View.VISIBLE);
                    mchapter9.setVisibility(View.VISIBLE);
                    mchapter10.setVisibility(View.VISIBLE);
                    mchapter11.setVisibility(View.VISIBLE);
                    mchapter12.setVisibility(View.VISIBLE);
                    mchapter13.setVisibility(View.VISIBLE);
                    mchapter14.setVisibility(View.VISIBLE);
                    mchapter15.setVisibility(View.VISIBLE);
                    mchapter16.setVisibility(View.VISIBLE);
                    mchapter17.setVisibility(View.VISIBLE);
                    mchapter18.setVisibility(View.VISIBLE);
                    mchapter19.setVisibility(View.VISIBLE);
                    mchapter20.setVisibility(View.VISIBLE);
                    mchapter21.setVisibility(View.VISIBLE);
                    mchapter22.setVisibility(View.VISIBLE);
                    mchapter23.setVisibility(View.VISIBLE);
                    mchapter24.setVisibility(View.VISIBLE);
                    mchapter25.setVisibility(View.VISIBLE);
                    mchapter26.setVisibility(View.VISIBLE);
                    mchapter27.setVisibility(View.VISIBLE);
                    mchapter28.setVisibility(View.VISIBLE);
                    mchapter29.setVisibility(View.VISIBLE);
                    mchapter30.setVisibility(View.VISIBLE);
                    t_chapter1.setVisibility(View.VISIBLE);
                    t_chapter2.setVisibility(View.VISIBLE);
                    t_chapter3.setVisibility(View.VISIBLE);
                    t_chapter4.setVisibility(View.VISIBLE);
                    t_chapter5.setVisibility(View.VISIBLE);
                    t_chapter6.setVisibility(View.VISIBLE);
                    t_chapter7.setVisibility(View.VISIBLE);
                    t_chapter8.setVisibility(View.VISIBLE);
                    t_chapter9.setVisibility(View.VISIBLE);
                    t_chapter10.setVisibility(View.VISIBLE);
                    t_chapter11.setVisibility(View.VISIBLE);
                    t_chapter12.setVisibility(View.VISIBLE);
                    t_chapter13.setVisibility(View.VISIBLE);
                    t_chapter14.setVisibility(View.VISIBLE);
                    t_chapter15.setVisibility(View.VISIBLE);
                    t_chapter16.setVisibility(View.VISIBLE);
                    t_chapter17.setVisibility(View.VISIBLE);
                    t_chapter18.setVisibility(View.VISIBLE);
                    t_chapter19.setVisibility(View.VISIBLE);
                    t_chapter20.setVisibility(View.VISIBLE);
                    t_chapter21.setVisibility(View.VISIBLE);
                    t_chapter22.setVisibility(View.VISIBLE);
                    t_chapter23.setVisibility(View.VISIBLE);
                    t_chapter24.setVisibility(View.VISIBLE);
                    t_chapter25.setVisibility(View.VISIBLE);
                    t_chapter26.setVisibility(View.VISIBLE);
                    t_chapter27.setVisibility(View.VISIBLE);
                    t_chapter28.setVisibility(View.VISIBLE);
                    t_chapter29.setVisibility(View.VISIBLE);
                    t_chapter30.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
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
                Intent main = new Intent(AudioBookClickedDetail.this, AudioBookListByCategories.class);
                main.putExtra("Key", category);
                startActivity(main);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


