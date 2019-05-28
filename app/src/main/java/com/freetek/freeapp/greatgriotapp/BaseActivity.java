package com.freetek.freeapp.greatgriotapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.v4.app.ShareCompat.IntentBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class BaseActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    @VisibleForTesting
    public ProgressDialog mProgressDialog;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public void showProgressDialog() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new ProgressDialog(this);
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.setMessage(getString(R.string.loading));
            this.mProgressDialog.setIndeterminate(true);
        }
        this.mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void hideKeyboard(View view) {
        final InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void shareReferral(String referral) {
        IntentBuilder type = IntentBuilder.from(this).setChooserTitle("Referral Code").setType("text/plain");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Use my referral code and get credited with ₦200 on the FREE APP\n\n");
        stringBuilder.append(referral);
        stringBuilder.append("\n\nDownload the FREE APP at https://playstorelink");
        Intent shareIntent = type.setText(stringBuilder.toString()).getIntent();
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);
        }
    }

    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }
}
