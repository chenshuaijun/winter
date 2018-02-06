package cn.letcode.winter.webmagic.bean;

public class News {
    private String title;
    private String info;
    private String link;
    private Sources sources;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Sources getSources() {
        return sources;
    }

    public void setSources(Sources sources) {
        this.sources = sources;
    }
}
