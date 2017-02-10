package com.tencent.bugly.hotfix;

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
        int length = str.length();
        return "This is a bug class";
    }
}
