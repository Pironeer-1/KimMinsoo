import java.util.Random;

class Enemy {

    // 적 스탯 변수 선언
    private int maxHp;
    private int hp;
    private int ad;
    private int adDefence;
    private int apDefence;

    public Enemy(int listNum) { // 적의 스탯을 초기화하는 생성자
        this.maxHp = 100 * listNum;
        this.hp = 100 * listNum;
        this.ad = 25;
        this.adDefence = 7;
        this.apDefence = 7;
    }

    public void decreaseHp(int damage) {
        this.hp = Math.max(this.hp - damage, 0);
    }

    public void basicAttack(Player player, int playerIndex) {
        player.decreaseHp(this.ad);
        System.out.println((playerIndex + 1) + " 번 플레이어에게 " + this.ad + " 만큼의 데미지. 적의 공격으로 현재 남은 체력은 " + player.getHp() + "입니다.");
    }

    public void healSelf() {
        int healingAmount = 7;
        if (this.maxHp <= this.hp + healingAmount) {
            System.out.println("적은 이미 최대 체력입니다.");
        } else {
            this.hp += healingAmount;
            System.out.println("적의 회복으로 현재 적의 체력은 " + this.hp + " 입니다.");
        }
    }

    public void attack(Player player, int playerIndex) {
        Random r = new Random();
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("적의 차례입니다.\n");
        int enemyAction = r.nextInt(10) + 1;

        if (enemyAction == 1) {
            System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
        } else if (2 <= enemyAction && enemyAction <= 8) {
            this.basicAttack(player, playerIndex);
        } else {
            this.healSelf();
        }
    }

    public int getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    public int getAdDefence() {
        return adDefence;
    }

    public int getApDefence() {
        return apDefence;
    }
}
