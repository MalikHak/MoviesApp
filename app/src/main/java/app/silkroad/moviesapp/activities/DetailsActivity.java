package app.silkroad.moviesapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import app.silkroad.moviesapp.R;
import app.silkroad.moviesapp.utilities.LocaleManager;
import app.silkroad.moviesapp.utilities.SessionManager;

import static android.content.ContentValues.TAG;

public class DetailsActivity extends AppCompatActivity {

    SessionManager sessionManager;
    String highScore;
    TextView tvHighScore;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
        Log.d(TAG, "attachBaseContext");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        sessionManager =new SessionManager(DetailsActivity.this);
        highScore = sessionManager.getHighScore();

        tvHighScore=findViewById(R.id.tvHighScore);

        tvHighScore.setText(highScore);

    }
}