package com.bugly.upgrade.demo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.crashreport.CrashReport;


/**
 * init方法自动检查更新，checkUpdate方法手动检查更新
 * Created by wenjiewu on 2016/5/23.
 */
public class MainActivity extends AppCompatActivity {

    private Button btnCheckUpdate;
    private Button btnLoadUpgradeInfo;
    private TextView tvUpgradeInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnCheckUpdate = (Button) findViewById(R.id.btnCheckUpdate);
        btnLoadUpgradeInfo = (Button) findViewById(R.id.btnLoadUpdateInfo);
        tvUpgradeInfo = (TextView) findViewById(R.id.tvUpgradeInfo);

        btnCheckUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Beta.checkUpgrade();
            }
        });

        btnLoadUpgradeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadUpgradeInfo();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
//        loadUpgradeInfo();
    }

    private void loadUpgradeInfo() {
        if (tvUpgradeInfo == null)
            return;

        /***** 获取升级信息 *****/
        UpgradeInfo upgradeInfo = Beta.getUpgradeInfo();

        if (upgradeInfo == null) {
            tvUpgradeInfo.setText("无升级信息");
            return;
        }

        StringBuilder info = new StringBuilder();
        info.append("id: ").append(upgradeInfo.id).append("\n");
        info.append("标题: ").append(upgradeInfo.title).append("\n");
        info.append("升级说明: ").append(upgradeInfo.newFeature).append("\n");
        info.append("versionCode: ").append(upgradeInfo.versionCode).append("\n");
        info.append("versionName: ").append(upgradeInfo.versionName).append("\n");
        info.append("发布时间: ").append(upgradeInfo.publishTime).append("\n");
        info.append("安装包Md5: ").append(upgradeInfo.apkMd5).append("\n");
        info.append("安装包下载地址: ").append(upgradeInfo.apkUrl).append("\n");
        info.append("安装包大小: ").append(upgradeInfo.fileSize).append("\n");
        info.append("弹窗间隔（ms）: ").append(upgradeInfo.popInterval).append("\n");
        info.append("弹窗次数: ").append(upgradeInfo.popTimes).append("\n");
        info.append("发布类型（0:测试 1:正式）: ").append(upgradeInfo.publishType).append("\n");
        info.append("弹窗类型（1:建议 2:强制 3:手工）: ").append(upgradeInfo.upgradeType);

        tvUpgradeInfo.setText(info);
    }

    public void testJavaCrash(View view){
        CrashReport.testJavaCrash();
    }

    public void testNativeCrash(View view){
        CrashReport.testNativeCrash();
    }

    public void testANR(View view){
        CrashReport.testANRCrash();
    }
}
