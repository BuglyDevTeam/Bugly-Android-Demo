package com.tencent.bugly.hotfix.easy;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
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
        Bugly.init(this, "900029763", false);
}

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        Beta.installTinker();
    }

}
