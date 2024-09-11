package gamecharacter;

import enemy.Enemy;
import player.Player;

public abstract class GameCharacter {
    protected int hp;
    protected int ad;
    protected int ap;
    protected int maxHp;

    public GameCharacter(int hp, int ad, int ap) {
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
        this.maxHp = hp;

    }

    // 체력 감소 메서드
    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    public int getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
