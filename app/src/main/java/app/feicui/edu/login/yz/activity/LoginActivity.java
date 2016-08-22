package app.feicui.edu.login.yz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.feicui.edu.login.R;
import app.feicui.edu.login.yz.base.BaseActivity;

public class LoginActivity extends BaseActivity {
    EditText userName;
    EditText passWorld;
    Button login;
    Button register;
    Button forget;
    String user;

    //EvernHandler mhandler = new EvernHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass);
        initView();
        initOnclick();
    }

    @Override
    public void initView() {
        userName = (EditText) findViewById(R.id.edit1);
        passWorld = (EditText) findViewById(R.id.edit2);
        login = (Button) findViewById(R.id.button1);
        register = (Button) findViewById(R.id.button2);
        forget = (Button) findViewById(R.id.button3);
    }

    @Override
    public void initOnclick() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //new Thread(runnable).start();
                Intent intent1 = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
        }
//    }
//    //多线程
//    Runnable runnable=new Runnable() {
//        @Override
//        public void run() {
//            SqServer server=new SqServer();
//            user=server.bserver(userName.getText().toString(),passWorld.getText().toString(),"showall");
//            try {
//                user=new String(user.getBytes("utf-8"),"utf-8");
//
//                Message msg=mhandler.obtainMessage(1);
//                mhandler.sendMessage(msg);
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//
//        }
//    };
//    //主要接受子线程发送的数据， 并用此数据配合主线程更新UI。
//    class EvernHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//             switch (msg.what){
//                 case 1:
//                if (user.equals("登录成功")){
//                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
//                    startActivity(intent);
//                    msg.what=33;
//                }else{
//                    Toast.makeText(LoginActivity.this, "密码或者账户不正确", Toast.LENGTH_SHORT).show();
//                }
//                     break;
//                 default:
//                     break;
//             }
//        }
//    }
    }
}
