package com.example.almig.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.almig.android.R;
import com.example.almig.android.model.FootprintTextModel;

import java.util.List;

public class FootprintTextAdapter extends ArrayAdapter<FootprintTextModel> implements OnClickListener {

	private LayoutInflater mInflater;

	public FootprintTextAdapter(Context context, List<FootprintTextModel> items) {
		super(context, 0, items);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item_footprint_text, parent, false);
			holder = new ViewHolder();
			holder.mImage = (ImageView) convertView.findViewById(R.id.iv_footprint_text_image);
			holder.mDate = (TextView) convertView.findViewById(R.id.rtv_footprint_text_date);
			holder.mTitle = (TextView) convertView.findViewById(R.id.rtv_footprint_text_title);
			holder.mContent = (TextView) convertView.findViewById(R.id.rtv_footprint_text_content);
			holder.mEnlargement = (TextView) convertView.findViewById(R.id.rtv_footprint_text_enlargement);
			holder.mModification = (TextView) convertView.findViewById(R.id.rtv_footprint_text_modification);
			holder.mEnlargement.setOnClickListener(this);
			holder.mModification.setOnClickListener(this);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		FootprintTextModel item = getItem(position);
		holder.mImage.setImageResource(item.getImageURL());
		holder.mDate.setText(item.getDate());
		holder.mTitle.setText(item.getTitle());
		holder.mContent.setText(item.getContent());
		holder.mEnlargement.setTag(position);
		holder.mModification.setTag(position);

		return convertView;
	}

	private static class ViewHolder {
		public ImageView mImage;
		public TextView mDate;
		public TextView mTitle;
		public TextView mContent;
		public TextView mEnlargement;
		public TextView mModification;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();
		switch (v.getId()) {
		case R.id.rtv_footprint_text_enlargement:
			// click on explore button
			break;
		case R.id.rtv_footprint_text_modification:
			// click on share button
			break;
		}
	}
}
