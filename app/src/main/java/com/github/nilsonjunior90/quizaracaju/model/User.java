package com.github.nilsonjunior90.quizaracaju.model;

public class User {
    private Long id;
    private String eMail;
    private String name;
    private String password;
    private int highscore;

    public User(String eMail, String name, String password) {
        this.eMail = eMail;
        this.name = name;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int newHighscore) {
        if(newHighscore > this.highscore){
            this.highscore = newHighscore;
        }
    }
}
