package player;

import enemy.Enemy;

import java.util.Random;
import java.util.Scanner;
import static gamefactors.GameEnums.*;
import static gamefactors.GameSentences.*;

public class PlayerAction {

    private Player player;

    public PlayerAction(Player player, Scanner sc) {
        this.player = player;
    }

    public void checkStatus(Enemy enemy) {
        // 플레이어와 적의 현재 상태를 출력합니다.
        int playerHp = player.getHp();
        int playerAd = player.getAd();
        int playerAp = player.getAp();

        int enemyHp = enemy.getHp();
        int enemyAd = enemy.getAd();
        int enemyAdDef = enemy.getAdDefence();
        int enemyApDef = enemy.getApDefence();

        printPlayerCurrentStatus(playerHp, playerAd, playerAp);
        printEnemyCurrentStatus(enemyHp, enemyAd, enemyAdDef, enemyApDef);

        // 적에게 일반 공격을 가합니다.
        int damage = player.getAd() - enemy.getAdDefence();
        enemy.decreaseHp(damage);
        playerDammageAnnounce(damage);
    }

    public void basicAttack(Enemy enemy) {
        Random r = new Random();
        int criticalPoint = r.nextInt(10) + 1;
        // 랜덤으로 1부터 10 사이의 정수 생성
        // 원리: random.nextInt(10)으로 0부터 9까지 랜덤 정수 생성, 각각에 1씩 더하기

        int damage = Math.max(player.getAd() - enemy.getAdDefence(), MIN_DAMAGE.getValue());
        // 데미지가 음수가 되는 것을 막음

        // criticalPoint가 2보다 작은 경우 치명타가 발생했다고 간주
        if (criticalPoint <= PLAYER_CRITICAL_RATE_POINT.getValue()) {
            damage *= CRITICAL_DAMMAGE_MULTIPLYER.getValue();
            enemy.decreaseHp(damage);
            playerCriticalAttackAnnounce(damage);
        } else {
            enemy.decreaseHp(damage);
            playerBasicAttackAnnounce(damage);
        }
    }

    public void magicAttack(Enemy enemy) {
        // 플레이어의 마공 * 2에서 적의 마방을 뺀 만큼 데미지 주기
        int damage = Math.max(player.getAp() * PLAYER_MAGIC_ATTACK_MULTIPLIER.getValue() - enemy.getApDefence(), MIN_DAMAGE.getValue());
        // 데미지가 음수가 되는 것을 막음
        enemy.decreaseHp(damage);
        playerMaginAttackAnnounce(damage);
    }

    public void healSelf() {
        // 5에서 10 사이의 랜덤 정수를 생성해서 자힐합니다.
        Random r = new Random();
        int healPoint = r.nextInt(6) + 5;
        player.setHp(player.getHp() + healPoint);
        int playerHp = player.getHp();
        playerHealingAnnounce(playerHp);
    }

    public void attack(Enemy enemy, int playerIndex) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                makeHorizon();
                playerChooseActionAnnounce(playerIndex);

                // 유저에게 1 ~ 4 중 입력 받기
                String inputKey = sc.nextLine();

                if (inputKey.equals("exit")) {
                    terminateProgram();
                    System.exit(0);
                }

                int action = Integer.parseInt(inputKey);

                if (action == 1) {
                    checkStatus(enemy);
                    break;
                } else if (action == 2) {
                    basicAttack(enemy);
                    break;
                } else if (action == 3) {
                    magicAttack(enemy);
                    break;
                } else if (action == 4) {
                    healSelf();
                    break;
                } else {
                    wrongIntegerInputAnnounce();
                }

            } catch (NumberFormatException e) {
                inputWithNumberAnnounce();
            }
        }
    }
}
