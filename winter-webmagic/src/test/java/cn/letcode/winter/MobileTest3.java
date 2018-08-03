package cn.letcode.winter;


import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class MobileTest3 {

    public static void main(String[] args) {
        StringBuffer head = null;
        for (int i = 1; i <= 86; i++) {
            head = new StringBuffer("2018");
            String num = head.append(StringUtils.leftPad(String.valueOf(i), 3, "0")).toString();
            getMobileData(num);
        }

    }


    public static void getMobileData(String num) {
        String url = "http://caipiao.163.com/award/ssq/" + num + ".html";
        Connection connection = Jsoup.connect(url);
        connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
        Document document = null;
        try {
            document = connection.get();
            Element element = document.getElementById("zj_area");
            Element time = document.getElementById("time");

            StringBuffer sb = new StringBuffer(num).append(",");
            sb.append(time.text()).append(",");

            Elements redBalls = element.getElementsByClass("red_ball");
            for (Element e : redBalls) {
                sb.append(e.text()).append(",");
            }
            Elements blueBalls = element.getElementsByClass("blue_ball");
            for (Element e : blueBalls) {
                sb.append(e.text()).append(",");
            }
            sb.append(EncoderHandler.encodeByMD5(sb.toString())).append("\n");
            if (sb.toString().contains(",,,,")) {
                getMobileData(num);
            } else
                method2(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 追加文件：使用FileWriter
     *
     * @param content
     */
    public static void method2(String content) {
        try {
            String fileName = "/Users/chenshuaijun/workspace/temp/doubleball/test.csv";
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
