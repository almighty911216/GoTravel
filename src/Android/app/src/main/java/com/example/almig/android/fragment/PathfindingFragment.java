package com.example.almig.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;

import com.example.almig.android.R;


/**
 * Created by almig on 2017-06-10.
 */

public class PathfindingFragment extends Fragment {
    private View mRootView;
    private int flag = 0;

    public static PathfindingFragment newInstance() {
        return new PathfindingFragment();
    }

    private void initBinding(View rootView) {
        mRootView = rootView;
    }

    public PathfindingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_pathfinding, container, false);

        initBinding(rootView);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_marker);
        AbsoluteLayout layout = (AbsoluteLayout) rootView.findViewById(R.id.al_bg);

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300); //You can manage the time of the blink with this parameter
        anim.setStartOffset(100);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(anim);

        layout.setOnClickListener(new View.OnClickListener() {
            AbsoluteLayout.LayoutParams absParams =
                    (AbsoluteLayout.LayoutParams) imageView.getLayoutParams();

            @Override
            public void onClick(View v) {
                switch (++flag) {
                    case 1:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                143, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                109, getResources().getDisplayMetrics());
                        break;
                    case 2:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                206, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                108, getResources().getDisplayMetrics());
                        break;
                    case 3:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                303, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                151, getResources().getDisplayMetrics());
                        break;
                    case 4:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                249, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                186, getResources().getDisplayMetrics());
                        break;
                    case 5:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                191, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                197, getResources().getDisplayMetrics());
                        break;
                    case 6:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                110, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                210, getResources().getDisplayMetrics());
                        break;
                    case 7:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                67, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                281, getResources().getDisplayMetrics());
                        break;
                    case 8:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                124, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                306, getResources().getDisplayMetrics());
                        break;
                    case 9:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                220, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                308, getResources().getDisplayMetrics());
                        break;
                    case 10:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                323, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                352, getResources().getDisplayMetrics());
                        break;
                    case 11:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                270, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                393, getResources().getDisplayMetrics());
                        break;
                    case 12:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                209, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                409, getResources().getDisplayMetrics());
                        break;
                    case 13:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                144, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                418, getResources().getDisplayMetrics());
                        break;
                    case 14:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                60, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                499, getResources().getDisplayMetrics());
                        break;
                    case 15:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                76, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                521, getResources().getDisplayMetrics());
                        break;
                    case 16:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                119, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                540, getResources().getDisplayMetrics());
                        break;
                    case 17:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                225, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                553, getResources().getDisplayMetrics());
                        break;
                    case 18:
                        absParams.x = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                323, getResources().getDisplayMetrics());
                        absParams.y = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                547, getResources().getDisplayMetrics());
                        break;
                }
                imageView.setLayoutParams(absParams);
            }
        });

        return rootView;
    }
}
