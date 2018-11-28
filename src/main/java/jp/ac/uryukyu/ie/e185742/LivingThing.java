package jp.ac.uryukyu.ie.e185742;

/**
 * キャラクタの生死や攻撃を司るクラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
    }

    public String getName(){
        return name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public int getAttack(){
        return attack;
    }

    public boolean isDead() {
        return dead;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * キャラクターの攻撃を司るメソッド。
     * @param opponent 攻撃したいキャラクターのオブジェクト渡す。
     */
    public void attack(LivingThing opponent){
        if(dead != true){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }

    }

    /**
     * 攻撃された時のダメージを処理するメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ。
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
