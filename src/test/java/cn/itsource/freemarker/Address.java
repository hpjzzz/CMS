package cn.itsource.freemarker;

public class Address {
    private String href;
    private String tagName;

    @Override
    public String toString() {
        return "FreeMarkerTest{" +
                "href='" + href + '\'' +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}

