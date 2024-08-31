package com.prashantkumar957.aktunotes.Recycler;

public class Model {
    String id, subject, img, pdfLink;

    public Model() {

    }

    public Model(String id, String subject, String img, String pdfLink) {
        this.id = id;
        this.subject = subject;
        this.img = img;
        this.pdfLink = pdfLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPdfLink() {
        return pdfLink;
    }

    public void setPdfLink(String pdfLink) {
        this.pdfLink = pdfLink;
    }
}
