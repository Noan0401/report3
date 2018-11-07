package jp.ac.uryukyu.ie.e185744;

/*僧侶を作るメソッド*/
/*現在攻撃力が回復力*/

public class Monk extends LivingThing{

    Monk(String name, int maximumHP, int attack, int defence, int maximumMP) {
        super(name,maximumHP,attack,defence,maximumMP);
    }

    public void wounded(int damage){
        int hitpoint_m = super.getHitPoint();

        hitpoint_m -= damage;
        setHitPoint(hitpoint_m);
        if( hitpoint_m < 0 ) {
            setDead(true);
            System.out.printf("仲間の%sは力尽きてしまった。\n", super.getName());
        }
    }
}
