import java.util.*;

public class Chapter3 {
    public static void main(String[] args) {

        // 정수
        int age = 10;
        long countOfStar = 8764827384923849L;
        // long 자료형일 때 int 최댓값인 2147483647보다 크면 접미사 L을 붙여준다!

        // 실수

        float pi = 3.14F;
        double morePi = 3.14159265358979323846;

        // float 변수형에 값을 대입할 땐 접미사 F! double은 ㄱㅊ

        double d1 = 123.4;
        double d2 = 1.234e2;
        // 지수 표현식 방법. e2 = 10^2를 뜻한다. -> 1.234 * 10^2

        // 8진수와 16진수
        int octal = 023; // 19
        int hex = 0xC3; // 195

        // 숫자 연산
        int a = 10;
        int b = 5;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);

        System.out.println(7 % 3);
        System.out.println(3 % 7);

        // 증감 연산

        int i = 0;
        int j = 10;
        i++;
        j--;

        System.out.println(i);
        System.out.println(j);

        System.out.println(i++); // 출력된 후 1 더해짐
        System.out.println(i);

        // 불
        boolean isSuccess = true;
        boolean isTest = false;

        // 불 연산

        2 > 1 // 참
        1 == 2 // 거짓
        3 % 2 == 1 // 참
        "3".equals("2"); // 거짓

        // 불 연산 사용례 - 조건문

        int base = 180;
        int height = 185;
        boolean isTall = height > base;

        if (isTall) {
            System.out.println("키가 큽니다.");
        }

        int i = 3;
        boolean isOdd = i % 2 == 1;
        System.out.println(isOdd); // true 출력

        // 문자

        char a1 = 'a';
        char a2 = 97; // 아스키 코드
        char a3 = '\u0061'; // 유니코드

        //셋 다 a 출력
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        //문자열
        String s1 = "Happy Java"; // 리터럴 방식. 디폴트.
        String s2 = new String("Happy Java"); //new 키워드는 객체를 만들 때 사용 (항상 새로운 String 객체를 만듦)

        //원시 자료형 -> 리터럴 방식으로만 값을 세팅 가능
        boolean result = true;
        char a = 'A';
        int i = 100000;
        // String은 원시 자료형이 아니지만 리터럴 방식을 사용할 수 있는 것임!!

        //Wrapper 클래스라는 것도 있는데, 나중에 멀티스레드 환경에서 동기화 지원에 필요하다고 함,,,

        // 문자열 내장 메서드
        //  equals
        String a = "hello";
        String b = "Java";
        String c = "hello";
        System.out.println(a.equals(b)); //false
        System.out.println(a.equals(c)); //true

        // 문자열의 값을 비교할 때는 반드시 equals 메서드를 사용해야 한다!!
        String a = "hello";
        String b = new String("hello");
        System.out.println(a.equals(b));  // true
        System.out.println(a == b);  // false
        // '==' 은 2개의 자료형이 같은 '객체'인지 판별하는 연산자이므로 false를 리턴하는 것

        // indexOf
        // 특정 문자열이 시작되는 위치(인덱스값)를 리턴
        String a = "Hello Java";
        System.out.println(a.indexOf("Java")); // 6을 출력

        // contains
        // 특정 문자열이 포함되는지 확인

        String a = "Hello Java";
        System.out.println(a.contains("Java")); // true

        // charAt
        // 특정 위치의 문자를 리턴
        String a = "Hello Java";
        System.out.println(a.charAt(6)); // "J" 출력

        // replaceAll
        // 특정 문자열을 다른 문자열로 바꿀때 사용
        String a = "Hello Java";
        System.out.println(a.replaceAll("Java", "World")); // Hello World 출력

        // substring
        // 특정 문자열을 뽑아낼 때 사용
        String a = "Hello java";
        System.out.println(a.substring(0, 4)); // Hell 출력
        // 시작 위치와 끝 위치는 다음과 같다. 0 <= a < 4

        // toUpperCase
        // 문자열을 모두 대문자로 변경할 때 사용
        String a = "Hello java";
        System.out.println(a.toUpperCase()); // HELLO JAVA

        // split
        // 문자열을 특정한 구분자로 나누어 문자열 '배열'로 리턴
        String a = "a:b:c:d";
        String[] result = a.split(":"); // result == {"a", "b", "c", "d"}

        // 문자열 포매팅
        // 문자열 안의 특정한 값을 바꿀 수 있게 해주는 것

