package com.tencent.bugly.hotfix;

import android.util.Log;

import com.tencent.bugly.beta.Beta;

//import com.tencent.bugly.beta.Beta;

public class NativeCrashJni {
    static NativeCrashJni nativeCrashJni;

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native void createNativeCrash();

    public static NativeCrashJni getInstance(){
        if (nativeCrashJni==null){
            nativeCrashJni = new NativeCrashJni();
            Log.d("TEST","nativeCrashJni null");
        }
        Log.d("TEST","nativeCrashJni has been initialed");
        return nativeCrashJni;
    }
}
