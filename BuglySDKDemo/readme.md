## 项目结构：

```BuglySDKDemo
	- build.gradle（project gradle配置）
        - gradle.properties(配置android.useDeprecatedNdk=true)
	- app(Android工程）
          - src（源代码目录）
			- MainActivity.java（crash测试例子）
            - MyApplication.java（crash-SDK初始化）
            - AndroidManifest.xml （配置网络权限，SDK必须的配置）
		  - build.gradle（app gradle 配置了crashreport & ndk 库）
```		  

注：本demo采用AS Gradle方式快速配置，更多详细的配置，请参考官方文档http://bugly.qq.com/androidfast

常见问题：
1. 导入项目可能会提醒你的sdk没有对应的buildTools，可以将build.gradle的buildToolsVersion改为你本地的版本
如： buildToolsVersion "22.0.1"
2. 运行项目可能会因为没有配置cup架构导致无法安装，可以在build.gradle中配置ndk支持的架构
如：

 ``` 
 ndk {
            //设置支持的SO库架构
            abiFilters 'armeabi', 'x86'//, 'armeabi-v7a', 'x86_64', 'arm64-v8a'
        }
        
  ```
  
3. 可能依赖了较新的库，可以修改成你本地的版本
如：compile 'com.android.support:appcompat-v7:23.1.0'

4. 可能引用了较新的gradle版本，可以修改成低版本
如：

```
dependencies {
        classpath 'com.android.tools.build:gradle:1.5.0'
    }
```
