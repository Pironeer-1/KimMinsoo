package player;

import enemy.Enemy;

import java.util.Random;
import java.util.Scanner;
import static gameenums.GameEnums.*;

public class PlayerAction {

    private Player player;

    public PlayerAction(Player player, Scanner sc) {
        this.player = player;
    }

    public void checkStatus(Enemy enemy) {
        // 플레이어와 적의 현재 상태를 출력합니다.
        System.out.println("현재 유저: 체력 " + player.getHp() + ", 공격력 " + player.getAd() + ", 마법력 " + player.getAp());
        System.out.println("적: 체력 " + enemy.getHp() + ", 공격력 " + enemy.getAd() + ", 방어력 " + enemy.getAdDefence() + ", 마법방어력 " + enemy.getApDefence() + "\n");
        // 적에게 일반 공격을 가합니다.
        int damage = player.getAd() - enemy.getAdDefence();
        enemy.decreaseHp(damage);
        System.out.println("일반 공격으로 " + damage + " 의 데미지를 주었습니다. \n");
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
            System.out.println("치명타가 적용되어 " + damage + " 의 데미지를 주었습니다.");
        } else {
            enemy.decreaseHp(damage);
            System.out.println("일반 공격으로 " + damage + " 의 데미지를 주었습니다.");
        }
    }

    public void magicAttack(Enemy enemy) {
        // 플레이어의 마공 * 2에서 적의 마방을 뺀 만큼 데미지 주기
        int damage = Math.max(player.getAp() * PLAYER_MAGIC_ATTACK_MULTIPLIER.getValue() - enemy.getApDefence(), MIN_DAMAGE.getValue());
        // 데미지가 음수가 되는 것을 막음
        enemy.decreaseHp(damage);
        System.out.println("마법 공격으로 " + damage + " 의 데미지를 주었습니다.");
    }

    public void healSelf() {
        // 5에서 10 사이의 랜덤 정수를 생성해서 자힐합니다.
        Random r = new Random();
        int healPoint = r.nextInt(6) + 5;
        player.setHp(player.getHp() + healPoint);
        System.out.println("체력을 회복합니다. 현재 hp는 " + player.getHp() + " 입니다.");
    }

    public void attack(Enemy enemy, int playerIndex) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("------------------------------------------------------------------------------");
                System.out.println((playerIndex + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
                // 유저에게 1 ~ 4 중 입력 받기
                String inputKey = sc.nextLine();

                if (inputKey.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
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
                    System.out.println("1~4 사이의 정수를 입력해주세요.");
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
    }
}
