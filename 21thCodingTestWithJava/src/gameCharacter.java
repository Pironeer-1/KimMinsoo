public abstract class gameCharacter {
    protected int hp;
    protected int ad;
    protected int ap;
    protected int maxHp;

    public gameCharacter(int hp, int ad, int ap) {
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
        this.maxHp = hp;

    }

    // 체력 감소 메서드
    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    // 체력 회복은 클래스마다 다르게 구현해야 하므로 추상 메서드로 선언
    public abstract void healSelf();

    // 적의 공격 메서드
    public void attack(Player player, int playerIndex) {

    }

    // 플레이어의 공격 메서드
    public void attack(Enemy enemy, int playerIndex) {

    }

    // 플레이어의 평타
    public void basicAttack(Enemy enemy) {

    }

    // 적의 평타
    public void basicAttack(Player player, int playerIndex) {

    }

    public int getHp() {
        return this.hp;
    }

    public int getAd() {
        return ad;
    }
}
