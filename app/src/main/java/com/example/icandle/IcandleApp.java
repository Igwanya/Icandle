package com.example.icandle;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public class IcandleApp  extends Application {
    @Override public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        } else {
            Timber.plant(new CrashReportingTree());
        }
    }

    /** A tree which logs important information for crash reporting. */
    private static class CrashReportingTree extends Timber.Tree {
        @Override protected void log(int priority, String tag, @NonNull String message, Throwable t) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }

            IcandleCrashLibrary.log(priority, tag, message);

            if (t != null) {
                if (priority == Log.ERROR) {
                    IcandleCrashLibrary.logError(t);
                } else if (priority == Log.WARN) {
                    IcandleCrashLibrary.logWarning(t);
                }
            }
        }
    }
}
