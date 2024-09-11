package enemy;

import gamecharacter.GameCharacter;

public class Enemy extends GameCharacter {

    // 적 스탯 변수 선언
    private int maxHp;
    private int adDefence;
    private int apDefence;

    public Enemy(int listNum) { // 적의 스탯을 초기화하는 생성자
        super(100 * listNum, 25, 0); // gameCharacter에 있는 부분
        this.maxHp = 100 * listNum; // 최대 체력 재할당
        this.adDefence = 7;
        this.apDefence = 7;
    }

    public void heal(int healingAmount) {
        if (this.maxHp <= this.hp + healingAmount) {
            this.hp = this.maxHp;
            System.out.println("적이 회복했지만 적은 이미 최대 체력입니다.");
        } else {
            this.hp += healingAmount;
            System.out.println("적의 회복으로 현재 적의 체력은 " + this.hp + " 입니다.");
        }
    }

    public int getAdDefence() {
        return adDefence;
    }

    public int getApDefence() {
        return apDefence;
    }

}
