package RozetkaUserProfile;

import java.util.List;

public class Child {

    public String title;
    public String href;
    public String name;

    public Child(String title, String href, String name) {
        this.title = title;
        this.href = href;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


