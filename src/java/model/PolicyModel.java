/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rohit
 */
public class PolicyModel {
     private int pid,oid;
     private String empeusername,refid,dateofpolicy,aadhar,validupto,bankname,ifsc,accno,custusername,policytype,orgname;  

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }
 
    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }
    public String getPolicytype() {
        return policytype;
    }

    public void setPolicytype(String policytype) {
        this.policytype = policytype;
    }
 

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getEmpeusername() {
        return empeusername;
    }

    public void setEmpeusername(String empeusername) {
        this.empeusername = empeusername;
    }

    public String getRefid() {
        return refid;
    }

    public void setRefid(String refid) {
        this.refid = refid;
    }

    public String getDateofpolicy() {
        return dateofpolicy;
    }

    public void setDateofpolicy(String dateofpolicy) {
        this.dateofpolicy = dateofpolicy;
    }

    public String getValidupto() {
        return validupto;
    }

    public void setValidupto(String validupto) {
        this.validupto = validupto;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getCustusername() {
        return custusername;
    }

    public void setCustusername(String custusername) {
        this.custusername = custusername;
    }
 }
