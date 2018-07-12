package cn.letcode.winter;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MobileTest {

    public static void main(String[] args) {

//
//        String jsonStr =
//                "{\"pageend\":5,\"sortby\":\"1\",\"querystatus\":1,\"status\":\"2\",\"errorMsg\":null,\"prettypattern\":\"\",\"contnumber\":\"\",\"code\":null,\"minpay\":\"\",\"maxpay\":\"\",\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"maxPage\":25,\"totalCount\":500,\"listphones\":[{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337164071\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337164093\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337164192\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337164275\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337164736\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337165863\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17337168433\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":0,\"level\":1,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"17796654029\",\"province\":\"河南省\",\"prepayMent\":0,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937125248\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937125428\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937127348\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937127458\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937127498\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937127648\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937127948\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937128422\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":49,\"level\":2,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937128748\",\"province\":\"河南省\",\"prepayMent\":200,\"city\":\"郑州市\"},{\"minAmount\":89,\"level\":3,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937123113\",\"province\":\"河南省\",\"prepayMent\":400,\"city\":\"郑州市\"},{\"minAmount\":89,\"level\":3,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937123200\",\"province\":\"河南省\",\"prepayMent\":400,\"city\":\"郑州市\"},{\"minAmount\":89,\"level\":3,\"salesProdId\":\"0000000064C4FBA6A367629AE053AA1410AC7228\",\"phoneNumber\":\"19937123500\",\"province\":\"河南省\",\"prepayMent\":400,\"city\":\"郑州市\"}],\"shopId\":\"10017\",\"pageindex\":1}";
//
//        JSONObject jsonObject = new JSONObject(jsonStr);
//
//        JSONArray jsonphones = (JSONArray) jsonObject.get("listphones");
//        int i = 0;
//
//        for (i = 0; i < jsonphones.length(); i++) {
//            JSONObject jj = (JSONObject) jsonphones.get(i);
//            //System.out.println(jj.get("phoneNumber"));
//            getMobileInfo(jj.getString("phoneNumber"));
//        }
//        System.out.println("");
//        System.out.println("over !!!!");


        getMobileData(0);
    }

    int i = 0;

    public static void getMobileData(int i) {
        System.out.println("当前页面是：" + i);
        int count = 0;
        String url = "https://shop.10086.cn/list/134_371_371_2_0_0_0.html?p=";
        Connection connection = Jsoup.connect(url + i);
        connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
        Document document = null;
        try {
            document = connection.get();
            Elements elements = document.getElementsByClass("goodsList");
            Element element = elements.get(0);
            // 获取左边的内容
            Elements tr = element.getElementsByTag("tr");
            for (Element e : tr) {
                String mobile = e.getElementsByClass("name").text();
                if (mobile != null && !"".equals(mobile.trim())) {
                    count++;
//                    System.out.println("当前手机号码：" + mobile);
                    getMobileInfo(mobile);
                }

            }
            if (count < 40)
                return;
            else {
                i++;
                getMobileData(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getMobileInfo(String mobileNo) {
//        System.out.println("当前手机号码：" + mobileNo);
        String htmlPage = null;
        MobileTest2.getMobileInfoS(mobileNo);
    }
}
