package com.example.almig.android.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.example.almig.android.R;
import com.example.almig.android.model.CulturalAssetCategoryModel;

import java.util.ArrayList;

public class CulturalAssetCategoryAdapter extends BaseAdapter implements View.OnClickListener {

    private static final int TYPE_ONE_COLUMN = 0;
    private static final int TYPE_TWO_COLUMNS = 1;
    private static final int TYPE_MAX_COUNT = TYPE_TWO_COLUMNS + 1;

	private LayoutInflater mInflater;
	private ArrayList<CulturalAssetCategoryModel> mCulturalAssetCategoryModels;
	private final boolean mIsLayoutOnTop;
	private Context mContext;

	public CulturalAssetCategoryAdapter(Context context, ArrayList<CulturalAssetCategoryModel> culturalAssetCategoryModels, boolean isLayoutOnTop) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mCulturalAssetCategoryModels = culturalAssetCategoryModels;
		mIsLayoutOnTop = isLayoutOnTop;
		mContext = context;
	}
	
    @Override
    public int getItemViewType(int position) {
    	if ((position == mCulturalAssetCategoryModels.size() / 2)
    			&& (mCulturalAssetCategoryModels.size() % 2 == 1)) {
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
		return (mCulturalAssetCategoryModels.size() / 2) + (mCulturalAssetCategoryModels.size() % 2);
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
			CulturalAssetCategoryModel model = mCulturalAssetCategoryModels.get(position * 2);
			Resources res = mContext.getResources();

			oneColumnViewHolder.mTitle.setText(model.getTitleId());
			oneColumnViewHolder.mNumberOfCulturalAsset.setVisibility(View.GONE);
			oneColumnViewHolder.mImage.setImageResource(model.getLogoId());

			if (model.isVisit()) {
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

			CulturalAssetCategoryModel lhsModel = mCulturalAssetCategoryModels.get(position * 2);
			twoColumnsViewHolder.mLhsTitle.setText(lhsModel.getTitleId());
			twoColumnsViewHolder.mLhsImage.setImageResource(lhsModel.getLogoId());
			if (lhsModel.isVisit()) {
				twoColumnsViewHolder.mLhsComplete.setText(R.string.fontello_star_full);
			} else {
				twoColumnsViewHolder.mLhsComplete.setText(R.string.fontello_star_empty);
			}

			CulturalAssetCategoryModel rhsModel = mCulturalAssetCategoryModels.get(position * 2 + 1);

			twoColumnsViewHolder.mRhsTitle.setText(rhsModel.getTitleId());
			twoColumnsViewHolder.mRhsImage.setImageResource(rhsModel.getLogoId());
			if (rhsModel.isVisit()) {
				twoColumnsViewHolder.mRhsComplete.setText(R.string.fontello_star_full);
			} else {
				twoColumnsViewHolder.mRhsComplete.setText(R.string.fontello_star_empty);
			}
			twoColumnsViewHolder.mLhsImage.setTag(position * 2);
			twoColumnsViewHolder.mRhsImage.setTag(position * 2 + 1);
			twoColumnsViewHolder.mLhsComplete.setTag(position * 2);
			twoColumnsViewHolder.mRhsComplete.setTag(position * 2 + 1);
			
			//twoColumnsViewHolder.favoriteImage1.setVisibility(View.GONE);
			twoColumnsViewHolder.mLhsNumberOfCulturalAsset.setVisibility(View.GONE);
			//twoColumnsViewHolder.favoriteImage2.setVisibility(View.GONE);
			twoColumnsViewHolder.mRhsNumberOfCulturalAsset.setVisibility(View.GONE);
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
	
	/* We are not using favourite image here. If you really want to use it,
	 * remove commented lines related to favourite image. 
	 */
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
/*			Intent intent = new Intent(mContext, MySubCollectActivity.class);
			intent.putParcelableArrayListExtra(MySubCollectActivity.MY_SUB_COLLECT, mImageGalleryCategories.get(position).getSubcategories());
			intent.putExtra(MySubCollectActivity.MY_SUB_COLLECT_LAYOUT_ON_TOP, mIsLayoutOnTop);
			mContext.startActivity(intent);*/
		}
	}
}
