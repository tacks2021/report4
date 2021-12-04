package jp.ac.uryukyu.ie.e215737;

/**
 *  生き物クラス。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 */

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    LivingThing(String name, int maximumHP, int attack){

        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /**
     * 真偽を返す。
     * @return　true or false
     */
    
    public boolean isDead(){
        return dead;
    }

    /**
     * 名前を返す。
     * @return 名前
     */

    public String getName(){
        return name;
    }

    public boolean getDead(){
        return this.dead;
    }

    /**
     * 攻撃するメソッド。
     * 乱数でダメージを算出。
     * @param opponent 攻撃対象
     */
    
    public void attack(LivingThing opponent){
        int damage = (int)(Math.random() * attack);
        if (this.dead == false){
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
        else {
            opponent.wounded(0);
        }
    }

    /**
     * ダメージ処理を行うメソッド。
     * 死亡判定を行う。
     * @param damage 受けたダメージ
     */

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
