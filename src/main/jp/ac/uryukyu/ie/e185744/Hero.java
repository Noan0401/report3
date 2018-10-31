package jp.ac.uryukyu.ie.e185744;

public class Hero extends LivingThing{
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    Hero (String name, int maximumHP, int attack) {

        super(name,maximumHP,attack);
    }


    public void wounded(int damage){
        int hitpoint_h = super.getHitPoint();

        hitpoint_h -= damage;
        setHitPoint(hitpoint_h);
        if( hitpoint_h < 0 ) {
            setDead(true);
            System.out.printf("%sは道半ばで力尽きてしまった。\n",getName());
        }
    }
}
