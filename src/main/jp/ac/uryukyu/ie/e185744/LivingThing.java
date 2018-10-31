package jp.ac.uryukyu.ie.e185744;

public class LivingThing {

    String name;
    int hitPoint;
    int attack;
    boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", this.name, this.hitPoint, this.attack);
    }

    public boolean isDead() {
        return dead;
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
