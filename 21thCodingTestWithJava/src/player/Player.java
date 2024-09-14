package player;

import gamecharacter.GameCharacter;
import java.util.Scanner;
import static gamefactors.GameEnums.*;
import static gamefactors.GameSentences.*;

public class Player extends GameCharacter {

    public Player() {
        super(PLAYER_INITIAL_HP.getValue(), PLAYER_INITIAL_AD.getValue(), PLAYER_INITIAL_AP.getValue());
    }

    public void setStatus(int point, Scanner sc) {
        // 플레이어의 초기 스탯을 설정하는 메서드

        makeHorizon();
        playerStatusSetAnnounce(point);
        playerBasicStatusAnnounce();

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

                    int playerHp = this.hp;
                    int playerAd = this.ad;
                    int playerAp = this.ap;

                    playerFinalStatusAnnounce(playerHp, playerAd, playerAp);
                    break;
                } else {
                    totalStatusWrongAnnounce(point);
                }
            } catch (Exception e) {
                wrongStatusInputAnnounce();
            }
        }
    }
}
