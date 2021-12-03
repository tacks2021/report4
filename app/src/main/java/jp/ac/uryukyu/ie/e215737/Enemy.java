package jp.ac.uryukyu.ie.e215737;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 * Edit by Yuuki Takushi on 2021/11/15.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    /**
     * getName method.
     * @return this.name - 名前の取得
     */
    public String getName() { return this.name; }
    /**
     * setName method.
     * @param name 敵の名前
     */
    public void setName(String name) { this.name = name; }
    /**
     * getHitPoint method.
     * @return this.hitPoint - HPを取得
     */
    public int getHitPoint() { return this.hitPoint; }
    /**
     * setHitPoint method.
     * @param hitPoint 敵のHP
     */
    public void setHitPoint(int hitPoint) { this.hitPoint = hitPoint; }
    /**
     * getAttack method.
     * @return this.attack - 攻撃力を取得
     */
    public int getAttack() { return this.attack; }
    /**
     * setAttack method.
     * @param attack 敵の攻撃力
     */
    public void setAttack(int attack) { this.attack = attack; }
    /**
     * getDead method.
     * @return this.dead - 生存（死亡しているか）確認を取得
     */
    public boolean getDead() { return this.dead; }
    /**
     * setDead method.
     * @param dead trueの場合->死亡
     */
    public void setDead(Boolean dead) { this.dead = dead; }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * if文でhitPointの確認つまりモンスターのHPを確認し、モンスターが生き残っていた場合下記のコードを実行。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        if ( hitPoint > 0){
            dead = false;
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero.getName(), damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }

}