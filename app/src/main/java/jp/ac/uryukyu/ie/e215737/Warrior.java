package jp.ac.uryukyu.ie.e215737;

public class Warrior extends LivingThing {
    
    public Warrior(String name, int maximumHP, int attack){
        super(name, maximumHP, attack);
    }
    
    public int getHitPoint(){
        return this.hitPoint;
    }

    public void attackWithWeaponSkill(LivingThing opponent){
        int damage = (int)(attack * 1.5);
        if (this.dead == false){
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
        else {
            opponent.wounded(0);
        }
    }

}
