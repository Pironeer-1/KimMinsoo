package enemy;

import player.Player;

import java.util.*;

public class EnemyAction {

    private Enemy enemy;

    public EnemyAction(Enemy enemy) {
        this.enemy = enemy;
    }

    public void basicAttack(Player player, int playerIndex) {
        player.decreaseHp(enemy.getAd());
        System.out.println((playerIndex + 1) + " 번 플레이어에게 " + enemy.getAd() + " 만큼의 데미지. 적의 공격으로 현재 남은 체력은 " + player.getHp() + "입니다.");
    }

    public void healSelf() {
        int healingAmount = 7;
        enemy.heal(healingAmount);
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
}
