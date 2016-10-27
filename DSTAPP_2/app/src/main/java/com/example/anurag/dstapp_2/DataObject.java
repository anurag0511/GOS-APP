package com.example.anurag.dstapp_2;

/**
 * Created by ANURAG on 12-03-2016.
 */
public class DataObject {
    private String mText1;
    private String mText2;
    private int mpic;
    DataObject (String text1, String text2,int pic){
        mText1 = text1;
        mText2 = text2;
        mpic = pic;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

    public int getimgid(){
        return mpic;
    }
    public void setimgid(int mpic){
        this.mpic=mpic;
    }
}
