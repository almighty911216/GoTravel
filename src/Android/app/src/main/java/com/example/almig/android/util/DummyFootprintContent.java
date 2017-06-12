package com.example.almig.android.util;

import com.example.almig.android.R;
import com.example.almig.android.model.FootprintTextModel;

import java.util.ArrayList;

/**
 * Created by almig on 2017-06-12.
 */

public class DummyFootprintContent {
    public static ArrayList<FootprintTextModel> getFootprintTextModelList() {
        ArrayList<FootprintTextModel> list = new ArrayList<>();

        String content = "사촌동생과 함께한 2박3일 경주여행! 동생이 사진찍어줬어요. 근데 나 어디 보고 있는거야 ㅠ-ㅠ\n" +
                "이 석탑은 모전석탑이라 하는데 엄청 커요. 원래는 9층이였다고하는데 소실되어서 3층만 남아있는데 엄청 큰게 보이죠?";

        list.add(new FootprintTextModel(0, R.drawable.dummy_footprint_1, "신라 천년의 왕국 경주", "신라 천년의 왕국 경주\n" + "불 켜지니까 너무 예뻤던 첨성대!\n" + "바람이 많이 불어요 광고하는 사진같네ㅎㅎㅎ\n" + "그래두 꼭 첨성대랑 같이 셀카 찍고 싶었다~~v", "2017-03-24"));
        list.add(new FootprintTextModel(1, R.drawable.dummy_footprint_2, "야경이 이쁜 임해전지", "저 사진 잘찍는 사람이 아닌데 여긴 막 찍어도 진짜 이쁘게 나와요. 호수에 건물이 비쳐 위,아래 두개로 깨끗하게 나오거든요\n" + "올때마다 새로운 느낌이에요♥", "2017-02-15"));
        list.add(new FootprintTextModel(2, R.drawable.dummy_footprint_3, "불국사에서 한컷!", "#불국사 #셀카 #셀스타그램 #얼스타그램 #selfie #self #여행 #경주", "2017-01-7"));
        list.add(new FootprintTextModel(3, R.drawable.dummy_footprint_4, "경주 1박2일 가족여행 중 오릉에서", "많은 문화재와 유적지가 있어 도시 전체가 역사박물관이라는 도시, 경주. 가족들과 함께해 더 좋았던 여행. 이 기회에 신라 역사 공부를 할 수 있었답니다.", "2017-01-7"));
        list.add(new FootprintTextModel(4, R.drawable.dummy_footprint_5, "경주에서 가볼만한곳, 분황사", "사촌동생과 함께한 2박3일 경주여행! 동생이 사진찍어줬어요. 근데 나 어디 보고 있는거야 ㅠ-ㅠ\n" + "이 석탑은 모전석탑이라 하는데 엄청 커요. 원래는 9층이였다고하는데 소실되어서 3층만 남아있는데 엄청 큰게 보이죠?", "2017-01-7"));

        return list;
    }
}
