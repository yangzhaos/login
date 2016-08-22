package app.feicui.edu.login.yz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.feicui.edu.login.R;
import app.feicui.edu.login.yz.base.BaseActivity;

/**
 * Created by Administrator on 2016/7/19.
 */
public class HomeActivity extends BaseActivity {
    Button safe;
    Button wr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initOnclick();
    }

    @Override
    public void initView() {
        super.initView();
        safe = (Button) findViewById(R.id.safe);
        wr = (Button) findViewById(R.id.wr);
    }

    @Override
    public void initOnclick() {
        super.initOnclick();
        safe.setOnClickListener(this);
        wr.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.safe:
                Intent safe = new Intent(HomeActivity.this, SafaActivity.class);
                startActivity(safe);
                break;
            case R.id.wr:
                Intent wr = new Intent(HomeActivity.this, WeatherActivity.class);
                startActivity(wr);
                break;
        }
    }
}
