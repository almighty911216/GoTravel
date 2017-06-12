package com.example.almig.android.util;

import com.example.almig.android.R;
import com.example.almig.android.model.CulturalAssetCategoryModel;

import java.util.ArrayList;

/**
 * Created by almig on 2017-06-11.
 */

public class DummyCulturalAssetCategoryContent {
    public static ArrayList<CulturalAssetCategoryModel> getSeoulCulturalAssetsCategoryModels() {
        ArrayList<CulturalAssetCategoryModel> culturalAssetCategoryModels = new ArrayList<>();

        CulturalAssetCategoryModel culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(0L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_gyeongbokgung);
        culturalAssetCategoryModel.setLogoId(R.drawable.gyeongbokgung);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(1L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_changdeokgung);
        culturalAssetCategoryModel.setLogoId(R.drawable.changdeokgung);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(2L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_heunginjimun);
        culturalAssetCategoryModel.setLogoId(R.drawable.heunginjimun);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(3L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_jongmyo);
        culturalAssetCategoryModel.setLogoId(R.drawable.jongmyo);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(4L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_mongchontoseong);
        culturalAssetCategoryModel.setLogoId(R.drawable.mongchontoseong);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(5L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_sunsa);
        culturalAssetCategoryModel.setLogoId(R.drawable.sunsa);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(6L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_namhansansang);
        culturalAssetCategoryModel.setLogoId(R.drawable.namhansansang);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(7L);
        culturalAssetCategoryModel.setTitleId(R.string.seoul_cultural_asset_name_sungnyemun);
        culturalAssetCategoryModel.setLogoId(R.drawable.sungnyemun);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        return culturalAssetCategoryModels;
    }

    public static ArrayList<CulturalAssetCategoryModel> getGyeongJuCulturalAssetsCategoryModels() {
        ArrayList<CulturalAssetCategoryModel> culturalAssetCategoryModels = new ArrayList<>();

        CulturalAssetCategoryModel culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(0L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_bulguksa);
        culturalAssetCategoryModel.setLogoId(R.drawable.bulguksa);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(1L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_bunhwangsa);
        culturalAssetCategoryModel.setLogoId(R.drawable.bunhwangsa);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(2L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_chumsungdae);
        culturalAssetCategoryModel.setLogoId(R.drawable.chumsungdae);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(3L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_hwangryongsaji);
        culturalAssetCategoryModel.setLogoId(R.drawable.hwangryongsaji);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(4L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_imhae_jeonji);
        culturalAssetCategoryModel.setLogoId(R.drawable.imhae_jeonji);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(5L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_posukjung);
        culturalAssetCategoryModel.setLogoId(R.drawable.posukjung);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(6L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_royal_tomb_of_queen_sundeok);
        culturalAssetCategoryModel.setLogoId(R.drawable.royal_tomb_of_queen_sundeok);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        culturalAssetCategoryModel = new CulturalAssetCategoryModel();
        culturalAssetCategoryModel.setId(7L);
        culturalAssetCategoryModel.setTitleId(R.string.gyeongju_cultural_asset_name_sukgulam);
        culturalAssetCategoryModel.setLogoId(R.drawable.sukgulam);
        culturalAssetCategoryModel.setVisit(false);
        culturalAssetCategoryModels.add(culturalAssetCategoryModel);

        return culturalAssetCategoryModels;
    }
}
