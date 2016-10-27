package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 16-03-2016.
 */
public class events {
    public String title;
    public String description;
    public int image1;
    public String des1;
    public int image2;
    public String des2;
    public int image3;
    public String des3;
    public int image4;
    public String des4;

    public events(){
        super();
    }
    public events(String title,String description,int image1,String des1,int image2,String des2,int image3,String des3,int image4,String des4){
        super();
        this.title=title;
        this.description=description;
        this.image1=image1;
        this.des1=des1;
        this.image2=image2;
        this.des2=des2;
        this.image3=image3;
        this.des3=des3;
        this.image4=image4;
        this.des4=des4;
    }

    public String gettitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public int getImage1(){
        return image1;
    }
    public String getDes1(){
        return  des1;
    }
    public int getImage2(){
        return image2;
    }
    public String getDes2(){
        return  des2;
    }
    public int getImage3(){
        return image3;
    }
    public String getDes3(){
        return  des3;
    }
    public int getImage4(){
        return image4;
    }
    public String getDes4(){
        return  des4;
    }



}
