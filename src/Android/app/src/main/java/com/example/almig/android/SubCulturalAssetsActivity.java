package com.example.almig.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.almig.android.adapter.CulturalAssetCategoryAdapter;
import com.example.almig.android.model.CulturalAssetCategoryModel;

import java.util.ArrayList;

public class SubCulturalAssetsActivity extends AppCompatActivity {
    public static final String MY_SUB_COLLECT = "com.example.android.almig.MySubCollectActivity";
    public static final String MY_SUB_COLLECT_LAYOUT_ON_TOP = "com.example.android.almig.MySubCollectActivity.layoutOnTop";

    private ArrayList<CulturalAssetCategoryModel> mSubcategories;

    private ListView mLvCollect;
    private boolean mIsLayoutOnTop;

    private void initBinding() {
        mLvCollect = (ListView)findViewById(R.id.lv_cultural_assets);
    }

    private void initAdapter() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(MY_SUB_COLLECT)) {
                mSubcategories = extras.getParcelableArrayList(MY_SUB_COLLECT);
            } else {
                mSubcategories = new ArrayList<>();
            }
            if (extras.containsKey(MY_SUB_COLLECT_LAYOUT_ON_TOP)) {
                mIsLayoutOnTop = extras.getBoolean(MY_SUB_COLLECT_LAYOUT_ON_TOP, false);
            }
        }

        BaseAdapter adapter = new CulturalAssetCategoryAdapter(this, mSubcategories, mIsLayoutOnTop);
        mLvCollect.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_cultural_assets);

        initBinding();
        initAdapter();
    }
}