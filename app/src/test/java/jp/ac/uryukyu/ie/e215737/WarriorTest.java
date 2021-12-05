package jp.ac.uryukyu.ie.e215737;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {
    /**
     * Warriorクラスからオブジェクトを生成し、attackWithWeponSkillを3回実行し、3回ともattackの150%ダメージになっていることを検証。
     * 検証手順
     *  (1)戦士と敵を準備。ヒーロー（戦士）の攻撃力は敵を3回攻撃すると倒せる状態。
     *  (2) ヒーロー（戦士）が攻撃し、敵は攻撃。敵は2回目の攻撃まで耐え、３回の攻撃で倒されていることを期待。
     *  (3) ３回攻撃を繰り返すとスライムが死ぬ。
     * 　　つまり３回攻撃を攻撃を実行することを期待。これを検証する。
     */
    @Test
    void attackTest(){
        int defaultWarriorHp = 100;
        Warrior demoWarrior = new Warrior("デモ戦士", defaultWarriorHp, 100);
        Enemy big_slime = new Enemy("でかいスライムもどき", 450, 100);
        int i = 0;
        for(; i < 3; i++){
            demoWarrior.attackWithWeaponSkill(big_slime);
            int reduce_hp = 450 - big_slime.getHitPoint();
            System.out.printf("%s", big_slime.getName() + "の残りHP" + (450 - reduce_hp));
            
        }
        assertEquals(defaultWarriorHp, demoWarrior.getHitPoint());
    }
}
