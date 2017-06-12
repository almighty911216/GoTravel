package com.example.almig.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.almig.android.CulturalAssetDescriptionActivity;
import com.example.almig.android.R;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private ArrayList<String> mSubcategories;
	private Context mContext;
	
	public SearchAdapter(Context context, ArrayList<String> subcategories) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mSubcategories = subcategories;
		mContext = context;
	}

	@Override
	public int getCount() {
		return mSubcategories.size();
	}

	@Override
	public Object getItem(int position) {
		return mSubcategories.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_view_item_search, parent, false);
			holder = new ViewHolder();
			holder.icon = convertView.findViewById(R.id.search_icon);
			holder.text = (TextView) convertView.findViewById(R.id.search_text);
			holder.text.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(mContext, CulturalAssetDescriptionActivity.class);
					String name = mSubcategories.get(position);
					intent.putExtra("name", name);
					mContext.startActivity(intent);
				}
			});
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		String subcategory = mSubcategories.get(position);
		if (position == 0) { //We only show icon for the first item
			holder.icon.setVisibility(View.VISIBLE);
		} else {
			holder.icon.setVisibility(View.INVISIBLE);
		}
		holder.text.setText(subcategory);
		
		return convertView;
	}
	
	private static class ViewHolder {
		public View icon;
		public TextView text;
	}
}
