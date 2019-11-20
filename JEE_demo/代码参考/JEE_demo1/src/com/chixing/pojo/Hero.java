package com.chixing.pojo;

/**
 * 该类表示 Hero 游戏中的英雄角色
 */

public class Hero {

    //成员变量
    private int heroId;
    private String heroUkName;
    private String heroNickName;
    private String heroTinyImg;
    private int heroMagicPower;
    private int heroPhysicPower;
    private int heroDefencePower;
    private int heroHandHard;
    private String heroRoles;


    //构造函数
    public Hero(){}
    public Hero(int heroId, String heroUkName, String heroNickName, String heroTinyImg, int heroMagicPower, int heroPhysicPower, int heroDefencePower, int heroHandHard, String heroRoles) {
        this.heroId = heroId;
        this.heroUkName = heroUkName;
        this.heroNickName = heroNickName;
        this.heroTinyImg = heroTinyImg;
        this.heroMagicPower = heroMagicPower;
        this.heroPhysicPower = heroPhysicPower;
        this.heroDefencePower = heroDefencePower;
        this.heroHandHard = heroHandHard;
        this.heroRoles = heroRoles;
    }

    //get,set

    public int getHeroId() {
        return heroId;
    }

    public void setHeroId(int heroId) {
        this.heroId = heroId;
    }

    public String getHeroUkName() {
        return heroUkName;
    }

    public void setHeroUkName(String heroUkName) {
        this.heroUkName = heroUkName;
    }

    public String getHeroNickName() {
        return heroNickName;
    }

    public void setHeroNickName(String heroNickName) {
        this.heroNickName = heroNickName;
    }

    public String getHeroTinyImg() {
        return heroTinyImg;
    }

    public void setHeroTinyImg(String heroTinyImg) {
        this.heroTinyImg = heroTinyImg;
    }

    public int getHeroMagicPower() {
        return heroMagicPower;
    }

    public void setHeroMagicPower(int heroMagicPower) {
        this.heroMagicPower = heroMagicPower;
    }

    public int getHeroPhysicPower() {
        return heroPhysicPower;
    }

    public void setHeroPhysicPower(int heroPhysicPower) {
        this.heroPhysicPower = heroPhysicPower;
    }

    public int getHeroDefencePower() {
        return heroDefencePower;
    }

    public void setHeroDefencePower(int heroDefencePower) {
        this.heroDefencePower = heroDefencePower;
    }

    public int getHeroHandHard() {
        return heroHandHard;
    }

    public void setHeroHandHard(int heroHandHard) {
        this.heroHandHard = heroHandHard;
    }

    public String getHeroRoles() {
        return heroRoles;
    }

    public void setHeroRoles(String heroRoles) {
        this.heroRoles = heroRoles;
    }


    //toString
    @Override
    public String toString() {
        return "Hero{" +
                "heroId=" + heroId +
                ", heroUkName='" + heroUkName + '\'' +
                ", heroNickName='" + heroNickName + '\'' +
                ", heroTinyImg='" + heroTinyImg + '\'' +
                ", heroMagicPower=" + heroMagicPower +
                ", heroPhysicPower=" + heroPhysicPower +
                ", heroDefencePower=" + heroDefencePower +
                ", heroHandHard=" + heroHandHard +
                ", heroRoles='" + heroRoles + '\'' +
                '}';
    }
}
