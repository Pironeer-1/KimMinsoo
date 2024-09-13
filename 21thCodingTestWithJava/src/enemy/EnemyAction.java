package enemy;

import player.Player;
import java.util.*;

import static gamefactors.GameEnums.*;
import static gamefactors.GameSentences.*;

public class EnemyAction {

    private Enemy enemy;

    public EnemyAction(Enemy enemy) {
        this.enemy = enemy;
    }

    public void basicAttack(Player player, int playerIndex) {
        player.decreaseHp(enemy.getAd());
        int enemyDamage = enemy.getAd();
        int playerHp = player.getHp();
        enemyAttackAnnounce(playerIndex, enemyDamage, playerHp);
    }

    public void healSelf() {
        int healingAmount = ENEMY_HEALING_AMOUNT.getValue();
        enemy.heal(healingAmount);
    }

    public void attack(Player player, int playerIndex) {
        Random r = new Random();
        makeHorizon();
        enemyTurnAnnounce();
        int enemyAction = r.nextInt(10) + 1;

        if (enemyAction == ENEMY_STUN.getValue()) {
            enemyStunAnnounce();
        } else if (ENEMY_ATTACK_START_POINT.getValue() <= enemyAction && enemyAction <= ENEMY_ATTACK_END_POINT.getValue()) {
            this.basicAttack(player, playerIndex);
        } else {
            this.healSelf();
        }
    }
}
