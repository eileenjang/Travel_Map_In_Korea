package com.gilbut.mapgyeongju.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 4;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        DummyItem dummyItem = null;
        String details = null;
        if(position==1) {
            details = "경주시 토함산에 있는 신라 시대 사찰로 경덕왕 10년(751년)에 김대성의 발원으로 창건했다. " +
                    "\n임진왜란 때 대부분 건물이 불타고,1969년부터 발굴 조사 후 복원해 현재 모습이 되었다. ";
            dummyItem = new DummyItem(String.valueOf(position), "불국사", details);
        }else if(position==2){
            details = "경주시 교동에 있는 다리로 신라 시대에 지어졌으나 조선 시대에 유실되었다고 알려졌다. " +
                    "\n삼국사기 기록을 바탕으로 발굴해 2018년에 복원을 완료했다. ";
            dummyItem = new DummyItem(String.valueOf(position), "월정교", details);
        }else if(position==3){
            details = "경주시 인왕동에 있는 신라 시대 천문 기상 관측대로 국보 제31호다. " +
                    "\n동양에서 가장 오래된 관측대로 역사적, 문화적으로 가치가 높다. ";
            dummyItem = new DummyItem(String.valueOf(position), "첨성대",details);
        }else if(position==4){
            details = "경주시 구황동에 있는 신라 시대 절로 몽골 침입 때 불타 현재는 절터만 남아 있다. " +
                    "\n93년에 걸쳐 만들어진 신라 시대 가장 큰 절로 전해진다. ";
            dummyItem = new DummyItem(String.valueOf(position), "황룡사지", details);
        }
        return dummyItem;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
