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
    public Hero (String name, int maximumHP, int attack) {
//        this.name = name;
//        hitPoint = maximumHP;
//        this.attack = attack;
//        dead = false;
//        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
        super(name,maximumHP,attack);
    }

    /**
     * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        super.hitPoint -= damage;
        if( super.hitPoint < 0 ) {
            super.dead = true;
            System.out.printf("%sは道半ばで力尽きてしまった。\n", super.name);
        }
    }
}
