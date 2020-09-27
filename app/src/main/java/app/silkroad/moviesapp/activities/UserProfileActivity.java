package app.silkroad.moviesapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.application.MoviesApp;
import app.silkroad.moviesapp.utilities.LocaleManager;
import app.silkroad.moviesapp.utilities.SessionManager;

import static android.content.ContentValues.TAG;
import static app.silkroad.moviesapp.application.MoviesApp.languageStrings;

public class UserProfileActivity extends AppCompatActivity {


    AlertDialog levelDialog;
    SessionManager session;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
        Log.d(TAG, "attachBaseContext");
    }


    public static String LOCAL_EN = "en";
    public static String LOCAL_FA = "fa";
    public static String LOCAL_PS = "ps";

    CardView cvChangeLanguage;

    MoviesApp moviesApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        session= SessionManager.getInstance(UserProfileActivity.this);
        cvChangeLanguage=findViewById(R.id.cvChangeLanguage);
        cvChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              showLanguageDialog(getLanguageIndex());
            }
        });
    }




    public void showLanguageDialog(int selectedIndex) {

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.sylanguage);
        builder.setSingleChoiceItems(languageStrings, selectedIndex, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                moviesApp = MoviesApp.getInstance();
                Log.d("data", "onClick: "+moviesApp);

                if (getLanguageIndex() != item) {
                    switch (item) {
                        case 0:
                            moviesApp.setLanguage("en");
                            setLanguage("en");
                            break;
                        case 1:
                            moviesApp.setLanguage("fa");
                            setLanguage("fa");
                            break;
                        case 2:
                            moviesApp.setLanguage("ps");
                            setLanguage("ps");
                            break;
                    }
                }
                levelDialog.dismiss();
            }
        });
        levelDialog = builder.create();
        levelDialog.show();
    }


    private int getLanguageIndex() {
        String lang = session.getLanguage();
        if (lang.equalsIgnoreCase(LOCAL_EN)) {
            return 0;
        } else if (lang.equalsIgnoreCase(LOCAL_FA)) {
            return 1;
        } else if (lang.equals(LOCAL_PS)) {
            return 2;
        }
        return -1;
    }




    private void setLanguage(String lang) {
        LocaleManager.setNewLocale(this, lang);
        Intent i = new Intent(UserProfileActivity.this, UserProfileActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();

    }
}