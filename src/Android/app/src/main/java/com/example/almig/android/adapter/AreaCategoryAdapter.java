package com.example.almig.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.example.almig.android.R;
import com.example.almig.android.SubCulturalAssetsActivity;
import com.example.almig.android.model.AreaCategoryModel;

import java.util.ArrayList;

public class AreaCategoryAdapter extends BaseAdapter implements OnClickListener {
	 
    private static final int TYPE_ONE_COLUMN = 0;
    private static final int TYPE_TWO_COLUMNS = 1;
    private static final int TYPE_MAX_COUNT = TYPE_TWO_COLUMNS + 1;
	
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<AreaCategoryModel> mAreaCategoryModels;
	private boolean mIsLayoutOnTop;
	
	public AreaCategoryAdapter(Context context, ArrayList<AreaCategoryModel> areaCategoryModels, boolean isLayoutOnTop) {
		mContext = context;
		mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mAreaCategoryModels = areaCategoryModels;
		mIsLayoutOnTop = isLayoutOnTop;
	}
	
    @Override
    public int getItemViewType(int position) {
    	if ((position == mAreaCategoryModels.size() / 2)
    			&& (mAreaCategoryModels.size() % 2 == 1)) {
    		return TYPE_ONE_COLUMN;
    	} else {
    		return TYPE_TWO_COLUMNS;
    	}
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

	@Override
	public int getCount() {
		return (mAreaCategoryModels.size() / 2) + (mAreaCategoryModels.size() % 2);
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder.OneColumnViewHolder oneColumnViewHolder;
		final ViewHolder.TwoColumnsViewHolder twoColumnsViewHolder;
		int type = getItemViewType(position);
		if (type == TYPE_ONE_COLUMN) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item_categories_one_column, parent, false);
				oneColumnViewHolder = new ViewHolder.OneColumnViewHolder();
				oneColumnViewHolder.mImage = (ImageView) convertView.findViewById(R.id.list_item_image_1);
				oneColumnViewHolder.mComplete = (TextView) convertView.findViewById(R.id.list_item_favourite_1);
				oneColumnViewHolder.mTitle = (TextView) convertView.findViewById(R.id.list_item_title_1);
				oneColumnViewHolder.mNumberOfCulturalAsset = (TextView) convertView.findViewById(R.id.list_item_number_of_images_1);
				oneColumnViewHolder.mLayoutTopBottom = (ViewGroup) convertView.findViewById(R.id.layout_top_bottom_1);
				oneColumnViewHolder.mImage.setOnClickListener(this);
				convertView.setTag(oneColumnViewHolder);
			} else {
				oneColumnViewHolder = (ViewHolder.OneColumnViewHolder) convertView.getTag();
			}
			AreaCategoryModel model = mAreaCategoryModels.get(position * 2);
			Resources res = mContext.getResources();

			oneColumnViewHolder.mTitle.setText(model.getTitleId());
			oneColumnViewHolder.mNumberOfCulturalAsset.setText(res.getString(R.string.number_of_cultural_asset, model.getSubcategories().size()));
			oneColumnViewHolder.mImage.setImageResource(model.getLogoId());

