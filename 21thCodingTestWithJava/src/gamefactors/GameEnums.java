package gamefactors;

public enum GameEnums {
    // PLAYERS
    PLAYER_INITIAL_STATUS_POINT(13),
    PLAYER_INITIAL_HP(50),
    PLAYER_INITIAL_AD(10),
    PLAYER_INITIAL_AP(5),
    PLAYER_CRITICAL_RATE_POINT(2),
    PLAYER_MAGIC_ATTACK_MULTIPLIER(2),
    PLAYER_HP_MULTIPLYER(3),
    PLAYER_AD_MULTIPLYER(1),
    PLAYER_AP_MULTIPLYER(1),
    CRITICAL_DAMMAGE_MULTIPLYER(2),


    // ENEMYS
    ENEMY_INITIAL_HP(100),
    ENEMY_INITIAL_AD(25),
    ENEMY_INITIAL_AP(0),
    ENEMY_INITIAL_AD_DEFENCE(7),
    ENEMY_INITIAL_AP_DEFENCE(7),
    ENEMY_HEALING_AMOUNT(7),
    ENEMY_STUN(1),
    ENEMY_ATTACK_START_POINT(2),
    ENEMY_ATTACK_END_POINT(8),


    // PUBLIC
    MIN_HP(0),
    MIN_DAMAGE(0);

    private final int value;

    GameEnums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
