package com.freetek.freeapp.greatgriotapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.freetek.freeapp.greatgriotapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.support.constraint.Constraints.TAG;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {


    public ImageView close;
    public EditText name, email, phone_no, password, confirm_password, user_name;
    public RadioGroup radioGroup;
    public RadioButton male, female;
    public Spinner age_range, country;
    public Button signUp;
    private String mGender;

    private FirebaseAuth mAuth;

    FirebaseDatabase db;
    DatabaseReference usersID;

    private int $count;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);

        close = (ImageView) findViewById(R.id.close);
        name =(EditText) findViewById(R.id.name);
        email =(EditText) findViewById(R.id.email);
        phone_no =(EditText) findViewById(R.id.phone_no);
        password =(EditText) findViewById(R.id.password);
        confirm_password =(EditText) findViewById(R.id.confirm_password);
        user_name =(EditText) findViewById(R.id.user_name);
        signUp =(Button) findViewById(R.id.signUp);


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);

        age_range = (Spinner) findViewById(R.id.age_range);
        country = (Spinner) findViewById(R.id.country);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        usersID = db.getReference("userId");

        usersID.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                $count = (int) dataSnapshot.getChildrenCount();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(SignUpActivity.this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.age_range));
        dataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        age_range.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(SignUpActivity.this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.country));
        dataAdapter2.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        country.setAdapter(dataAdapter2);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(back);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateForm()){
                    Toast.makeText(SignUpActivity.this, "Make sure to fill all the required fields",
                            Toast.LENGTH_SHORT).show();
                }else{
                    getInformation();
                }
            }
        });
    }



    private void getInformation() {
        String $name = String.valueOf(name.getText());
        String $email = String.valueOf(email.getText());
        String $phone_no = String.valueOf(phone_no.getText());
        String $password = String.valueOf(password.getText());
        String $user_name = String.valueOf(user_name.getText());
        String $age = String.valueOf(age_range.getSelectedItem());
        String $country = String.valueOf(age_range.getSelectedItem());
        String  $sex = getSex();

        createAccount($name, $email, $phone_no, $password, $user_name, $age, $country, $sex);

    }

    private void createAccount(final String $name, final String $email, final String $phone_no, final String $password, final String $user_name, final String $age, final String $country, final String $sex) {
        final Intent intent = new Intent(SignUpActivity.this, NavigationActivity.class);

        final AlertDialog alertDialog = new AlertDialog.Builder(SignUpActivity.this).create();
        alertDialog.setTitle("Terms and Conditions");
        alertDialog.setMessage("*By using The Great Griot App you agree to oblige by all the rules that will be stated by the app administrator from time to time \n"

                + "*You also agree not to unlawfully reproduce or sell any of the contents available on this app wether free or payed for"
        );
        alertDialog.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(SignUpActivity.this.getResources().getColor(R.color.colorPrimaryDark));
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(SignUpActivity.this.getResources().getColor(R.color.colorPrimaryDark));
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Agree",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        mAuth.createUserWithEmailAndPassword($email, $password)
                                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        if (task.isSuccessful()) {
                                            // Sign in success, update UI with the signed-in user's information
                                            Log.d(TAG, "createUserWithEmail:success");
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            saveData($name, $email, $phone_no, $password, $user_name, $age, $country, $sex);
                                            sendEmailVerification();
                                            startActivity(intent);
                                            finish();
                                        }else {
                                            // If sign in fails, display a message to the user.
                                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                            Toast.makeText(SignUpActivity.this, "Sign up failed, please check your network and try again",
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });

                    }
                });


        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Dismiss",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });

        alertDialog.show();




    }

    private void saveData(String $name, String $email, String $phone_no, String $password, String $user_name, String $age, String $country, String $sex) {
        final String uid = mAuth.getCurrentUser().getUid();
        DatabaseReference userId = db.getReference().child("users").child(uid);

        userId.child("name").setValue($name);
        userId.child("gender").setValue($email);
        userId.child("phone").setValue($phone_no);
        userId.child("password").setValue($password);
        userId.child("user_name").setValue($user_name);
        userId.child("age_group").setValue($age);
        userId.child("country").setValue($country);
        userId.child("sex").setValue($sex);
        userId.child("staff").setValue("false");


        //lets create a new node on firebase containing each user email as parent and their userID as a child

        usersID.child(String.valueOf($count+1)).child("email").setValue($email);
        usersID.child(String.valueOf($count+1)).child("userId").setValue(uid);


    }


    private void sendEmailVerification() {

        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(SignUpActivity.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    private String getSex() {
        if (female.isChecked()) {
            mGender = "female";
        } else if (male.isChecked()) {
            mGender = "male";
        }
        return mGender;
    }

    private boolean validateForm() {
        boolean valid = true;


        String $email = email.getText().toString();
        if (TextUtils.isEmpty($email)) {
            email.setError("Required.");
            valid = false;
        } else {
            email.setError(null);
        }

        String $name = name.getText().toString();
        if (TextUtils.isEmpty($name)) {
            name.setError("Required.");
            valid = false;
        } else {
            name.setError(null);
        }

        String $password = password.getText().toString();
        if (TextUtils.isEmpty($password)) {
            password.setError("Required.");
            valid = false;
        } else {
            password.setError(null);
        }

        String $cpassword = confirm_password.getText().toString();
        if (TextUtils.isEmpty($cpassword)) {
            confirm_password.setError("Required.");
            valid = false;
        } else {
            confirm_password.setError(null);
        }

        if(confirm_password != password){
            password.setError("Password do not match");
        }

        String $phone_no = phone_no.getText().toString();
        if (TextUtils.isEmpty($phone_no)) {
            phone_no.setError("Invalid Date of Birth");
            valid = false;
        } else {
            phone_no.setError(null);
        }

        String $userName = user_name.getText().toString();
        if (TextUtils.isEmpty($userName)) {
            user_name.setError("Required.");
            valid = false;
        } else {
            user_name.setError(null);
        }
        return valid;
    }


    @Override
    public void onClick(View v) {

    }
}