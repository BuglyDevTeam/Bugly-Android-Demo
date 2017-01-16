package com.tencent.bugly.hotfix.easy;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Demo Application示例.
 *
 * @author wenjiewu
 * @since 2017/1/3
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        long start = System.currentTimeMillis();
        Bugly.init(this, "900029763", false);
        long end = System.currentTimeMillis();
        Log.e("initTime", "spent time---->" + (end - start));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // 安装tinker
        Beta.installTinker();
    }

}
