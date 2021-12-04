package jp.ac.uryukyu.ie.e215737;

 public class Enemy extends LivingThing{

    public Enemy (String name, int maximumHP, int attack){
        super(name, maximumHP, attack);
    }

    public int getHitPoint(){
        return this.hitPoint;
    }
    
    @Override
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
}