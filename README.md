# AdViewPager
###ViewPager左右无限轮播实现，可用作Binner导航或广告<br/>
####1张图片
![image](https://github.com/wanliyang1990/AdViewPager/blob/master/imgs/ad1.gif)<br/>
####2张图片
![image](https://github.com/wanliyang1990/AdViewPager/blob/master/imgs/ad2.gif)<br/>
####3张图片
![image](https://github.com/wanliyang1990/AdViewPager/blob/master/imgs/ad3.gif)<br/>
####4张图片
![image](https://github.com/wanliyang1990/AdViewPager/blob/master/imgs/ad4.gif)<br/>

在代码中只需添加几句就可以实现轮播功能<br/>

        //不带导航原点
        adViewpagerUtil = new AdViewpagerUtil(this, viewpager, urls);
        adViewpagerUtil.initVps();

        //带导航原点
        adViewpagerUtil = new AdViewpagerUtil(this, viewpager, lydots, 8, 4, urls);
        adViewpagerUtil.initVps();

添加点击和切换回调如下：<br/>

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
    
create by ywl5320