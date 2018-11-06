package jp.ac.uryukyu.ie.e185744;

public class LivingThing {

    private String name;
    private int hitPoint; //HP
    private int attack;   //攻撃力
    private boolean dead;

    LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", this.name, this.hitPoint, this.attack);
    }

    //カプセル化HP
    int getHitPoint() {
        return hitPoint;
    }

    void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    //カプセル化死亡切り替え
    boolean isDead() {
        return dead;
    }

    void setDead(boolean dead) {
        this.dead = dead;
    }

    //カプセル化名前
    String getName(){
        return name;
    }

    //攻撃メソッド
    public void attack(LivingThing opponent){
        if(!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n",this.name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    //死亡判定
    public void wounded(int damage){
        this.hitPoint -= damage;
        if( LivingThing.this.hitPoint < 1 ) {
            LivingThing.this.dead = true;
            System.out.printf("%sは倒れた。\n", LivingThing.this.name);
        }
    }

    //回復メソッド
    public void heal(LivingThing ally){
        int heal = (int) (Math.random() * attack);
        if(!ally.isDead() && ally.getHitPoint() > 1){
            int ally_hitpoint = ally.getHitPoint();

            ally_hitpoint += heal;
            ally.setHitPoint(ally_hitpoint);
            System.out.printf("%sは%sを%d回復した！！\n",this.name, ally.getName(),heal);
        }
    }
}
