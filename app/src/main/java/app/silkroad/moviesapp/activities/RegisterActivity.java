package app.silkroad.moviesapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.application.MoviesApp;
import app.silkroad.moviesapp.utilities.SessionManager;

public class RegisterActivity extends AppCompatActivity {

    TextView tvRegister;

    EditText etEmailSignUp,etPasswordSignUp,etConfirmPasswordSignUp;
    Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        tvRegister=findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ShowSignUpDialog();
            }
        });





    }

    private void ShowSignUpDialog() {



        View dialog= LayoutInflater.from(RegisterActivity.this).inflate(R.layout.signup_dialog,null);

        final AlertDialog alertDialog=new AlertDialog.Builder(this).create();

        alertDialog.setView(dialog);

        etEmailSignUp = dialog.findViewById(R.id.editTextTextEmailAddress);
        etPasswordSignUp = dialog.findViewById(R.id.etPassword);
        etConfirmPasswordSignUp  = dialog.findViewById(R.id.etConfirmPassword);


        btnSignUp=dialog.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
            alertDialog.dismiss();

            }
        });

        alertDialog.show();

        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setCancelable(true);


    }
}