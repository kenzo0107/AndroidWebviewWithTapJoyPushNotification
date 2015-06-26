package jp.mameko.com.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tapjoy.TJConnectListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyConnectFlag;


public class MainActivity extends Activity {

    // TapJoy sdkKey.
    final private static String tapJoysdkKey   = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
    final private static String tapJoysenderID = "xxxxxxxxxx";

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


        final boolean connect = Tapjoy.connect(getApplicationContext(), tapJoysdkKey, TapjoyConnectFlag.CONNECT_FLAG_DEFAULTS, new TJConnectListener() {
            @Override
            public void onConnectSuccess() {
                Tapjoy.setGcmSender(tapJoysenderID);
            }

            @Override
            public void onConnectFailure() {}
        });
        Tapjoy.setDebugEnabled(true); //Do not set this for apps released to a store!
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

    @Override
    protected void onStart() {
        super.onStart();
        Tapjoy.startSession();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Tapjoy.endSession();
    }
}
