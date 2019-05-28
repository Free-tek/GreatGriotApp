package com.freetek.freeapp.greatgriotapp.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.freetek.freeapp.greatgriotapp.BaseActivity;
import com.freetek.freeapp.greatgriotapp.R;
import com.freetek.freeapp.greatgriotapp.fragments.ForgotPasswordFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends BaseActivity implements View.OnClickListener, ForgotPasswordFragment.OnFragmentInteractionListener {

    private static final String TAG = "EmailPassword";
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private EditText mEmailField, mPasswordField;
    private Button createAccount, signIn;
    private TextView forgot_password_button;


    FirebaseDatabase database = FirebaseDatabase.getInstance();

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    private Context mcontext;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        // Views
        mEmailField = (EditText) findViewById(R.id.email);
        mPasswordField = (EditText) findViewById(R.id.password);

        forgot_password_button = (TextView) findViewById(R.id.forgotPassword);

        createAccount = (Button) findViewById(R.id.createAccount);
        signIn = (Button) findViewById(R.id.signIn);

        mAuth = FirebaseAuth.getInstance();


        Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // User is signed in
            startActivity(intent);
            finish();
        } else {
            // No user is signed in
            //do nothing
        }




        createAccount.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        signIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());

            }
        });
        forgot_password_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.login_fragment_container, new ForgotPasswordFragment()).commit();
            }
        });

    }



    @Override
    public void onStart() {
        super.onStart();
        Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            startActivity(intent);
            finish();
        } else {
            // No user is signed in
        }
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }
        final Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
        showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            final FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            startActivity(intent);
                        } else if(!isNetworkAvailable()){
                            Toast.makeText(LoginActivity.this, "Please check your internet connection",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Wrong login details, please try again",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        // [START_EXCLUDE]
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mEmailField.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Required.");
            valid = false;
        } else {
            mEmailField.setError(null);
        }

        String password = mPasswordField.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("Required.");
            valid = false;
        } else {
            mPasswordField.setError(null);
        }

        return valid;
    }

    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            //findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            findViewById(R.id.password).setVisibility(View.GONE);
        } else {
            //findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.password).setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


