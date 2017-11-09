package com.tencent.bugly.hotfix.easy;

import android.util.Log;

/**
 * 测试bug类.
 *
 * @author devilwwj
 * @since 2016/10/25
 */
public class BugClass {

    public String bug() {
        // 这段代码会报空指针异常
        String str = null;
        Log.e("BugClass", "get string length:" + str.length());
        return "This is a bug class";
    }
}
