package com.example.almig.android;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almig.android.adapter.DrawerAdapter;
import com.example.almig.android.fragment.CulturalAssetsFragment;
import com.example.almig.android.fragment.FootprintFragment;
import com.example.almig.android.fragment.HomeFragment;
import com.example.almig.android.fragment.PathfindingFragment;
import com.example.almig.android.fragment.SearchFragment;
import com.example.almig.android.model.DrawerItem;
import com.example.almig.android.util.ImageUtil;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import static com.example.almig.android.model.DrawerItem.DRAWER_ITEM_TAG_HOME;

public class MainActivity extends AppCompatActivity {
    private ImageLoader mImageLoader;
    private Toolbar mToolbar;
    private Resources mRes;

    private ListView mDrawerList;
    private List<DrawerItem> mDrawerItems;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private Handler mHandler;
    private boolean mShouldFinish = false;

    private void initBinding() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerList = (ListView) findViewById(R.id.lv_menu_list);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);

        mHandler = new Handler();
        mRes = getResources();
    }

    private void initImageLoader() {
        mImageLoader = ImageLoader.getInstance();
        if (!mImageLoader.isInited()) {
            mImageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }
    }

    private void initNavDrawerItems() {
        mDrawerItems = new ArrayList<>();
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_travel), R.string.activity_title_home, DRAWER_ITEM_TAG_HOME));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_map), R.string.activity_title_pathfinding, DrawerItem.DRAWER_ITEM_TAG_PATHFINDING));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_book), R.string.activity_title_cultural_assets, DrawerItem.DRAWER_ITEM_TAG_CULTURAL_ASSETS));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_search), R.string.activity_title_search, DrawerItem.DRAWER_ITEM_TAG_SEARCH));
        mDrawerItems.add(new DrawerItem(mRes.getDrawable(R.drawable.ic_footprint), R.string.activity_title_footprint, DrawerItem.DRAWER_ITEM_TAG_FOOTPRINT));
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(mRes.getString(R.string.app_name));
    }

    private void initDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                supportInvalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
    }

    private void initAdapter() {
        View headerView = initHeaderView(R.layout.header_nav_drawer, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "almighty911216@gmail.com");
        BaseAdapter adapter = new DrawerAdapter(this, mDrawerItems);
        mDrawerList.addHeaderView(headerView);// Add header before adapter (for// pre-KitKat)
        mDrawerList.setAdapter(adapter);
    }

    private View initHeaderView(int layoutRes, String url, String email) {
        View headerView = getLayoutInflater().inflate(layoutRes, mDrawerList, false);
        ImageView iv = (ImageView) headerView.findViewById(R.id.iv_profile);
        TextView tv = (TextView) headerView.findViewById(R.id.rtv_email);

        ImageUtil.displayRoundImage(iv, url, null);
        tv.setText(email);

        return headerView;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0: // Header를 클릭할 경우
                    return;

                case DRAWER_ITEM_TAG_HOME:
                    setTitle(mRes.getString(R.string.app_name));
                    break;

                default:
                    setTitle(mDrawerItems.get(position - 1).getTitle());
                    break;
            }

            selectItem(position, mDrawerItems.get(position - 1).getTag());
        }
    }

    private void selectItem(int position, int drawerTag) {
        Fragment fragment = getFragmentByDrawerTag(drawerTag);
        commitFragment(fragment);

        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private Fragment getFragmentByDrawerTag(int drawerTag) {
        Fragment fragment;

        switch (drawerTag) {
            case DrawerItem.DRAWER_ITEM_TAG_PATHFINDING:
                fragment = PathfindingFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_CULTURAL_ASSETS:
                fragment = CulturalAssetsFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_SEARCH:
                fragment = SearchFragment.newInstance();
                break;

            case DrawerItem.DRAWER_ITEM_TAG_FOOTPRINT:
                fragment = FootprintFragment.newInstance();
                break;

            default:
                fragment = HomeFragment.newInstance();
        }

        mShouldFinish = false;

        return fragment;
    }

    private class CommitFragmentRunnable implements Runnable {

        private Fragment fragment;

        public CommitFragmentRunnable(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void run() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit();
        }
    }

    public void commitFragment(Fragment fragment) {
        // Using Handler class to avoid lagging while
        // committing fragment in same time as closing
        // navigation drawer
        mHandler.post(new CommitFragmentRunnable(fragment));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBinding();
        initImageLoader();
        initToolbar();
        initDrawerToggle();

        mTitle = mDrawerTitle = getTitle();

        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        initNavDrawerItems();
        initAdapter();
        mDrawerList.setAdapter(new DrawerAdapter(this, mDrawerItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //mDrawerLayout.addDrawerListener(mDrawerToggle);

        selectItem(1, DRAWER_ITEM_TAG_HOME);
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (!mShouldFinish && !mDrawerLayout.isDrawerOpen(mDrawerList)) {
            Toast.makeText(getApplicationContext(), R.string.confirm_exit, Toast.LENGTH_SHORT).show();
            mShouldFinish = true;
            mDrawerLayout.openDrawer(mDrawerList);
        } else if (!mShouldFinish && mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            super.onBackPressed();
        }
    }
}