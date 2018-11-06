package jp.ac.uryukyu.ie.e185744;

public class Main {
    public static void main(String[] args){

        //主人公の設定
        Naming naming_h = new Naming();
        naming_h.setName(1);
        Hero hero = new Hero(naming_h.getName(), 10, 5);

        //仲間の設定
        Naming naming_a = new Naming();
        naming_a.setName(0);
        Monk monk = new Monk(naming_a.getName(),6,3);

        //敵
        Enemy enemy = new Enemy("キングスライム", 50, 5);


        System.out.printf("%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while( !hero.isDead() && !enemy.isDead()){
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
            if(!enemy.isDead()) {
                monk.heal(hero);
            }
        }
        System.out.println("戦闘終了");
    }
}
