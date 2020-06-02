package com.CMRCET.sharebit;

public class UserHelper {

    String depart;
    String rom;
    String pbm;

    public UserHelper() {

    }

    public UserHelper(String depart, String rom, String pbm) {
        this.depart = depart;
        this.rom = rom;
        this.pbm = pbm;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getPbm() {
        return pbm;
    }

    public void setPbm(String pbm) {
        this.pbm = pbm;
    }
}
