import java.util.Random;
import java.util.Scanner;

class Player extends gameCharacter {

    public Player() {
        super(50, 10, 5);
    }

    public void setStatus(int point) {
        // 플레이어의 초기 스탯을 설정하는 메서드
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(point + "만큼의 스테이터스를 추가합니다. 체력, 공격력, 마법력 순으로 입력하세요.\n(1 포인트 당 체력 = 3, 공격력 = 1, 마법력 = 1 증가)\n");
        System.out.println("플레이어의 기본 스탯은 체력: 50, 공격력: 10, 마법력: 5입니다.\n");

        while (true) {
            try {
                // 한 줄로, 공백을 구분자로 포인트 받기
                String input = sc.nextLine();
                String[] values = input.split(" ");

                int hpPoints = Integer.parseInt(values[0]);
                int adPoints = Integer.parseInt(values[1]);
                int apPoints = Integer.parseInt(values[2]);

                if (hpPoints + adPoints + apPoints == point) {
                    this.hp += hpPoints * 3;
                    this.ad += adPoints;
                    this.ap += apPoints;
                    System.out.println("체력: " + this.hp + ", 공격력: " + this.ad + ", 마법력: " + this.ap);
                    break;
                } else {
                    System.out.println("입력한 능력치의 총합이 " + point + "와 같아야 합니다. 다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("hp, ad, ap는 정수로 입력해야 합니다. 다시 입력해주세요.");
            }
        }
    }

    public void checkStatus(Enemy enemy) {
        // 플레이어와 적의 현재 상태를 출력합니다.
        System.out.println("현재 유저: 체력 " + this.hp + ", 공격력 " + this.ad + ", 마법력 " + this.ap);
        System.out.println("적: 체력 " + enemy.getHp() + ", 공격력 " + enemy.getAd() + ", 방어력 " + enemy.getAdDefence() + ", 마법방어력 " + enemy.getApDefence() + "\n");
        // 적에게 일반 공격을 가합니다.
        int damage = this.ad - enemy.getAdDefence();
        enemy.decreaseHp(damage);
        System.out.println("일반 공격으로 " + damage + " 의 데미지를 주었습니다. \n");
    }

    @Override
    public void basicAttack(Enemy enemy) {
        Random r = new Random();
        int criticalPoint = r.nextInt(10) + 1;
        // 랜덤으로 1부터 10 사이의 정수 생성
        // 원리: random.nextInt(10)으로 0부터 9까지 랜덤 정수 생성, 각각에 1씩 더하기
        int damage = Math.max(this.ad - enemy.getAdDefence(), 0);
        // 데미지가 음수가 되는 것을 막음

        // criticalPoint가 2보다 작은 경우 치명타가 발생했다고 간주
        if (criticalPoint <= 2) {
            damage *= 2;
            enemy.decreaseHp(damage);
            System.out.println("치명타가 적용되어 " + damage + " 의 데미지를 주었습니다.");
        } else {
            enemy.decreaseHp(damage);
            System.out.println("일반 공격으로 " + damage + " 의 데미지를 주었습니다.");
        }
    }

    public void magicAttack(Enemy enemy) {
        // 플레이어의 마공 * 2에서 적의 마방을 뺀 만큼 데미지 주기
        int damage = Math.max(this.ap * 2 - enemy.getApDefence(), 0);
        // 데미지가 음수가 되는 것을 막음
        enemy.decreaseHp(damage);
        System.out.println("마법 공격으로 " + damage + " 의 데미지를 주었습니다.");
    }

    @Override
    public void healSelf() {
        // 5에서 10 사이의 랜덤 정수를 생성해서 자힐합니다.
        Random r = new Random();
        int healPoint = r.nextInt(6) + 5;
        this.hp += healPoint;
        System.out.println("체력을 회복합니다. 현재 hp는 " + this.hp + " 입니다.");
    }

    @Override
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
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }



    }
}
