package com.example.user.pathofexile;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by user on 6/6/2018.
 */

public class Item {
    public int lvl;



    public Item(){}


    public Item(int lvl){
        this.lvl = lvl;
    }

    public int getLvl(){
        return lvl;
    }

    public void setLvl(int lvl){
        this.lvl = lvl;
    }
}
