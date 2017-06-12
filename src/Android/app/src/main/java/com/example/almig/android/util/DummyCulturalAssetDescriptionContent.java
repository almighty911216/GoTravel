package com.example.almig.android.util;

import com.example.almig.android.R;
import com.example.almig.android.model.CulturalAssetDescriptionModel;

import java.util.ArrayList;

/**
 * Created by almig on 2017-06-11.
 */

public class DummyCulturalAssetDescriptionContent {
    public static ArrayList<CulturalAssetDescriptionModel> getGyeongJuCulturalAssetDescriptionModels() {
        ArrayList<CulturalAssetDescriptionModel> culturalAssetDescriptionModels = new ArrayList<>();

        CulturalAssetDescriptionModel culturalAssetDescriptionModel = new CulturalAssetDescriptionModel();
        culturalAssetDescriptionModel.setMainImage(R.drawable.chumsungdae_description_main);
        culturalAssetDescriptionModel.setUpperSubImage(R.drawable.chumsungdae_description_sub);
        culturalAssetDescriptionModel.setName("첨성대");
        culturalAssetDescriptionModel.setNumber("국보 제31호");
        culturalAssetDescriptionModel.setAge("삼국 신라시대");
        culturalAssetDescriptionModel.setOpenTime("09:00");
        culturalAssetDescriptionModel.setCloseTime("22:00");
        culturalAssetDescriptionModel.setEntranceFee(0L);
        culturalAssetDescriptionModel.setParkingFee(2000L);
        culturalAssetDescriptionModel.setAddr("경상북도 경주시 첨성로 169-5(인왕동)");
        culturalAssetDescriptionModel.setDescription("첨성대는 우리나라 최초의 천문 관측대이자 동양에서 가장 오래된 천문대이다.\n" +
                "7세기 중반, 신라 선덕 여왕 때에 세워져 1500여년이라는 긴 세월동안 단 한번의 보수나 개축이 없었던 유일한 고대 건축물이다.\n" +
                "규모는 작지만 천체의 상징성과 계절의 변화를 정확하게 측정하는 구조를 갖고있다.\n" +
                "옛 기록에 의하면 \"사람이 가운데로 해서 올라가게 되어있다.\"고 했는데 바깥쪽에 사다리를 놓고 창릉 통해 안으로 들어간 후 다시 사다리를 이용해 꼭대기까지 올라가 하늘을 관찰 했던 것으로 보인다. \n" +
                "천문학은 하늘의 움직임에 따라 농사시기를 결정할 수 있다는 점에서 농업과 깊은 관계가 있으며, 관측 결과에 따라 국가의 길흉을 점치던 점성술이 고대국가에서 중요시되었던 점으로 미루어 보면 정치와도 관련이 깊음을 알 수 있다.\n" +
                "첨성대의 기능에 대해서 조선 말기 이후까지도 천문대 즉, 천문 관측을 하는 곳으로 이해되었다. \n" +
                "그런데 광복 이후 갑자기 현존하는 첨성대가 평지에 있다는 점, 첨성대 자체의 구조상 그 위로 오르내리는 통로가 매우 불편하다는 점 등의 이유로 첨성대의 기능에 대해 여러가지 설과 이견이 제기되기도 하였다.");
        culturalAssetDescriptionModels.add(culturalAssetDescriptionModel);

        culturalAssetDescriptionModel = new CulturalAssetDescriptionModel();
        culturalAssetDescriptionModel.setMainImage(R.drawable.bunhwangsa_description_main);
        culturalAssetDescriptionModel.setUpperSubImage(R.drawable.bunhwangsa_description_sub);
        culturalAssetDescriptionModel.setNumber("분황사");
        culturalAssetDescriptionModel.setAge("서기 634년(선덕여왕 3년)");
        culturalAssetDescriptionModel.setOpenTime("09:00");
        culturalAssetDescriptionModel.setCloseTime("18:00");
        culturalAssetDescriptionModel.setEntranceFee(1300L);
        culturalAssetDescriptionModel.setParkingFee(0L);
        culturalAssetDescriptionModel.setAddr("경상북도 경주시 분황로 94-11(구황동)");
        culturalAssetDescriptionModel.setDescription("분황사는 안산암을 벽돌 모양으로 다듬어 쌓은 모전석탑으로 신라 선덕 여왕 때에 세워졌다.\n" +
                "신라의 유명한 승려인 자장과 원효가 머물렀던 곳으로 유명하다. \n" +
                "신라의 큰 절답게 많은 문화재를 가지고 있었으나 몽골의 침략과 임진왜란으로 인해 대부분 불에 타거나 사라져 현재 분황사 안에는 분황사 석탑과 화쟁국사비부, 분황사 석정(돌우물) 등이 남아 있다. \n" +
                "석탑 또한 현재 3층까지만 남아 있으나 원래는 7층 또는 9층이었을 것이라 추정된다.\n\n" +
                "<분황사라는 이름의 유래>\n" +
                "선덕여왕이 공주였을 때, 하루는 당나라의 황제가 선덕여왕에게 그림을 선물합니다.\n" +
                "이 그림에는 붉은색과 자주색, 흰색으로 모란이 그려져 있었습니다. \n" +
                "그림과 함께 모란의 씨도 같이 보내왔죠. 이 그림을 본 사람들은 황제가 공주를 꽃에 \n" +
                "비유했다며 좋아했는데, 오직 선덕여왕(당시엔 공주)만이 불쾌한 마음을 감추지 못했습니다.\n" +
                "꽃 그림에 벌과 나비가 없었기 때문이죠. \n" +
                "혹시나 하는 마음에 같이 온 모란의 씨를 심어 꽃을 피워봤더니 정말 그 꽃에는 향기가 나지 않았습니다. \n" +
                "그러니까 선덕을 꽃에 비유하되 향기가 없는 꽃으로 표현했다는 건, 여자라지만 향기를 내뿜을 정도의 매력은\n" +
                "없다는 점을 당나라 황제가 은유적으로 나타냈다고 볼 수 있습니다. \n" +
                "이에 선덕은 자신만의 방식으로 당나라 황제에게 대응합니다. \n" +
                "여왕으로 즉위하고 3년이 지난 634년, '황제의 향기'라는 이름의 절을 지어버린 거죠. 이 절의 이름이 분황사입니다. ");
        culturalAssetDescriptionModels.add(culturalAssetDescriptionModel);

        return culturalAssetDescriptionModels;
    }
}
