import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Game {
    private int statusPoint = 13;
    private List<Player> playersList = new ArrayList<>();
    private Enemy enemy;

    public void setPlayers() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("플레이어 인원을 정하세요: ");
                int listNum = sc.nextInt();
                if (listNum <= 0) {
                    System.out.println("플레이어 인원은 1 이상이어야 합니다.");
                    continue;
                }
                for (int i = 0; i < listNum; i++) {
                    Player player = new Player();
                    player.setStatus(this.statusPoint);
                    playersList.add(player);
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.next();
            }
        }
    }

    public void setEnemy() {
        this.enemy = new Enemy(playersList.size());
    }

    public boolean turnCheck() {
        // 각 플레이어에 대해 반복하면서 플레이어의 체력이 0 이하인 경우 해당 플레이어의 인덱스 제거
        playersList.removeIf(player -> player.getHp() <= 0);

        if (playersList.isEmpty()) {
            return false;
        }

        if (this.enemy.getHp() <= 0) {
          return false;
        }
        return true;
    }

    public Player selectTargetPlayer() {
        // 남은 플레이어들 중 무작위로 하나를 선택해서 반환해주기!
        Random r = new Random();
        return playersList.get(r.nextInt(playersList.size()));
    }

    public void game() {
        this.setPlayers();
        this.setEnemy();

        while (this.turnCheck()) {
            for (int playerIndex = 0; playerIndex < playersList.size(); playerIndex++) {
                Player player = playersList.get(playerIndex);
                System.out.println(playersList.size());
                player.attack(enemy, playerIndex);
                if (enemy.getHp() == 0) {
                    break;
                }
            }
            if (this.turnCheck()) {
               Player targetPlayer = this.selectTargetPlayer();
               int targetIndex = playersList.indexOf(targetPlayer);
               this.enemy.attack(targetPlayer, targetIndex);

            } else {
                break;
            }
        }
        if (this.enemy.getHp() <= 0) {
            System.out.println("축하합니다! 승리하셨습니다.");
        } else {
            System.out.println("아쉽지만 패배하셨습니다.");
        }
    }
}
