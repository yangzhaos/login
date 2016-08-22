package app.feicui.edu.login.yz.activity;

/**
 * Created by Administrator on 2016/7/25.
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import app.feicui.edu.login.R;
import app.feicui.edu.login.yz.base.BaseActivity;
import app.feicui.edu.login.yz.server.SqServer;

public class RegisterActivity extends BaseActivity {
    EditText userName;
    EditText passWorld;
    Button register;
    Button ret;
    //Button forget;
    String user;
    EvernHandler mhandler = new EvernHandler();
    //多线程
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            SqServer server = new SqServer();
            user = server.bserver(userName.getText().toString(), passWorld.getText().toString(), "insert");
            if (userName.getText().toString().equals("") || passWorld.getText().toString().equals("")) {
                Message msg = mhandler.obtainMessage(2);
                mhandler.sendMessage(msg);
            } else {
                try {
                    user = new String(user.getBytes("utf-8"), "utf-8");
                    Message msg = mhandler.obtainMessage(1);
                    mhandler.sendMessage(msg);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initOnclick();
    }

    @Override
    public void initView() {
        userName = (EditText) findViewById(R.id.redt1);
        passWorld = (EditText) findViewById(R.id.redt2);
        register = (Button) findViewById(R.id.rbtn1);
        ret = (Button) findViewById(R.id.rbtn2);
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new Thread(runnable).start();
//            }
//        });

        //forget= (Button) findViewById(R.id.button3);
    }

    @Override
    public void initOnclick() {
        register.setOnClickListener(this);
        ret.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbtn1:
                new Thread(runnable).start();
                break;
            case R.id.rbtn2:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
        }
    }

    //主要接受子线程发送的数据， 并用此数据配合主线程更新UI。
    class EvernHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (user.equals("注册成功")) {
                        Toast.makeText(RegisterActivity.this, "注册成功请返回登录", Toast.LENGTH_SHORT).show();
                       /* Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(intent);*/
                        msg.what = 33;
                    } else {
                        Toast.makeText(RegisterActivity.this, "注册失败,用户名已存在", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 2:
                    Toast.makeText(RegisterActivity.this, "注册失败，用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
                    msg.what = 3;
                default:
                    break;
            }
        }
    }
}
