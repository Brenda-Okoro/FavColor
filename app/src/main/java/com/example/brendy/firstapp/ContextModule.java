package com.example.brendy.firstapp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by brendy on 2/23/18.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    public Context context() {
        return context;
    }
}
