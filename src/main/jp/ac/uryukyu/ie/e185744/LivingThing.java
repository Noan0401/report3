package jp.ac.uryukyu.ie.e185744;

public class LivingThing {

    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", this.name, this.hitPoint, this.attack);
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getName(){
        return name;
    }

    public void attack(LivingThing opponent){
        if(!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n",this.name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    public void wounded(int damage){
        this.hitPoint -= damage;
        if( LivingThing.this.hitPoint < 1 ) {
            LivingThing.this.dead = true;
            System.out.printf("%sは倒れた。\n", LivingThing.this.name);
        }
    }
}
