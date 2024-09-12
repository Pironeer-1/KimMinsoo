package player;

import gamecharacter.GameCharacter;
import java.util.Scanner;
import static gameenums.GameEnums.*;

public class Player extends GameCharacter {

    public Player() {
        super(PLAYER_INITIAL_HP.getValue(), PLAYER_INITIAL_AD.getValue(), PLAYER_INITIAL_AP.getValue());
    }

    public void setStatus(int point, Scanner sc) {
        // 플레이어의 초기 스탯을 설정하는 메서드
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요.\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while (true) {
            try {
                // 한 줄로, 공백을 구분자로 포인트 받기

                String input = sc.nextLine();
                String[] values = input.split(" ");

                int hpPoints = Integer.parseInt(values[0]);
                int adPoints = Integer.parseInt(values[1]);
                int apPoints = Integer.parseInt(values[2]);

                if (hpPoints + adPoints + apPoints == point) {
                    this.hp += hpPoints * PLAYER_HP_MULTIPLYER.getValue();
                    this.ad += adPoints * PLAYER_AD_MULTIPLYER.getValue();
                    this.ap += apPoints * PLAYER_AP_MULTIPLYER.getValue();
                    System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
                    break;
                } else {
                    System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
            }
        }
    }
}