        System.out.println(String.format("I eat %d apples.", 3)); // I eat 3 apples.
        System.out.println(String.format("I eat %s apples.", "five")); // I eat five apples.

        int number = 3;
        System.out.println(String.format("I ear %d apples.", number)); // I eat 3 apples.

        int number = 10;
        String day = "three";
        System.out.println(String.format("I ate %d apples, so I was sick for %s days.", number, day));
        // I ate 10 apples, so I was sick for three days.

        // 문자열 포맷 코드 여러 개 있음 -> 지금 외우지 말자
        // %s는 만능이다! 자동으로 전달되는 인자 값을 문자열로 바꾸어 사용하기 때문이란다.

        System.out.println(String.format("I have %s apples.", 3));
        System.out.println(String.format("rate is %s.", "3.234"));
        // 생각한 대로 출력이 잘 된다.

        // 문자열 포맷 코드가 있을 때, 특수문자 %를 나타내려면 %% 이렇게 써줘야 한다.
        System.out.println(String.format("%d%% Loading...", 98)); // 98% Loading...

        // 문자열 포맷팅 응용
        // 정렬과 공백 표현
        System.out.println(String.format("%10s", "hi"));
        // 전체 길이가 10인 문자열 공간에서 hi를 오른쪽 정렬하고, 나머지를 공백으로 채움

        System.out.println(String.format("&-10s", "hi"));
        // 전체 길이가 10인 문자열 공간에서 hi를 왼쪽 정렬하고, 나머지를 공백으로 채움

        // 소수점 표현
        System.out.println(String.format("%.4f", 3.42134234)); // 3.4213
        // 소수점 뒤 4번째 숫자까지 출력

        //System.out.printf
        //String.format 메서드가 없어도 같은 형식으로 포매팅된 문자열 출력 가능
        System.out.printf("I eat %d apples.", 3); // I eat 3 apples.

        //String.format은 문자열을 리턴(즉 문자열을 하나 만들어 저장한다)하는 메서드이고, System.out.printf는 문자열을 바로 출력하는 메서드이다.


        // StringBuffer
        // 문자열을 추가하거나 변경할 때 주로 사용

        // append
        // StringBuffer 객체를 생성하고 문자열을 생성하는 예제

        StringBuffer sb = new StringBuffer(); // 새로운 StringBuffer 객체 생성
        sb.append("hello");
        sb.append(" ");
        sb.append("jump to java");
        String result = sb.toString(); //toString 메서드를 통해 StringBuffer를 String으로 변경
        System.out.println(result);

        // StringBuffer를 사용하지 않는 경우
        String result = "";
        result += "hello";
        result += " ";
        result += "jump to java";
        System.out.println(result);  // "hello jump to java" 출력

        // 이렇게 해도 출력값은 똑같지만, + 연산이 있을 때마다 새로운 String 객체를 생성하기 때문에 총 4개의 String이 만들어짐
        // 이유는 String이 불변형 객체이기 때문. 한번 만들어지면 수정이 안되는 것이다.

        // StringBuffer와 비슷한 자료형으로 StringBulider가 있는데, 각자의 장점이 있다. 버퍼는 멀티스레드에서 굿, 빌더는 기본적인 성능이 우수

        // insert
        // 특정 위치에 원하는 문자열 삽입

        StringBuffer sb = new StringBuffer();
        sb.append("jump to java");
        sb.insert(0, "hello");
        System.out.println(sb.toString()); // hello jump to java

        // substring
        // String 자료형의 substring과 동일하게 동작

        // 배열
        int[] odds = {1, 3, 5, 7, 9};
        String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
        // 배열이랑 자료형이 아닌, 자료형의 집합을 뜻한다

        // 배열의 길이 설정 (초깃값 없이 배열을 만들 때는 길이를 명시적으로 넣어줘야 한다)
        String[] weeks = new String[7]; // 7칸짜리 배열이란 뜻
        weeks[0] = "월";
        weeks[1] = "화";
        weeks[2] = "수";
        weeks[3] = "목";
        weeks[4] = "금";
        weeks[5] = "토";
        weeks[6] = "일";

        // 배열값에 접근하기
        String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
        System.out.println(weeks[3]); // 목

