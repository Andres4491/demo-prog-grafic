package com.uni3t3.demoproggrafica.sqliteaccess.pojos;

/**
 * Created by alvinbaltodano on 3/20/17.
 */

public class Noticias {

    private Long _id;
    private String title;
    private String content;
    private String img_string;
    private int image_resource;

    public Long get_Id() {
        return _id;
    }

    public void set_Id(Long _Id) {
        this._id = _Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_string() {
        return img_string;
    }

    public void setImg_string(String img_string) {
        this.img_string = img_string;
    }

    public int getImage_resource() {
        return image_resource;
    }

    public void setImage_resource(int image_resource) {
        this.image_resource = image_resource;
    }

    @Override
    public String toString() {
        return "Noticias{" +
                "_Id=" + _id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img_string='" + img_string + '\'' +
                ", image_resource=" + image_resource +
                '}';
    }
}
