package com.jinhong.jhtv.content;

import com.activeandroid.Configuration;
import com.activeandroid.content.ContentProvider;

/**
 * @author :  Jim
 * @date :  2019-08-07
 * @description :
 */
public class DatabaseContentProvider extends ContentProvider {
    @Override
    protected Configuration getConfiguration() {
        Configuration.Builder builder = new Configuration.Builder(getContext());
        return builder.create();
    }
}
