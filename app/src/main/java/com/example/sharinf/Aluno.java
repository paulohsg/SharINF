package com.example.sharinf;

/**
 * Created by ilha1 on 07/02/2018.
 */

public class Aluno {

    private int icon;
    private String title;

    public Aluno(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
