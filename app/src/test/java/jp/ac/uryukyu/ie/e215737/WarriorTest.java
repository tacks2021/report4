package jp.ac.uryukyu.ie.e215737;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {
    /**
     * Warriorクラスからオブジェクトを生成し、attackWithWeponSkillを3回実行し、3回ともattackの150%ダメージになっていることを検証。
     * 検証手順
     *  (1)戦士と敵を準備。ヒーロー（戦士）の攻撃力は敵を3回攻撃して倒せる状態。
     *  (2) ヒーロー（戦士）が攻撃し、敵は攻撃。敵は2回目の攻撃まで耐え、３回の攻撃で倒されていることを期待。
     *  (3) ３回攻撃を繰り返すとスライムが死ぬ。
     * 　　つまり３回攻撃を攻撃を実行することを期待。これを検証する。
     */
    @Test
    void attackTest(){
        int defaultWarriorHp = 100;
        Warrior demoWarrior = new Warrior("デモ戦士", 100, defaultWarriorHp);
        Enemy slime = new Enemy("スライムもどき", 450, 3);
        int i = 0;
        for(; i < 3; i++){
            int Hp = slime.hitPoint;
            demoWarrior.attackWithWeaponSkill(slime);
            assertEquals(defaultWarriorHp * 1.5, Hp - slime.hitPoint); 
        }
        
    }
}
