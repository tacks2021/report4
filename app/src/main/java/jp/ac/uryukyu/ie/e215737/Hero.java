package jp.ac.uryukyu.ie.e215737;

public class Hero extends LivingThing{
    
    public Hero(String name, int maximumHP, int attack){
        super(name, maximumHP, attack);
    }

    public int getHitPoint(){
        return this.hitPoint ;
    }

    @Override
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}