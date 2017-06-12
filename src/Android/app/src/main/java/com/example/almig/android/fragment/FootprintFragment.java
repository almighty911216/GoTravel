package com.example.almig.android.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.almig.android.R;
import com.example.almig.android.WriteFootprintTextActivity;
import com.example.almig.android.adapter.FootprintTextAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissAdapter;

import static com.example.almig.android.util.DummyFootprintContent.getFootprintTextModelList;

/**
 * Created by almig on 2017-06-11.
 */

public class FootprintFragment extends Fragment implements OnDismissCallback {
    private static final int INITIAL_DELAY_MILLIS = 300;

    private View mRootView;
    private FootprintTextAdapter mFootprintTextAdapter;
    private ListView mLvTrace;
    private com.example.fabanimation.FloatingActionButton mFabAdd;

    public static FootprintFragment newInstance() {
        return new FootprintFragment();
    }

    private void initBinding(View rootView) {
        mRootView = rootView;
        mLvTrace = (ListView)mRootView.findViewById(R.id.lv_footprint_text);
        mFabAdd = (com.example.fabanimation.FloatingActionButton)mRootView.findViewById(R.id.fab_add_mytrace);

        mFabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mRootView.getContext(), WriteFootprintTextActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initAdapter() {
        mFootprintTextAdapter = new FootprintTextAdapter(mRootView.getContext(), getFootprintTextModelList());
        SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(
                new SwipeDismissAdapter(mFootprintTextAdapter, this));
        swingBottomInAnimationAdapter.setAbsListView(mLvTrace);

        assert swingBottomInAnimationAdapter.getViewAnimator() != null;
        swingBottomInAnimationAdapter.getViewAnimator().setInitialDelayMillis(
                INITIAL_DELAY_MILLIS);

        mLvTrace.setClipToPadding(false);
        mLvTrace.setDivider(null);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                8, r.getDisplayMetrics());
        mLvTrace.setDividerHeight(px);
        mLvTrace.setFadingEdgeLength(0);
        mLvTrace.setFitsSystemWindows(true);
        px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12,
                r.getDisplayMetrics());
        mLvTrace.setPadding(px, px, px, px);
        mLvTrace.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);
        mLvTrace.setAdapter(swingBottomInAnimationAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_footprint, container, false);

        initBinding(rootView);
        initAdapter();

        return rootView;
    }

    @Override
    public void onDismiss(@NonNull final ViewGroup listView, @NonNull final int[] reverseSortedPositions) {
        for (int position : reverseSortedPositions) {
            mFootprintTextAdapter.remove(mFootprintTextAdapter.getItem(position));
        }
    }
}
