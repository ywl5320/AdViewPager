package com.ywl5320.adviewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import adutils.AdViewpagerUtil;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private LinearLayout lydots;
    private TextView tvtxt;
    private String[] urls;
    private AdViewpagerUtil adViewpagerUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        lydots = (LinearLayout) findViewById(R.id.ly_dots);
        tvtxt = (TextView) findViewById(R.id.tv_txt);


        urls = new String[5];
        urls[0] = "http://imgsrc.baidu.com/forum/pic/item/4bed2e738bd4b31c2958c52c87d6277f9f2ff8c5.jpg";
        urls[1] = "http://ww1.sinaimg.cn/mw600/b4ece975tw1e33ep5rqfmj.jpg";
        urls[2] = "http://img2.duitang.com/uploads/item/201204/22/20120422200645_TUrrj.thumb.600_0.jpeg";
        urls[3] = "http://www.laozu.com/d/file/news/baguaquwen/2014-12-25/2e8381506499688a412dff83047c2db2.jpg";
        urls[4] = "http://www.haofanben.com/uploads/allimg/140625/0951046053-0.jpg";

        adViewpagerUtil = new AdViewpagerUtil(this, viewpager, lydots, 8, 4, urls);
        adViewpagerUtil.initVps();
        adViewpagerUtil.setOnAdItemClickListener(new AdViewpagerUtil.OnAdItemClickListener() {
            @Override
            public void onItemClick(View v, int flag) {
                Toast.makeText(MainActivity.this, "flag:" + flag, Toast.LENGTH_SHORT).show();
            }
        });
        adViewpagerUtil.setOnAdPageChangeListener(new AdViewpagerUtil.OnAdPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
                if(arg0 == 0)
                    arg0 = 1;
                if(arg0 == urls.length + 1)
                {
                    arg0 = urls.length;
                }
                tvtxt.setText("第" + arg0 + "张");
            }
        });
    }
}
