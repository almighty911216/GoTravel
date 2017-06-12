package com.example.almig.android.util;


import com.example.almig.android.R;
import com.example.almig.android.model.AreaCategoryModel;
import com.example.almig.android.model.DummyModel;

import java.util.ArrayList;

import static com.example.almig.android.util.DummyCulturalAssetCategoryContent.getGyeongJuCulturalAssetsCategoryModels;
import static com.example.almig.android.util.DummyCulturalAssetCategoryContent.getSeoulCulturalAssetsCategoryModels;

public class DummyContent {
	public static ArrayList<AreaCategoryModel> getAreaCategorieModels() {
		ArrayList<AreaCategoryModel> areaCategoryModels = new ArrayList<AreaCategoryModel>();

		AreaCategoryModel areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(0L);
		areaCategoryModel.setLogoId(R.drawable.logo_seoul);
		areaCategoryModel.setTitleId(R.string.state_seoul);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(1L);
		areaCategoryModel.setLogoId(R.drawable.logo_incheon);
		areaCategoryModel.setTitleId(R.string.state_incheon);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(2L);
		areaCategoryModel.setLogoId(R.drawable.logo_gwangju);
		areaCategoryModel.setTitleId(R.string.state_gwangju);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(3L);
		areaCategoryModel.setLogoId(R.drawable.logo_daegu);
		areaCategoryModel.setTitleId(R.string.state_daegu);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(4L);
		areaCategoryModel.setLogoId(R.drawable.logo_busan);
		areaCategoryModel.setTitleId(R.string.state_busan);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(5L);
		areaCategoryModel.setLogoId(R.drawable.logo_gyeongju);
		areaCategoryModel.setTitleId(R.string.state_gyeongju);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getGyeongJuCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(6L);
		areaCategoryModel.setLogoId(R.drawable.logo_ulsan);
		areaCategoryModel.setTitleId(R.string.state_ulsan);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		areaCategoryModel = new AreaCategoryModel();
		areaCategoryModel.setId(7L);
		areaCategoryModel.setLogoId(R.drawable.logo_jeju);
		areaCategoryModel.setTitleId(R.string.state_jeju);
		areaCategoryModel.setComplete(false);
		areaCategoryModel.setSubcategories(getSeoulCulturalAssetsCategoryModels());
		areaCategoryModels.add(areaCategoryModel);

		return areaCategoryModels;
	}

	public static ArrayList<DummyModel> getSeachModelList() {
		ArrayList<DummyModel> list = new ArrayList<>();
		list.add(new DummyModel(0, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "분황사", R.string.fontello_search));
		list.add(new DummyModel(1, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "첨성대", R.string.fontello_search));
		list.add(new DummyModel(2, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "불국사", R.string.fontello_search));
		list.add(new DummyModel(3, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "천마총", R.string.fontello_search));
		list.add(new DummyModel(4, "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", "보국사", R.string.fontello_search));
		return list;
	}
}
