package com.ozturkersin.instagramcloneparse;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("OVfpUvo8KquDcnRQFBmYfRMVRbj76Hcxd8HXwR65")
        .clientKey("zmD0nUWNGKCQBZPXKNajXVqNhpTDzg6fCWRAjir6")
        .server("https://parseapi.back4app.com/")
        .build()
        );

    }
}
