package app.feicui.edu.login.yz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import app.feicui.edu.login.R;
import app.feicui.edu.login.yz.base.BaseActivity;
import app.feicui.edu.login.yz.server.SqServer;

/**
 * Created by Administrator on 2016/7/26.
 */
public class SafaActivity extends BaseActivity {
    public static String stut = "0";//状态
    ImageView left;
    Button light;
    String user;
    Mhandler mhandler = new Mhandler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            SqServer server = new SqServer();
            user = server.bserver(stut, null, "safe");
            try {
                user = new String(user.getBytes("utf-8"), "utf-8");
                stut = user;
                Message msg = mhandler.obtainMessage(1);
                mhandler.sendMessage(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private View.OnClickListener listent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.light:
                    new Thread(runnable).start();
                    break;
                case R.id.lift:
                    Intent intent = new Intent(SafaActivity.this, HomeActivity.class);
                    startActivity(intent);
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
        initView();
        initOnclick();
//        String title="";
//        initActionBar(title,R.drawable.back,R.drawable.light,listent);
    }

    @Override
    public void initView() {
        super.initView();
        light = (Button) findViewById(R.id.light);
        left = (ImageView) findViewById(R.id.lift);
    }

    @Override
    public void initOnclick() {
        super.initOnclick();
        light.setOnClickListener(listent);
        left.setOnClickListener(listent);
    }

    class Mhandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (stut.equals("0")) {
                        ImageView imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.black);
                    } else {
                        ImageView imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.light);
                    }
                    msg.what = 33;
                    break;

            }
        }
    }
}
