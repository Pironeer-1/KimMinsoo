package enemy;

import gamecharacter.GameCharacter;
import static gameenums.GameEnums.*;
// 이런 식으로 Enum 안의 스태틱 필드나 메서드들을 한번에 가져오면 코드를 더 간략하게 작성 가능
// 다만 Enum이 여러 개일 경우 어느 곳에 소속된 상수값인지 헷갈릴 수 있음

public class Enemy extends GameCharacter {

    // 적 스탯 변수 선언
    private int maxHp;
    private int adDefence;
    private int apDefence;

    public Enemy(int listNum) { // 적의 스탯을 초기화하는 생성자
        super(ENEMY_INITIAL_HP.getValue() * listNum, ENEMY_INITIAL_AD.getValue(), ENEMY_INITIAL_AP.getValue());
        this.maxHp = ENEMY_INITIAL_HP.getValue() * listNum; // 최대 체력 재할당
        this.adDefence = ENEMY_INITIAL_AD_DEFENCE.getValue();
        this.apDefence = ENEMY_INITIAL_AP_DEFENCE.getValue();
    }

    public void heal(int healingAmount) {
        if (this.maxHp <= this.hp + ENEMY_HEALING_AMOUNT.getValue()) {
            this.hp = this.maxHp;
            System.out.println("적이 회복했지만 적은 이미 최대 체력입니다.");
        } else {
            this.hp += ENEMY_HEALING_AMOUNT.getValue();
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
