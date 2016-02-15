package com.moldedbits.androiddemos.library_demos.loader.model;

public class Example {

    String hey;

    int anumber;

    boolean awesome;

    String link;

    @Override
    public String toString() {
        return "hey: " + hey + "\n" +
                "anumber: " + anumber + "\n" +
                "awesome: " + awesome + "\n" +
                "link: " + link + "\n";
    }

    public String getHey() {
        return hey;
    }

    public void setHey(String hey) {
        this.hey = hey;
    }

    public int getAnumber() {
        return anumber;
    }

    public void setAnumber(int anumber) {
        this.anumber = anumber;
    }

    public boolean isAwesome() {
        return awesome;
    }

    public void setAwesome(boolean awesome) {
        this.awesome = awesome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
