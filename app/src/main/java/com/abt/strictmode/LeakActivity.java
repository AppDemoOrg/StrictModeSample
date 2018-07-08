package com.abt.strictmode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @描述： @LeakActivity
 * @作者： @黄卫旗
 * @创建时间： @08/07/2018
 */
public class LeakActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SampleApp.sLeakyActivities.add(this);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LeakActivity.class);
        context.startActivity(intent);
    }
}
