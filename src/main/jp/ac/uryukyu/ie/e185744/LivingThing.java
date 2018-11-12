package jp.ac.uryukyu.ie.e185744;
import java.util.Scanner;

public class LivingThing {

    private String name;
    private int hitPoint; //HP
    private int maxHP;
    private int attack;   //攻撃力
    private int defence;
    private int defence_1;
    private int magicPoint;
    private int damage;
    private boolean dead;



    LivingThing (String name, int maximumHP, int attack , int defence, int maximumMP) {
        int pulusHP = (int) (Math.random() * 4);

        this.name = name;
        this.hitPoint = maximumHP + pulusHP;
        this.maxHP = maximumHP + pulusHP;
        this.attack = attack;
        this.defence = defence;
        this.defence_1 = defence;
        this.magicPoint = maximumMP;
        this.dead = false;
        System.out.printf("%sのHPは%d。MPは%d。", this.name, this.hitPoint, this.magicPoint);
        System.out.printf("攻撃力hは%dで、防御力は%dです。\n",this.attack, this.defence);
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
            int p = opponent.defence / 2;
            int damage = (int) (Math.random() * attack) - p + (attack/3) ;
            this.damage = damage;

            if(damage < 0){
                damage = 0;
            }
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
    public void heal(LivingThing opponent){

        int heal = (int) (Math.random() * 5);
        this.magicPoint = this.magicPoint - 3;

        int damage = maxHP - hitPoint;
        int my_hitpoint = this.hitPoint;

        if(!this.isDead() && damage > 0){

            if(damage < heal){
                heal = damage;
            }

            my_hitpoint += heal;
            this.setHitPoint(my_hitpoint);
            System.out.printf("%sは%sを%d回復した！！\n",this.name, this.name,heal);
        }
    }

    //防御メソッド
    void protecthion(LivingThing opponemt){
        this.defence = this.defence * 2;
        System.out.printf("%sは防御している！\n",this.name);
    }

    void reset_defence(){
        this.defence = this.defence_1;
    }

    private int user_input(int number){

        int input;
        Scanner in = new Scanner(System.in);

        if(number == 1){
            System.out.println("1.攻撃魔法　2.回復魔法");
        }else{
            System.out.printf("\t%s\n\tHP:%d\n\tMP:%d\n\n",this.name,this.hitPoint,this.magicPoint);
            System.out.println("1.攻撃　2.防御　3.呪文");
        }

        input = in.nextInt();
        return input;
    }

    public void selection(LivingThing opponent){
        int select = user_input(0);
        Skill skill = new Skill(magicPoint,name);

        switch (select){

            case 1:
                attack(opponent);
                break;

            case 2:
                protecthion(opponent);
                System.out.println(this.defence);
                break;
            case 3:
                int select_2 = user_input(1);
                if(magicPoint > 1){
                    if(select_2 == 1){
                        skill.magic(opponent.name,2);
                        this.magicPoint = skill.getMagick_point();
                    }else{
                        heal(opponent);
                    }

                }else {
                    System.out.println("MPが足りない！！");
                }

                break;

            default:
                attack(opponent);
        }

    }

}
