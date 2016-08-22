package app.feicui.edu.login.yz.activity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import app.feicui.edu.login.R;
import app.feicui.edu.login.yz.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/27.
 */
public class WeatherActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        WebView wv = (WebView) findViewById(R.id.webView);
        //申明我是客户端
        wv.setWebChromeClient(new WebChromeClient());
        //开启javaScript
        wv.getSettings().setJavaScriptEnabled(true);
        String url = "http://weather.sina.cn/?vt=4";
        wv.loadUrl(url);
    }
}
