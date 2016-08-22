package app.feicui.edu.login.yz.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/7/20.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initView() {
    }

    ;

    public void initOnclick() {
    }

    public void initData() {
    }

    @Override
    public void onClick(View view) {
    }

}
