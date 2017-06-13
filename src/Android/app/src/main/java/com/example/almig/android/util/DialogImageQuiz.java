package com.example.almig.android.util;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.almig.android.R;
import com.example.almig.android.model.CulturalAssetCategoryModel;

import java.util.ArrayList;

public class DialogImageQuiz {

	private Context mContext;
	private Dialog mDialog;

	private ImageView mImage;
	private ArrayList<CulturalAssetCategoryModel> mDummyModelList;
	private int currentImage;
	private TextView mPrevious;
	private TextView mNext;
	private TextView mOK;

	public DialogImageQuiz(Context mContext) {
		this.mContext = mContext;
		this.mDummyModelList = DummyCulturalAssetCategoryContent.getGyeongJuCulturalAssetsCategoryModels();
		this.currentImage = 0;
	}

	public void showDialog() {
		if (mDialog == null) {
			mDialog = new Dialog(mContext, R.style.CustomDialogTheme);
		}
		mDialog.setContentView(R.layout.dialog_image_quiz);
		mDialog.show();
		
		mImage = (ImageView) mDialog.findViewById(R.id.dialog_travel_image);
		mPrevious = (TextView) mDialog.findViewById(R.id.dialog_travel_left);
		mNext = (TextView) mDialog.findViewById(R.id.dialog_travel_right);
		mOK = (TextView) mDialog.findViewById(R.id.dialog_travel_ok);
		
		displayCurrentImage(currentImage);
		
		initDialogButtons();
	}
	
	private void displayCurrentImage(int position) {
		mImage.setImageResource(mDummyModelList.get(position).getLogoId());
	}
	
	private void initDialogButtons() {

		mPrevious.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if(currentImage > 0){
					displayCurrentImage(--currentImage);
				}
			}
		});

		mNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				if(currentImage < mDummyModelList.size()-1) {
					displayCurrentImage(++currentImage);
				}
			}
		});

		mOK.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				mDialog.dismiss();
			}
		});
	}

	public void dismissDialog() {
		mDialog.dismiss();
	}
}
