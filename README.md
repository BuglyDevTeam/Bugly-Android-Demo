# Google Play的政策变更通知
由于Google Play政策限制，请不要使用bugly带升级功能的sdk，否则可能被GooglePlay检测到违规而导致警告、下架甚至封禁账号等后果。

# 设备id隐私信息问题说明
最新版本sdk已经删除了很多不必要的信息采集，请先将您使用的bugly sdk更新到官网发布的最新版本。Bugly sdk默认使用Android id用于判断Crash设备做统计。如果遇到有关隐私协议审核不允许采集Android id的场景，可以在初始化bugly sdk的时候自定义一个device id，这样本次初始化bugly sdk就不会再采集 Android id了。具体api参考https://bugly.qq.com/docs/user-guide/advance-features-android/?v=20200622202242#userstrategy
```java
UserStrategy strategy = new UserStrategy(appContext);
strategy.setDeviceID("userdefinedId")
```
bugly 隐私协议文档下载地址 ：https://static.bugly.qq.com/bugly-sdk-privacy-statement.pdf

# Bugly-Android-Demo

1.crash、ANR、error（捕获的异常）堆栈上报 [BuglySDKDemo](https://github.com/BuglyDevTeam/Bugly-Android-Demo/tree/master/BuglySDKDemo)

2.App全量升级 [BuglyUpgradeDemo](https://github.com/BuglyDevTeam/Bugly-Android-Demo/tree/master/BuglyUpgradeDemo)

[应用升级常见问题请参考](https://github.com/BuglyDevTeam/Bugly-Android-Demo/wiki#app升级问题汇总)

3.App热更新,DEMO包括两种接入方式，接入之前请先阅读一遍[接入说明文档](https://github.com/BuglyDevTeam/Bugly-Android-Demo/wiki/%E7%83%AD%E6%9B%B4%E6%96%B0SDK%E6%8E%A5%E5%85%A5%E8%AF%B4%E6%98%8E)

热更新使用示例，推荐的接入方式： [BuglyHotfixDemo](https://github.com/BuglyDevTeam/Bugly-Android-Demo/tree/master/BuglyHotfixDemo)

热更新一键接入示例，后续将不再更新 [BuglyHotfixEasyDemo](https://github.com/BuglyDevTeam/Bugly-Android-Demo/tree/master/BuglyHotfixEasyDemo)

[热更新常见问题请参考](https://github.com/BuglyDevTeam/Bugly-Android-Demo/wiki#%E7%83%AD%E6%9B%B4%E6%96%B0%E9%97%AE%E9%A2%98%E6%B1%87%E6%80%BB)

[SDK使用指南](https://bugly.qq.com/docs/)

[SDK接入常见问题](https://github.com/BuglyDevTeam/Bugly-Android-Demo/wiki)
