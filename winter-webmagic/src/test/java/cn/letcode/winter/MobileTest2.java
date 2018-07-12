package cn.letcode.winter;


import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MobileTest2 {

    public static void main(String[] args) {

        String[] mobiles = {"186", "185", "156", "131", "130", "155", "132", "176"};
//        String[] mobiles = {"186"};
        for (String s : mobiles)
            getMobileData(s);
    }


    public static void getMobileData(String mobile) {
        String url = "http://num.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=76&cityCode=760&advancePayLower=0&sortType=1&goodsNet=4&searchCategory=3&qryType=02&numNet=" + mobile + "&groupKey=1500266384&judgeType=0";
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
        Document document = null;
        try {
            document = connection.get();
            String content = document.text().replace("jsonp_queryMoreNums(", "").replace(")", "");
            JSONObject jsonObject = new JSONObject(content);
            JSONArray array = jsonObject.getJSONArray("numArray");
            for (int i = 0; i < array.length(); i++) {
                Long str = (Long) array.get(i);
                i = i + 11;
//                System.out.println(str);
                getMobileInfo(String.valueOf(str));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getMobileInfo(String mobileNo) {
        getMobileInfoS(mobileNo);
    }

    static void getMobileInfoS(String mobileNo) {
        try {
            Connection connection = Jsoup.connect("http://mobile.9om.com/?lang=zh-cn&q=" + mobileNo);
            connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
            Document document = connection.get();
            // 获取测算内容
            Elements resultCenter = document.getElementsByAttributeValue("id", "center");
            Element resultContent = resultCenter.get(0);

            Element element = resultContent.getElementsByClass("detail").get(0);

            String money = element.getElementsByClass("rows").get(2).text();
            String starts = element.getElementsByClass("rows").get(1).getElementsByClass("red").get(0).text();
            String level = element.getElementsByClass("gray").get(0).text().replace("(", "").replace(")", "");
            if (starts.length() < 6) {
                return;
            }

            System.out.print(money);
            System.out.print("\n");

            System.out.print("幸运星: " + starts.length());
            System.out.print("\n");
            System.out.print("级别: " + level);
            System.out.print("\n");
            System.out.println("===========================");
//            System.out.println(element.html());
            System.out.println(element.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
