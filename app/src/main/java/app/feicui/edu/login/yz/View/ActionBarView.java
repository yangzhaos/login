package app.feicui.edu.login.yz.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.feicui.edu.login.R;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ActionBarView extends LinearLayout {
    private ImageView left;
    private ImageView right;
    private TextView tit;

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.barview, this);
        left = (ImageView) findViewById(R.id.lift);
        right = (ImageView) findViewById(R.id.Right);
        tit = (TextView) findViewById(R.id.title);
    }

    public void initActionBar(String title, int leftResID, int rightResID, OnClickListener listener) {
        tit.setText(title);
        if (leftResID == -1) {
            left.setVisibility(View.INVISIBLE);
        } else {
            left.setImageResource(leftResID);
            left.setOnClickListener(listener);
        }
        if (rightResID == -1) {
            right.setVisibility(View.INVISIBLE);
        } else {
            /*setImageDrawable是最省内存高效的图片加载,*/
            right.setImageResource(rightResID);
            //设置监听
            right.setOnClickListener(listener);
        }
    }
}
