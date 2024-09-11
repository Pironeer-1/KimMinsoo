package game;

import enemy.Enemy;
import enemy.EnemyAction;
import player.Player;
import player.PlayerAction;

import java.util.Scanner;

public class Game {

    private GameSetting gameSetting;
    private Enemy enemy;
    private Scanner sc;
    private PlayerAction playerAction;
    private EnemyAction enemyAction;

    public Game () {
        this.sc = new Scanner(System.in);
        this.gameSetting = new GameSetting(sc);
    }

    // 게임 종료 시 스캐너를 닫는 메서드
    public void closeScanner() {
        if(sc != null) {
            sc.close();
        }
    }

    public void game() {

        gameSetting.setPlayers(sc);
        gameSetting.setEnemy();

        this.enemy = gameSetting.getEnemy();
        this.enemyAction = new EnemyAction(enemy);

        while (gameSetting.turnCheck()) {
            for (int playerIndex = 0; playerIndex < gameSetting.getPlayersList().size(); playerIndex++) {
                Player player = gameSetting.getPlayersList().get(playerIndex);
                this.playerAction = new PlayerAction(player, sc);
                System.out.println("남은 플레이어: " + gameSetting.getPlayersList().size() + "명");
                playerAction.attack(enemy, playerIndex);
                if (enemy.getHp() == 0) {
                    break;
                }
            }
            if (gameSetting.turnCheck()) {
               Player targetPlayer = gameSetting.selectTargetPlayer();
               int targetIndex = gameSetting.getPlayersList().indexOf(targetPlayer);
               enemyAction.attack(targetPlayer, targetIndex);

            } else {
                break;
            }
        }
        if (this.enemy.getHp() <= 0) {
            System.out.println("축하합니다! 승리하셨습니다.");
            closeScanner();
        } else {
            System.out.println("아쉽지만 패배하셨습니다.");
            closeScanner();
        }
    }

}
