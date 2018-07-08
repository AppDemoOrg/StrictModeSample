package com.abt.strictmode;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;

/**
 * @描述： @SampleApp
 * @作者： @黄卫旗
 * @创建时间： @07/07/2018
 */
public class SampleApp extends Application {

    public static final boolean IS_DEBUG = true;
    public static ArrayList<Activity> sLeakyActivities = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate() {
        super.onCreate();

        // 分别为MainThread和VirtualMachine设置StrictMode
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .detectResourceMismatches()
                    .detectCustomSlowCalls()
                    .penaltyDeath()
                    .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .detectLeakedRegistrationObjects()
                    .detectActivityLeaks()
                    .penaltyDeath()
                    .build());
        }

    }
}
