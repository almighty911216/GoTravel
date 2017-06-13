package com.example.almig.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.almig.android.R;
import com.example.almig.android.util.DialogImageQuiz;

/**
 * Created by almig on 2017-06-13.
 */

public class StampAuthFragment extends Fragment {
    private View mRootView;
    private ImageView ivPicture;

    public static StampAuthFragment newInstance() {
        return new StampAuthFragment();
    }

    private void initBinding(View rootView) {
        mRootView = rootView;
        ivPicture = (ImageView)mRootView.findViewById(R.id.iv_auth_picture);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stamp_auth, container, false);

        initBinding(rootView);

        DialogImageQuiz dialog = new DialogImageQuiz(mRootView.getContext());
        dialog.showDialog();

        return rootView;
    }
}
