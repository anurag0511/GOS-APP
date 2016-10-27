package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 13-03-2016.
 */
public class places {
    public int image;
    public String title;
    public String description;
    public places(){
        super();
    }
    public places(int image,String title,String description){
        super();
        this.image=image;
        this.title=title;
        this.description=description;
    }
    public int getimageid(){
        return image;
    }
    public String gettitle(){
        return title;
    }
    public String getdescription(){
        return description;
    }

}
