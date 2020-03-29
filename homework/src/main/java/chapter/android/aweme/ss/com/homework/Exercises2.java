package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
        TextView centerTv = findViewById(R.id.tv_center);
        View rootView = findViewById(R.id.root);
        int view_nums = getAllChildViewCount(rootView);
        centerTv.setText(String.valueOf(view_nums));
    }

    public int getAllChildViewCount(View view) {
        int count = 0;
        if (view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View childView = vg.getChildAt(i);
                count += getAllChildViewCount(childView);
            }
        } else {
            count = 1;
        }
        return count;
    }
}
