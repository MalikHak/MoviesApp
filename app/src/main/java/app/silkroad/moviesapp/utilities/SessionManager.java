package app.silkroad.moviesapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import app.silkroad.moviesapp.application.MoviesApp;
import app.silkroad.moviesapp.models.Movies;

public class SessionManager {
 MoviesApp myApp;
 Context context;

 static SessionManager instance;

 String PREF_NAME="MoviesApp";
 int PRIVATE_MODE = 0;


 private String HIGH_SCORE_USER = "highscore";

 private SharedPreferences pref;
 private SharedPreferences.Editor editor;


    public SessionManager(Context context) {
      this.context=context;
      //Getting instance App;
      myApp= MoviesApp.getInstance();

      //Making it ready for getting data
      pref=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
      editor= pref.edit();
    }


    public static SessionManager getInstance(Context context){

        if (instance == null){
            instance = new SessionManager(context);
        }
        return instance;
    }

    public void setHighScore(String hs){

        editor.putString(HIGH_SCORE_USER,hs);

        editor.commit();
    }

    public String getHighScore(){

        return pref.getString(HIGH_SCORE_USER,"");

    }





}
