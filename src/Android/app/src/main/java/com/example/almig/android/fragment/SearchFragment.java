package com.example.almig.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.almig.android.R;
import com.example.almig.android.adapter.SearchAdapter;
import com.example.almig.android.model.DummyModel;
import com.example.almig.android.util.DummyContent;

import java.util.ArrayList;

/**
 * Created by almig on 2017-06-11.
 */

public class SearchFragment extends Fragment {
    private View mRootView;

    private EditText mSearchField;
    private TextView mXMark;
    private View mMicrofon;
    private ListView mListView;
    private ArrayList<DummyModel> searchableArrayList;


    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    private void initBinding(View rootView) {
        mRootView = rootView;

        mSearchField = (EditText) mRootView.findViewById(R.id.search_field);
        mXMark = (TextView) mRootView.findViewById(R.id.search_x);
        mMicrofon = mRootView.findViewById(R.id.search_microfon);
        mListView = (ListView) mRootView.findViewById(R.id.lv_search_item);
    }

    private void initSearch() {
        searchableArrayList = DummyContent.getSeachModelList();

        mXMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mMicrofon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mSearchField.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("DefaultLocale")
            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = editable.toString().trim();
                ArrayList<String> searchedArray = new ArrayList<>();
                for (DummyModel dm : searchableArrayList) {
                    if (dm.getText().toLowerCase().contains(searchText.toLowerCase())) {
                        searchedArray.add(dm.getText());
                    }
                }
                if (searchText.isEmpty()) {
                    mListView.setAdapter(null);
                    mXMark.setText(R.string.fontello_x_mark);
                } else {
                    mListView.setAdapter(new SearchAdapter(mRootView.getContext(), searchedArray));
                    mXMark.setText(R.string.fontello_x_mark_masked);
                }
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        initBinding(rootView);
        initSearch();

        return rootView;
    }
}
