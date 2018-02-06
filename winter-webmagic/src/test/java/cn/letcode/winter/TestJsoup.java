package cn.letcode.winter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestJsoup {


    public static void main(String[] arg) {
        String htmlPage = null;
        try {
            Connection connection = Jsoup.connect("http://caipiao.163.com/award/ssq/");
            connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
            Document document = connection.get();
            Elements elementDateNo = document.getElementsByAttributeValue("id", "date_no");
            String dateNo = elementDateNo.get(0).html();

            Elements elementTime = document.getElementsByAttributeValue("id", "time");

            String time = elementTime.text();

            System.out.println(dateNo + ":::" + time);

            Element firstAmts = document.getElementsByAttributeValue("id", "bonus").get(0).getElementsByTag("tr").get(1);
            System.out.println(firstAmts.getElementsByTag("td").get(2).html());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
