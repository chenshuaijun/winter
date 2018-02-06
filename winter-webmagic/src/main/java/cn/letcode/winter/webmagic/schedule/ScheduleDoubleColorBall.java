package cn.letcode.winter.webmagic.schedule;

import cn.letcode.utils.calendar.CalendarUtil;
import cn.letcode.winter.webmagic.mapper.DoubleColorBallMapper;
import cn.letcode.winter.webmagic.model.DoubleColorBall;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class ScheduleDoubleColorBall {
    private final static Logger logger = LoggerFactory.getLogger(ScheduleDoubleColorBall.class);

    @Resource
    private DoubleColorBallMapper doubleColorBallMapper;
    @Resource
    private JavaMailSender mailSender;
    /**
     * 网易双色球查询地址
     */
    private final String doubleBallUrl = "http://caipiao.163.com/award/ssq/";

    public ScheduleDoubleColorBall() {
    }

    @Scheduled(cron = "${global.schedule.doubleColorBallCron}")
    public void reportCurrentTime() {
        logger.info("The time is now {}", CalendarUtil.getCurrentDateTime());
        DoubleColorBall doubleColorBall = queryCurrentDateBall();
        if (doubleColorBall == null) {
            return;
        }
        DoubleColorBall existsBall = doubleColorBallMapper.selectByPrimaryKey(doubleColorBall.getId());
        if (existsBall != null) {
            return;
        }
        doubleColorBallMapper.insert(doubleColorBall);
        // 发送邮件通知
        sendSimpleMail(doubleColorBall);
    }

    /**
     * 发送邮件
     *
     * @param doubleColorBall
     */
    public void sendSimpleMail(DoubleColorBall doubleColorBall) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ball", doubleColorBall);
        model.put("calendarUtil", new CalendarUtil());
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_26);

            cfg.setDirectoryForTemplateLoading(ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "template"));

            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);

            Template template = cfg.getTemplate("doubleColorBall.ftl");

            String result = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("service@letcode.cn");
            helper.setTo("chensj_blue@163.com");
            helper.setSubject("双色球开奖结果通知");
            helper.setText(result, true);
            logger.info("开始发邮件-START");
            mailSender.send(mimeMessage);
            logger.info("开始发邮件-END ");
        } catch (Exception e) {
            logger.error("发送邮件错误：：：{}", e.getMessage());
            e.printStackTrace();
        }

    }


    /**
     * 查询最新双色球内容
     *
     * @return
     */
    private DoubleColorBall queryCurrentDateBall() {
        DoubleColorBall doubleColorBall = new DoubleColorBall();

        Connection connection = Jsoup.connect(doubleBallUrl);
        connection.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
        Document documentAll = null;
        try {
            // 获取页面内容
            documentAll = connection.get();
            // 控制一定的取值范围
            Elements all = documentAll.getElementsByClass("gray_border search_zj_info");
            Element elements = all.get(0);
            // 查询开奖期数
            Elements elementDateNo = elements.getElementsByAttributeValue("id", "date_no");
            String dateNo = elementDateNo.get(0).text();
            doubleColorBall.setIssueNo(dateNo);
            doubleColorBall.setId(dateNo);
            // 查询发布日期
            Elements elementDateTime = elements.getElementsByAttributeValue("id", "time");
            String dateTime = elementDateTime.text();
            doubleColorBall.setIssueDate(CalendarUtil.formatDateTime(dateTime, "yyyy-MM-dd HH:mm", "yyyyMMddHHmmss"));

            // 销售额
            Elements elementSaleAmt = elements.getElementsByAttributeValue("id", "sale");
            String saleAmt = elementSaleAmt.text();
            doubleColorBall.setSellAmt(new BigDecimal(saleAmt));
            // 奖金池
            Elements elementPool = elements.getElementsByAttributeValue("id", "pool");
            String poolAmt = elementPool.text();
            doubleColorBall.setPrizePool(new BigDecimal(poolAmt));
            // 一等奖
            Element elementAmts = elements.getElementsByAttributeValue("id", "bonus").get(0).getElementsByTag("tr").get(1);
            String firstAmt = elementAmts.getElementsByTag("td").get(2).text();
            doubleColorBall.setFirstPrize(new BigDecimal(firstAmt));
            // 红球
            Elements elementsRedBalls = elements.getElementsByClass("red_ball");
            doubleColorBall.setRedball1(elementsRedBalls.get(0).text());
            doubleColorBall.setRedball2(elementsRedBalls.get(1).text());
            doubleColorBall.setRedball3(elementsRedBalls.get(2).text());
            doubleColorBall.setRedball4(elementsRedBalls.get(3).text());
            doubleColorBall.setRedball5(elementsRedBalls.get(4).text());
            doubleColorBall.setRedball6(elementsRedBalls.get(5).text());
            // 蓝球
            Elements elementsBlueBalls = elements.getElementsByClass("blue_ball");
            doubleColorBall.setBlueball1(elementsBlueBalls.text());
            return doubleColorBall;
        } catch (IOException e) {
            logger.error("获取双色求开奖结果失败，失败原因是：{}", e.getMessage());
        }
        return null;
    }


}