			if (model.isComplete()) {
				oneColumnViewHolder.mComplete.setText(R.string.fontello_star_empty);
			} else {
				oneColumnViewHolder.mComplete.setText(R.string.fontello_star_full);
			}
			oneColumnViewHolder.mImage.setTag(position * 2);
			oneColumnViewHolder.mComplete.setTag(position * 2);
			LayoutParams lp1 = (LayoutParams) oneColumnViewHolder.mLayoutTopBottom.getLayoutParams();
			if (!mIsLayoutOnTop) {
				lp1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
			} else {
				lp1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
			}
		} else if (type == TYPE_TWO_COLUMNS) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item_categories_two_columns, parent, false);
				twoColumnsViewHolder = new ViewHolder.TwoColumnsViewHolder();
				twoColumnsViewHolder.mLhsImage = (ImageView) convertView.findViewById(R.id.iv_lhs_item_image);
				twoColumnsViewHolder.mLhsComplete = (TextView) convertView.findViewById(R.id.mditv_lhs_item_complete);
				twoColumnsViewHolder.mLhsTitle = (TextView) convertView.findViewById(R.id.tv_lhs_item_title);
				twoColumnsViewHolder.mLhsNumberOfCulturalAsset = (TextView) convertView.findViewById(R.id.tv_lhs_item_number_of_cultural_asset);
				twoColumnsViewHolder.mLhsLayoutTopBottom = (ViewGroup) convertView.findViewById(R.id.ll_lhs_top_bottom);
				twoColumnsViewHolder.mRhsImage = (ImageView) convertView.findViewById(R.id.iv_rhs_item_image);
				twoColumnsViewHolder.mRhsComplete = (TextView) convertView.findViewById(R.id.mditv_rhs_item_complete);
				twoColumnsViewHolder.mRhsTitle = (TextView) convertView.findViewById(R.id.tv_rhs_item_title);
				twoColumnsViewHolder.mRhsNumberOfCulturalAsset = (TextView) convertView.findViewById(R.id.tv_rhs_item_number_of_cultural_asset);
				twoColumnsViewHolder.mRhsLayoutTopBottom = (ViewGroup) convertView.findViewById(R.id.ll_rhs_top_bottom);
				twoColumnsViewHolder.mLhsImage.setOnClickListener(this);
				twoColumnsViewHolder.mRhsImage.setOnClickListener(this);

				convertView.setTag(twoColumnsViewHolder);
			} else {
				twoColumnsViewHolder = (ViewHolder.TwoColumnsViewHolder) convertView.getTag();
			}

			AreaCategoryModel lhsModel = mAreaCategoryModels.get(position * 2);
			twoColumnsViewHolder.mLhsTitle.setText(lhsModel.getTitleId());
			twoColumnsViewHolder.mLhsNumberOfCulturalAsset.setText(mContext.getString(R.string.number_of_cultural_asset, lhsModel.getSubcategories().size()));
			twoColumnsViewHolder.mLhsImage.setImageResource(lhsModel.getLogoId());
			if (lhsModel.isComplete()) {
				twoColumnsViewHolder.mLhsComplete.setText(R.string.fontello_star_full);
			} else {
				twoColumnsViewHolder.mLhsComplete.setText(R.string.fontello_star_empty);
			}

			AreaCategoryModel rhsModel = mAreaCategoryModels.get(position * 2 + 1);

			twoColumnsViewHolder.mRhsTitle.setText(rhsModel.getTitleId());
			twoColumnsViewHolder.mRhsNumberOfCulturalAsset.setText(mContext.getString(R.string.number_of_cultural_asset, rhsModel.getSubcategories().size()));
			twoColumnsViewHolder.mRhsImage.setImageResource(rhsModel.getLogoId());
			if (rhsModel.isComplete()) {
				twoColumnsViewHolder.mRhsComplete.setText(R.string.fontello_star_full);
			} else {
				twoColumnsViewHolder.mRhsComplete.setText(R.string.fontello_star_empty);
			}
			twoColumnsViewHolder.mLhsImage.setTag(position * 2);
			twoColumnsViewHolder.mRhsImage.setTag(position * 2 + 1);
			twoColumnsViewHolder.mLhsComplete.setTag(position * 2);
			twoColumnsViewHolder.mRhsComplete.setTag(position * 2 + 1);
			LayoutParams lp1 = (LayoutParams) twoColumnsViewHolder.mLhsLayoutTopBottom.getLayoutParams();
			LayoutParams lp2 = (LayoutParams) twoColumnsViewHolder.mRhsLayoutTopBottom.getLayoutParams();
			if (!mIsLayoutOnTop) {
				lp1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
				lp2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
			} else {
				lp1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
				lp2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0);
			}
		}
		return convertView;
	}
	
	private static class ViewHolder {
		
		public static class OneColumnViewHolder {
			public ImageView mImage;
			public /*Fontello*/TextView mComplete;
			public TextView mTitle;
			public TextView mNumberOfCulturalAsset;
			public ViewGroup mLayoutTopBottom;
		}
		
		private static class TwoColumnsViewHolder {
			public ImageView mLhsImage;
			public /*Fontello*/TextView mLhsComplete;
			public TextView mLhsTitle;
			public TextView mLhsNumberOfCulturalAsset;
			public ViewGroup mLhsLayoutTopBottom;

			public ImageView mRhsImage;
			public /*Fontello*/TextView mRhsComplete;
			public TextView mRhsTitle;
			public TextView mRhsNumberOfCulturalAsset;
			public ViewGroup mRhsLayoutTopBottom;
		}
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		int position = (int) v.getTag();
		if (id == R.id.iv_lhs_item_image || id == R.id.iv_rhs_item_image) {
			Intent intent = new Intent(mContext, SubCulturalAssetsActivity.class);
			intent.putParcelableArrayListExtra(SubCulturalAssetsActivity.MY_SUB_COLLECT, mAreaCategoryModels.get(position).getSubcategories());
			intent.putExtra(SubCulturalAssetsActivity.MY_SUB_COLLECT_LAYOUT_ON_TOP, mIsLayoutOnTop);
			mContext.startActivity(intent);
		}
	}
}
