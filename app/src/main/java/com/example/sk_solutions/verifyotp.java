package com.example.sk_solutions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verifyotp extends AppCompatActivity {
Button vBttn;
EditText otpcode;
ProgressBar progress;
String verificationCodeBySystem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyotp);
        getSupportActionBar().hide();

    vBttn=findViewById(R.id.submitbttn);
    otpcode=findViewById(R.id.otptxt);
        progress=findViewById(R.id.prograssbar);
    String phoneno=getIntent().getStringExtra("phoneno");

    sendVerificationCodeToUser(phoneno);
    }
    private void sendVerificationCodeToUser(String phoneno){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91"+phoneno,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
       private  void verifyCode(String verificationCode){
           PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationCodeBySystem,verificationCode);
           signin(credential);
       }
       private void signin(PhoneAuthCredential credential){
           FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
           firebaseAuth.signInWithCredential(credential).addOnCompleteListener(verifyotp.this, new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Intent intent=new Intent(getApplicationContext(),mainhome.class);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                   }
                   else{
                       Toast.makeText(verifyotp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
               }
           });


        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationCodeBySystem =s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
       String code=phoneAuthCredential.getSmsCode();
       if(code!=null){
           progress.setVisibility(View.VISIBLE);
           verifyCode(code);

       }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(verifyotp.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    };
}