        // 배열의 길이 구하기 배열이름.length
        String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};
        for (int i = 0; i < weeks.length; i++) {
            System.out.println(weeks[i]);
        }

        // 리스트
        // 배열과 달리 리스트는 크기가 변한다

        // ArrayList
        // 맨 위에 import java.util.ArrayList 작성 필수

        // add

        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");

        pitches.add(0, "134"); // 0번 인덱스에 값을 삽입하고 싶을 때~

        // get
        // 특정 인덱스 값을 가져옴

        System.out.println(pitches.get(1)); // 1번 인덱스 값을 출력

        // size
        // ArrayList의 요소 개수를 리턴

        System.out.println(pitches.size()); // 3

        // contains
        // 특정 항목이 리스트 안에 있는지, boolean return

        System.out.println(pitches.contains("138")); // true

        // remove

        System.out.println(pitches.remove("138")); // 138을 삭제 후 true를 리턴

        System.out.println(pitches.remove(0)); // 0번 인덱스 항목을 삭제 후, 그 항목을 리턴

        // 제네릭스
        // 자료형에 구체적인 언지를 주는 것

        ArrayList<String> pitches = new ArrayList(); // pitches 리스트에는 String 자료형만 들어갈 수 있슴

        // 제네릭스를 사용하지 않으면 리스트에 추가하는 객체는 object가 됨
        // 이러면 값을 가져올 때마다 형 변환을 해줘야 돼서 번거롭당
        // 제네릭스를 사용하면 형 변환 오류도 막아준당 개꿀


        // 다양한 방법으로 리스트 만들기
        // add로 객체 추가하기

        ArrayList<String> pitches = new ArrayList<>(); // 제네릭스 문법
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");
        System.out.println(pitches); // [138, 129, 142]

        // 이미 배열이 있는 경우 더 쉽다
        String[] data = {"138", "129", "142"};
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList(data)); // 배열을 리스트로 만드는 메서드
        System.out.println(pitches);

        // String 자료형을 여러 개 전달하여 생성할 수도 있슴
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
        System.out.println(pitches);

        // String.join
        // 리스트의 각 요소 사이사이에 구분자를 끼워 넣을 때 쓰는 기능
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
        String result = String.join(",", pitches);
        System.out.println(result); // 138,129,142

        // 문자열 배열에도 사용할 수 있다.
        ArrayList<String> pitches = new String[] {"138", "129", "142"};
        String result = String.join(",", pitches);
        System.out.println(result); // 138,129,142

        // 리스트 정렬하기
        ArrayList<String> pitches = new ArrayList<>(Arrays.asList("138", "129", "142"));
        pitches.sort(Comparator.naturalOrder()); // 오름차순으로 정렬
        System.out.println(pitches); // [129, 138, 142]
        pitches.sort(Comparator.reverseOrder()); // 내림차순으로 정렬
        System.out.println(pitches); // [142, 138, 129]

        // 맵
        // 맵핑, 해쉬, key - value
        // 파이썬의 딕셔너리와 비슷한 거

        // HashMap

        // put
        // key, value를 추가

        HashMap<String, String> map = new HashMap<>(); // 마찬가지로 제네락스 사용
        map.put("people", "사람");
        map.put("baseball", "야구");

        // key, value에 String 이외의 자료형은 사용할 수 없음


        // get
        // key에 해당하는 value 얻기
        HashMap<String, String> map = new HashMap<>(); // 마찬가지로 제네락스 사용
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.get("people")); // "사람"
        // key에 해당하는 value가 없다면 null 출력

        // null 대신 기본값을 얻고 싶다면 getOrDefault 메서드 사용
        System.out.println(map.getOrDefault("java", "자바"));

        // containsKey
        // 맵에 해당 key가 있는지를 true or false로 리턴
        HashMap<String, String> map = new HashMap<>(); // 마찬가지로 제네락스 사용
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.containsKey("people")); //true

        // remove
        // key 항목을 삭제하고 value 값을 리턴
        HashMap<String, String> map = new HashMap<>(); // 마찬가지로 제네락스 사용
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.remove("people")); // "사람"

        // size
        // 맵 요소의 개수 리턴
        HashMap<String, String> map = new HashMap<>(); // 마찬가지로 제네락스 사용
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.remove("people")); // "사람"
        System.out.println(map.size()); // 1

        // keySet
        // 맵 내 존재하는 모든 key를 모아서 '집합 자료형' 으로 리턴
        HashMap<String, String> map = new HashMap<>(); // 마찬가지로 제네락스 사용
        map.put("people", "사람");
        map.put("baseball", "야구");
        System.out.println(map.keySet()); // [baseball, people]

        // 집합 자료형은 리스트로 바꿀 수도 있음
        ArrayList<String> keyList = new ArrayList<>(map.keySet());

        // LinkedHashMap
        // 입력된 순서대로 데이터 저장

        // TreeMap
        // 입력된 key의 오름차순으로 데이터를 저장한다.

        // 집합
        // HashSet

        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set); // [e, H, l, o] 출력 (중복 제거, 순서 랜덤)

        // 교집합 구하기
        // retainAll

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        HashSet<Integer> intersection = new HashSet<>(s1); // s1 데이터 보존을 위해 복사본 생성

        intersection.retainAll(s2); // 교집합 수행
        System.out.println(intersection); // [4, 5, 6]

        // 합집합 구하기
        // addAll

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        HashSet<Integer> union = new HashSet<>(s1); // s1 데이터 보존을 위해 복사본 생성
        union.addAll(s2); // 합집합 수행
        System.out.println(union); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        // 차집합 구하기
        // removeAll

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        HashSet<Integer> subtract = new HashSet<>(s1); // s1 데이터 보존을 위해 복사본 생성

        subtract.removeAll(s2); // 차집합 수행
        System.out.println(subtract);

        // 집합에서 사용되는 메서드들

        // add
        // 집합에 값을 추가할 때 사용
        HashSet<String> set = new HashSet<>();
        set.add("Jump");
        set.add("To");
        set.add("Java");
        System.out.println(set); // [Java, To, Jump]

        // addAll
        // 한번에 여러 개 추가
        HashSet<String> set = new HashSet<>();
        set.add("Jump");
        set.addAll(Arrays.asList("To", "Java"));
        System.out.println(set); // [Java, To, Jump]

        // remove
        // 특정 값 제거
        HashSet<String> set = new HashSet<>(Arrays.asList("jump", "To", "Java"));
        set.remove("To");
        System.out.println(set); // [Java, Jump]

        // LinkedHashSet
        // 값을 입력 순서대로 정렬

        // TreeSet
        // 값을 오름차순으로 정렬해 저장

        // enum 자료형
        // 서로 연관 있는 여러 개의 상수 집합을 정의

        enum CoffeeType {
            americano,
            ice_americano,
            cafe_latte
        }

        System.out.println(CoffeeType.americano); // americano
        System.out.println(CoffeeType.ice_americano); // ice_americano
        System.out.println(CoffeeType.cafe_latte); // cafe_latte

        // 반복문에서 사용하기
        for (CoffeeType type: CoffeeType.values()) {
            System.out.println(type); // americano, ice_americano, cafe_latte
        }

        // 장점
        // 명확한 코드
        // 잘못된 값을 입력해서 생기는 오류 방지

        // 형 변환
        // 이를테면 '123'을 123으로 바꾸는 것

        String num = "123";
        int n = Integer.parseInt(num); // 문자열을 정수로 바꿔주기
        System.out.println(n); // 123

        // 정수를 문자열로 바꾸기
        // 방법 1 -> 정수 앞에 빈 문자열 "" 더하기
        int n = 123;
        String num = "" + n;
        System.out.println(num);

        // 방법 2 -> 메서드 사용
        int n = 123;
        String num1 = String.valueOf(n);
        String num2 = Integer.toString(n);

        System.out.println(num1); // "123"
        System.out.println(num2); // "123"

        // 소수점이 포함되어 있을 때

        String num = "123.456";
        String num2 = "1.234F";
        double d = Double.parseDouble(num);
        Float f = Float.parseFloat(num2);
        System.out.println(d); // 123.456
        System.out.println(f); // 1.234

        // 정수와 실수 간 형 변환
        int n1 = 123;
        double d1 = n1; // 정수 -> 실수
        System.out.println(d1); // 123.0

        double d2 = 123.456;
        int n2 = (int) d2;
        System.out.println(n2); // 123

        // 실수 형태의 '문자열'을 정수로 바꿀 때는 오류 발생
        // 오류를 잡으려면 '문자열'을 먼저 '실수'로 바꾼 후 Interger.parseInt 해주기


        // final
        // 한번 값을 설정하면 땡

        final int n = 123; // n은 영원히 123
        n = 456; // 오류 발생

        // 리스트여도 마찬가지
        final ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b"));
        a = new ArrayList<>(Arrays.asList("c", "d")); // 오류 발생

        // 대신 add나 remove는 가능한데, 이것도 막고 싶다면 List.of를 작성하면 됨
        final List<String> a = List.of("a", "b");
        a.add("c");  // UnsupportedOperationException 오류 발생



    }
}