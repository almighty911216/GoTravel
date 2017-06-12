package com.example.almig.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.almig.android.R;
import com.example.almig.android.adapter.AreaCategoryAdapter;
import com.example.almig.android.util.DummyContent;


/**
 * Created by almig on 2017-06-09.
 */

public class CulturalAssetsFragment extends Fragment {
    private View mRootView;
    private ListView mLvArea;

    public static CulturalAssetsFragment newInstance() {
        return new CulturalAssetsFragment();
    }

    private void initBinding(View rootView) {
        mRootView = rootView;
        mLvArea = (ListView) mRootView.findViewById(R.id.lv_state);
    }

    private void initAdapter() {
        BaseAdapter adapter = new AreaCategoryAdapter(mRootView.getContext(), DummyContent.getAreaCategorieModels(), false);
        mLvArea.setAdapter(adapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cultural_assets, container, false);

        initBinding(rootView);
        initAdapter();

        return rootView;
    }
}
