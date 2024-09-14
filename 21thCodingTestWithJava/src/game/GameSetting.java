package game;

import enemy.Enemy;
import player.Player;

import static gamefactors.GameEnums.*;
import static gamefactors.GameSentences.*;

import java.util.*;

public class GameSetting {
    private int statusPoint = PLAYER_INITIAL_STATUS_POINT.getValue();
    private List<Player> playersList = new ArrayList<>();
    private Enemy enemy;

    public GameSetting(Scanner sc) {
    }

    public void setPlayers(Scanner sc) {
        while (true) {
            try {
                setPlayerNumberAnnounce();
                String input = sc.nextLine();
                int listNum = Integer.parseInt(input);

                if (listNum <= 0) {
                    minPlayerNumErrorAnnounce();
                    continue;
                }
                for (int i = 0; i < listNum; i++) {
                    Player player = new Player();
                    player.setStatus(this.statusPoint, sc);
                    playersList.add(player);
                }
                break;
            } catch (NumberFormatException e) {
                inputWithNumberAnnounce();
                sc.nextLine();
            }
        }
    }

    public void setEnemy() {
        this.enemy = new Enemy(playersList.size());
    }

    public boolean turnCheck() {
        // 각 플레이어에 대해 반복하면서 플레이어의 체력이 0 이하인 경우 해당 플레이어의 인덱스 제거
        playersList.removeIf(player -> player.getHp() <= MIN_HP.getValue());

        if (playersList.isEmpty()) {
            return false;
        }

        if (this.enemy.getHp() <= MIN_HP.getValue()) {
            return false;
        }
        return true;
    }

    public Player selectTargetPlayer() {
        // 남은 플레이어들 중 무작위로 하나를 선택해서 반환해주기!
        Random r = new Random();
        return playersList.get(r.nextInt(playersList.size()));
    }

    public List<Player> getPlayersList() {
        return playersList;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
