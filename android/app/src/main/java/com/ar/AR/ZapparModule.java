package com.ar.AR;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zappar.ZapparEmbed;

import java.util.Objects;

public class ZapparModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;

    public ZapparModule(@NonNull ReactApplicationContext context) {
        super(reactContext);
        reactContext = context;
    }

    @NonNull
    @Override
    public String getName() {
        return "ZapparModule";
    }

    @ReactMethod
    public void openAR(){
        Activity currentActivity = reactContext.getCurrentActivity();
        assert currentActivity != null;
        boolean isCompatible = ZapparEmbed.isCompatible(reactContext);
        if (isCompatible) {
            Intent intent = new Intent(currentActivity, ZapparEmbed.getZapcodeClassForIntent());
            currentActivity.startActivity(intent);
        }
    }
}
