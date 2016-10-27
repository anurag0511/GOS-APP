package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 12-03-2016.
 */
public class contactm {
    public int pic;
    public boolean advisor;
    public String title;
    public int email;
    public int message;
    public int call;
    public contactm(){
        super();

    }
    public contactm(boolean advisor, int pic, String title,int email,int message,int call){
        super();
        this.pic=pic;
        this.advisor=advisor;
        this.title=title;
        this.email=email;
        this.message=message;
        this.call=call;
    }

    public String gettitle(){
        return title;
    }
    public int getpicid(){
        return pic;
    }
    public int getemailid(){
        return email;
    }
    public int getmessage(){
        return message;
    }
    public int getcall(){
        return call;
    }

    public boolean isAdvisor() {
        return advisor;
    }
}
