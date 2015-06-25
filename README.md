# Android Webview

Create New Project by Android Studio, and the bellow code are modified.

* app/manifests/AndroidManifest.xml
* app/res/layout//activity_main.xml
* app/java/<package_name>/MainActivity.java


In this repository , the <package_name> is the `jp.mameko.com.webview`.

---

## Set Up

* app/manifests/AndroidManifest.xml

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="jp.mameko.com.webview" >

    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@android:style/Theme.Light.NoTitleBar">
        <activity
            android:name=".MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

```

* app/res/layout//activity_main.xml

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:paddingLeft="0px"
android:paddingRight="0px"
android:paddingTop="0px"
android:paddingBottom="0px"
tools:context="jp.mameko.com.webview.app.MainActivity">

<WebView
    android:id="@+id/webView1"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />

</RelativeLayout>
```

* app/java/jp.mameko.com.webview/MainActivity.java

```
package jp.mameko.com.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView  myWebView = (WebView)findViewById(R.id.webView1);
        // 標準ブラウザをキャンセル
        myWebView.setWebViewClient(new WebViewClient());
        // JavaScrip有効化
        myWebView.getSettings().setJavaScriptEnabled(true);
        // アプリ起動時に読み込むURL
        myWebView.loadUrl("http://www10471uo.sakura.ne.jp/mameko/webroot/webview/");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
```

* Where to set the URL is the following.

```
myWebView.loadUrl("http://www10471uo.sakura.ne.jp/mameko/webroot/webview/");
```


## Build Run Application

![Webview](http://i.imgur.com/aycPSnY.png)


That's all !

