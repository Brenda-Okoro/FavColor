package com.example.brendy.firstapp;

import dagger.Component;

/**
 * Created by brendy on 2/23/18.
 */

@Component(modules = ContextModule.class)
public interface FavApplicationComponent {
    void inject(MainActivity mainActivity);
}
