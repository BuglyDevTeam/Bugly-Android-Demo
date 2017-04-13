package com.bugly.upgrade.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;

/**
 * 自定义Activity.
 */
public class UpgradeActivity extends Activity {
    private TextView tv;
    private TextView title;
    private TextView version;
    private TextView size;
    private TextView time;
    private TextView content;
    private Button cancel;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_upgrade);
        tv = getView(R.id.tv);
        title = getView(R.id.title);
        version = getView(R.id.version);
        size = getView(R.id.size);
        time = getView(R.id.time);
        content = getView(R.id.content);
        cancel = getView(R.id.cancel);
        start = getView(R.id.start);
        updateBtn(Beta.getStrategyTask());
        tv.setText(tv.getText().toString() + Beta.getStrategyTask().getSavedLength() + "");
        title.setText(title.getText().toString() + Beta.getUpgradeInfo().title);
        version.setText(version.getText().toString() + Beta.getUpgradeInfo().versionName);
        size.setText(size.getText().toString() + Beta.getUpgradeInfo().fileSize + "");
        time.setText(time.getText().toString() + Beta.getUpgradeInfo().publishTime + "");
        content.setText(Beta.getUpgradeInfo().newFeature);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask task = Beta.startDownload();
                updateBtn(task);
                if (task.getStatus() == DownloadTask.DOWNLOADING) {
                    finish();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Beta.cancelDownload();
                finish();
            }
        });
        Beta.registerDownloadListener(new DownloadListener() {
            @Override
            public void onReceive(DownloadTask task) {
                updateBtn(task);
                tv.setText(task.getSavedLength() + "");
            }

            @Override
            public void onCompleted(DownloadTask task) {
                updateBtn(task);
                tv.setText(task.getSavedLength() + "");
            }

            @Override
            public void onFailed(DownloadTask task, int code, String extMsg) {
                updateBtn(task);
                tv.setText("failed");

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Beta.unregisterDownloadListener();
    }


    public void updateBtn(DownloadTask task) {
        switch (task.getStatus()) {
            case DownloadTask.INIT:
            case DownloadTask.DELETED:
            case DownloadTask.FAILED: {
                start.setText("开始下载");
            }
                break;
            case DownloadTask.COMPLETE: {
                start.setText("安装");
            }
                break;
            case DownloadTask.DOWNLOADING: {
                start.setText("暂停");
            }
                break;
            case DownloadTask.PAUSED: {
                start.setText("继续下载");
            }
                break;
            default:
                break;
        }
    }

    public <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }
}
