package com.example.almig.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.almig.android.R;
import com.example.imagesliding.Animations.DescriptionAnimation;
import com.example.imagesliding.SliderLayout;
import com.example.imagesliding.SliderTypes.BaseSliderView;
import com.example.imagesliding.SliderTypes.TextSliderView;
import com.example.imagesliding.Tricks.ViewPagerEx;

import java.util.HashMap;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private View mRootView;
    private SliderLayout mSlider;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    private void initBinding(View rootView) {
        mRootView = rootView;
        mSlider = (SliderLayout)rootView.findViewById(R.id.slider_adv);
    }

    private void initSlider() {
        /*
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("불국사", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("석굴암", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("임해전지", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("첨성대", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg"); */

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("불국사", R.drawable.adv_bulguksa);
        file_maps.put("석굴암", R.drawable.adv_sukgulam);
        file_maps.put("임해천지", R.drawable.adv_imhaejeonji);
        file_maps.put("첨성대", R.drawable.adv_chumsungdae);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(mRootView.getContext());
            // initialize a SliderLayout
            textSliderView.description(name).image(file_maps.get(name)).setScaleType(BaseSliderView.ScaleType.Fit).setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);

            mSlider.addSlider(textSliderView);
            mSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
            mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mSlider.setCustomAnimation(new DescriptionAnimation());
            mSlider.setDuration(4000);
            mSlider.addOnPageChangeListener(this);
        }
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initBinding(rootView);
        initSlider();

        return rootView;
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
