/*
 * Copyright 2016 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.yfl.myapplication.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import cn.yfl.myapplication.R;
import cn.yfl.myapplication.adapter.MenuPagerAdapter;
import cn.yfl.myapplication.fragment.MenuFragment;

/**
 * Created by Yan Zhenjie on 2016/8/12.
 */
public class ViewPagerMenuActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private MenuPagerAdapter mMenuPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btn_one).setOnClickListener(onClickListener);
        findViewById(R.id.btn_two).setOnClickListener(onClickListener);
        findViewById(R.id.btn_three).setOnClickListener(onClickListener);

        mViewPager = (ViewPager) findViewById(R.id.view_pager_menu);
        mViewPager.addOnPageChangeListener(simpleOnPageChangeListener);
        mViewPager.setOffscreenPageLimit(2);

        List<Fragment> fragments = new ArrayList<>(3);
        fragments.add(MenuFragment.newInstance());
        fragments.add(MenuFragment.newInstance());
        fragments.add(MenuFragment.newInstance());

        mMenuPagerAdapter = new MenuPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mMenuPagerAdapter);

        simpleOnPageChangeListener.onPageSelected(0);
    }

    /**
     * Btn点击监听。
     */
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_one) {
                mViewPager.setCurrentItem(0, true);
            } else if (v.getId() == R.id.btn_two) {
                mViewPager.setCurrentItem(1, true);
            } else if (v.getId() == R.id.btn_three) {
                mViewPager.setCurrentItem(2, true);
            }
        }
    };

    private ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            getSupportActionBar().setSubtitle("第" + position + "个");
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
