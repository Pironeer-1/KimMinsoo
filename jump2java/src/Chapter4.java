import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Chapter4 {
    public static void main(String[] args) {

        // if문

        boolean money = true;
        if (money) {
            System.out.println("부자네요~");
        } else {
            System.out.println("거지래요~");
        }

        // 조건문을 System.out.println()에 넣으면 불리언 형으로 리턴

        // contains 메서드
        // "만약 주머니에 돈이 있으면 택시를 타고, 없으면 걸어가"

        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("money");
        pocket.add("phone");
        pocket.add("cigarette");

        if (pocket.contains("money")) {
            System.out.println("택시타셈");
        } else {
            System.out.println("걸어가셈");
        }

        // else if
        // "돈이 있으면 택시를 타고, 돈이 없어도 카드가 있으면 택시를 타고, 둘 다 없으면 걸어가셈"

        boolean hasCard = true;

        ArrayList<String> pocket = new ArrayList<String>();
        pocket.add("money");
        pocket.add("phone");
        pocket.add("cigarette");

        if (pocket.contains("money")) {
            System.out.println("택시타셈");
        } else if(hasCard) {
            System.out.println("카드 있으니까 택시타셈");
        } else {
            System.out.println("걸어가셈");
        }

        // switch/case 문
        // month에 맞는 monthString을 출력하는 예제

        int month = 8;
        String monthString = "";
        switch (month) {  // 입력 변수의 자료형은 byte, short, char, int, enum, String만 가능

            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }
        System.out.println(monthString);

        // while문
        // "열 번 찍어 안 넘어가는 나무 없다"

        int treeHit = 0;
        while (treeHit < 10) {
            treeHit++;
            System.out.println("나무를 " + treeHit + "번 찍었습니다.");
            if (treeHit == 10) {
                System.out.println("나무 넘어가유~");
            }
        }

        // 무한 루프
        // while (true)

        while (true) {
            System.out.println("무량공처");
        }

        // while문 빠져나가기
        // break

        int coffee = 10;
        int money = 300;

        while (money > 0) {
            System.out.println("돈값하세요");
            coffee--;
            if (coffee == 0) {
                System.out.println("커피다떨어짐");
                break;
            }
        }

        // continue
        // while문의 맨 처음으로 돌아감

        int a = 0;
        while (a < 10) {
            a++;
            if (a % 2 == 0) {
                continue; // 짝수일 경우 처음으로 돌아감
            }
            System.out.println(a); // 홀수만 출력
        }

        // for 문

        String[] numbers = {"one", "two", "three"};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 5명의 학생의 점수를 받아서 60 이상이면 합격을 출력, 미만이면 불합격을 출력해보세요

        int[] scores = {90, 25, 67, 45, 80};
        for(int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                System.out.println(String.format("%d번 학생은 불합격", (i + 1)));
            } else {
                System.out.println(String.format("%d번 학생은 합격", (i + 1)));
            }
        }

        // continue
        // for문 맨 앞으로 돌아가기

        int[] marks = {90, 25, 67, 45, 80};
        for(int i=0; i<marks.length; i++) {
            if (marks[i] < 60) {
                continue;  // 맨 앞으로 돌아감
            }
            System.out.println(String.format("%d번 학생 축하합니다. 합격입니다.", (i + 1)));
        }

        // 이중 for 문
        // 구구단 출력은 국룰이제

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(String.format("%d * %d = %d", i, j, i * j));
            }
            System.out.println(""); // 줄 바꿈
        }

        // for each 문
        // 비슷한데 약간 달라요
        // python에서 for case in cases 같은 느낌?

        String[] numbers = {"one", "two", "three"};
        for(String number: numbers) { // numbers 부분은 iterate(반복 가능)한 객체, 때문에 배열이나 리스트, 집합 등만 가능
            System.out.println(number);
        }

        ArrayList<String> numbers2 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        for (String number : numbers2) {
            System.out.println(number);
        }














    }

}


