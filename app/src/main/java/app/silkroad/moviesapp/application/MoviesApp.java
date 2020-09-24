package app.silkroad.moviesapp.application;

import android.app.Application;

  public class MoviesApp extends Application {

    private static MoviesApp myApp;


    @Override
    public void onCreate() {
        super.onCreate();

       myApp=this;

    }

    public static MoviesApp getInstance(){

        return myApp;
    }


}
