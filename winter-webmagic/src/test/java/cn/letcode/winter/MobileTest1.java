package cn.letcode.winter;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MobileTest1 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/chenshuaijun/workspace/temp/temp_mobile.txt"));
            String line = null;
            String mobiles = "";
            while ((line = br.readLine()) != null) {
                if (line.contains("五行数理说明：号码")) {
                    String mobile = line.substring(10, 21);
                    if (!mobiles.contains(mobile)) {
                        getMobileInfo(mobile);
                    }
                    mobiles += mobile + ",";

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getMobileInfo(String mobileNo) {
        String htmlPage = null;
        try {
            Connection connection = Jsoup.connect("http://life.httpcn.com/mobile.asp?isbz=0&word=" + mobileNo + "&data_type=0&year=1980&month=7&day=12&hour=20&minute=10&pid=&cid=&name=&sex=1&act=submit");
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
            connection.header("Content-Type", "application/x-www-form-urlencoded");
            Document document = connection.get();
            Element element = document.getElementsByClass("l_form_ok").get(0);
            Element chaxun_b = element.getElementsByClass("chaxun_b").get(0);
//            System.out.println(chaxun_b.html());
            String fen = chaxun_b.getElementsByTag("font").get(1).text();
            if (fen.contains("100")) {
                System.out.println(fen);
                System.out.println(chaxun_b.text());
                System.out.println("=================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
