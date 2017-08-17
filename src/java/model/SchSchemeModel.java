/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SarthakJ
 */
public class SchSchemeModel {
    int sid,amt,income,oid;
    String nameSch,cat,otherD,howA;
    String deadLine,upto,above;
    float percent;
    
    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
    

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getNameSch() {
        return nameSch;
    }

    public void setNameSch(String nameSch) {
        this.nameSch = nameSch;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getUpto() {
        return upto;
    }

    public void setUpto(String upto) {
        this.upto = upto;
    }

    public String getAbove() {
        return above;
    }

    public void setAbove(String above) {
        this.above = above;
    }

    

    public String getOtherD() {
        return otherD;
    }

    public void setOtherD(String otherD) {
        this.otherD = otherD;
    }


    public String getHowA() {
        return howA;
    }

    public void setHowA(String howA) {
        this.howA = howA;
    }
    
}
