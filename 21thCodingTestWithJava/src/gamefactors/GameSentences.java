package gamefactors;

public class GameSentences {
    // Enemy
    public static void enemyRecoveryButFullHp() {
        System.out.println("적이 회복했지만 적은 이미 최대 체력입니다.");
    }

    public static void enemyRecovery(int hp) {
        System.out.println("적의 회복으로 현재 적의 체력은 " + hp + " 입니다.");
    }

    public static void enemyAttackAnnounce(int playerIndex, int enemyDamage, int playerHp) {
        System.out.println((playerIndex + 1) + " 번 플레이어에게 " + enemyDamage + " 만큼의 데미지. 적의 공격으로 현재 남은 체력은 " + playerHp + "입니다.\n");
    }

    public static void enemyTurnAnnounce() {
        System.out.println("적의 차례입니다. \n");
    }

    public static void enemyStunAnnounce() {
        System.out.println("적은 섣불리 움직이지 못하고 있습니다.");
    }

    // Game
    public static void playerRemainAnnounce(int remainPlayer) {
        System.out.println("남은 플레이어: " + remainPlayer + "명");
    }

    public static void victoryAnnounce() {
        System.out.println("축하합니다! 승리하셨습니다.");
    }

    public static void defeatAnnounce() {
        System.out.println("아쉽지만 패배하셨습니다.");
    }

    public static void setPlayerNumberAnnounce() {
        System.out.print("플레이어 인원을 정하세요: ");
    }

    public static void minPlayerNumErrorAnnounce(){
        System.out.println("플레이어 인원은 1 이상이어야 합니다.");

    }


    // Player
    public static void playerStatusSetAnnounce(int point){
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요.\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
    }

    public static void playerBasicStatusAnnounce(){
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");
    }

    public static void playerFinalStatusAnnounce(int playerHp, int playerAd, int playerAp) {
        System.out.println("최종 설정된 스탯 - 체력: " + playerHp + ", 공격력: " + playerAd + ", 마법력: " + playerAp);
    }

    public static void totalStatusWrongAnnounce(int point){
        System.out.println("입력한 능력치의 총합이 " + point + " 와 같아야 합니다. 다시 입력해주세요.");
    }

    public static void wrongStatusInputAnnounce(){
        System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
    }

    public static void printPlayerCurrentStatus(int playerHp, int playerAd, int playerAp) {
        System.out.println("현재 유저: 체력 " + playerHp + ", 공격력 " + playerAd + ", 마법력 " + playerAp);

    }
    public static void printEnemyCurrentStatus(int enemyHp, int enemyAd, int enemyAdDef, int enemyApDef) {
        System.out.println("적: 체력 " + enemyHp + ", 공격력 " + enemyAd + ", 방어력 " + enemyAdDef + ", 마법방어력 " + enemyApDef + "\n");
    }

    public static void playerDammageAnnounce(int damage){
        System.out.println("일반 공격으로 " + damage + " 의 데미지를 주었습니다. \n");
    }

    public static void playerCriticalAttackAnnounce(int damage) {
        System.out.println("치명타가 적용되어 " + damage + " 의 데미지를 주었습니다.");
    }

    public static void playerBasicAttackAnnounce(int damage){
        System.out.println("일반 공격으로 " + damage + " 의 데미지를 주었습니다.");
    }

    public static void playerMaginAttackAnnounce(int damage){
        System.out.println("마법 공격으로 " + damage + " 의 데미지를 주었습니다.");
    }

    public static void playerHealingAnnounce(int playerHp) {
        System.out.println("체력을 회복합니다. 현재 hp는 " + playerHp + " 입니다.");

    }

    public static void playerChooseActionAnnounce(int playerIndex) {
        System.out.println((playerIndex + 1) + "번 플레이어의 차례입니다. 행동을 선택하세요. (1: 스테이터스 확인 + 일반 공격, 2: 기본 공격, 3: 마법 공격, 4: 체력 회복, exit: 종료)");
    }

    public static void wrongIntegerInputAnnounce(){
        System.out.println("1~4 사이의 정수를 입력해주세요.");
    }


    // Public
    public static void makeHorizon() {
        System.out.println("------------------------------------------------------------------------------");
    }

    public static void terminateProgram() {
        System.out.println("프로그램을 종료합니다.");
    }

    public static void inputWithNumberAnnounce(){
        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
    }



}
