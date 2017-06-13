package com.example.almig.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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

        imageView.setOnTouchListener(new View.OnTouchListener() {
            float oldXvalue;
            float oldYvalue;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int width = ((ViewGroup) v.getParent()).getWidth() - v.getWidth();
                int height = ((ViewGroup) v.getParent()).getHeight() - v.getHeight();

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    oldXvalue = event.getX();
                    oldYvalue = event.getY();
                    //  Log.i("Tag1", "Action Down X" + event.getX() + "," + event.getY());
                    Log.i("Tag1", "Action Down rX " + event.getRawX() + "," + event.getRawY());
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    v.setX(event.getRawX() - oldXvalue);
                    v.setY(event.getRawY() - (oldYvalue + v.getHeight()));
                    //  Log.i("Tag2", "Action Down " + me.getRawX() + "," + me.getRawY());
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    if (v.getX() > width && v.getY() > height) {
                        v.setX(width);
                        v.setY(height);
                    } else if (v.getX() < 0 && v.getY() > height) {
                        v.setX(0);
                        v.setY(height);
                    } else if (v.getX() > width && v.getY() < 0) {
                        v.setX(width);
                        v.setY(0);
                    } else if (v.getX() < 0 && v.getY() < 0) {
                        v.setX(0);
                        v.setY(0);
                    } else if (v.getX() < 0 || v.getX() > width) {
                        if (v.getX() < 0) {
                            v.setX(0);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        } else {
                            v.setX(width);
                            v.setY(event.getRawY() - oldYvalue - v.getHeight());
                        }
                    } else if (v.getY() < 0 || v.getY() > height) {
                        if (v.getY() < 0) {
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(0);
                        } else {
                            v.setX(event.getRawX() - oldXvalue);
                            v.setY(height);
                        }
                    }
                }
                return true;
            }
        });

        return rootView;
    }
}
