// 계산기 클래스를 만들어보자!

import com.sun.security.jgss.GSSUtil;

class Calculater {
    int result = 0;

    int add(int num) { // 덧셈 메서드
        result += num;
        return result;
    }

    int sub(int num) { // 뺄셈 메서드
        result -= num;
        return result;

    }
}

// 클래스와 객체
class Animal {
    String name;
    // 이렇게 클래스에 선언된 변수를 '객체 변수' 라고 한다
    // 객체 변수는 '인스턴스 변수', '멤버 변수', '속성' 이라고도 한다

    public void setName(String name) {
        this.name = name;
        // this는 Animal 클래스에 의해 생성된 객체(인스턴스)를 말한다

    }
    // 메서드란 클래스 내부에 구현된 함수를 말한다
    // 이렇게 객체 변수에 값을 대입할 때 메서드를 사용한다

}

public class Chapter5 {
    public static void main(String[] args) {

//      System.out.println(Calculater.add(3)); // 3 출력
//      System.out.println(Calculater.add(4)); // 7 출력, 기존 값과 간섭이 일어난다. 이걸 막기 위해서는,,,,

        Calculater car1 = new Calculater();
        Calculater car2 = new Calculater(); // 이런 식으로 계산기 객체를 생성해주면 된다.

        System.out.println(car1.add(3)); // 3
        System.out.println(car1.add(4)); // 7

        System.out.println(car2.add(2)); // 2
        System.out.println(car2.add(5)); // 7

        // 객체 생성을 통해 각각의 객체가 각자의 역할만 수행할 수 있게 된다.

        Animal cat = new Animal(); // 위에서 만든 Animal 클래스를 통해 새로운 cat 객체를 만들었다.

        // 객체를 클래스와 연관지어 설명할 때는 인스턴스라고 부른다
        // 예를 들어 방금 만든 cat은 객체이다. 동시에 cat은 'Animal 클래스의 인스턴스' 이다
        // 따라서, 모든 인스턴스는 객체이지만, 클래스와 연관지어 설명할 때는 인스턴스라고 부르는 것이다~

        cat.setName("Bori"); // 위에서 만든 setName 메서드를 호출해서 보리라는 이름을 넣었다
        System.out.println(cat.name); // Bori 출력

        Animal dog = new Animal();
        dog.setName("Happy");

        System.out.println(cat.name); // Bori 출력
        System.out.println(dog.name); // Happy 출력

        // setName 메서드가 두 번 실행되어서 Happy라는 이름이 cat.name 에도 덮어쓰일 거라 생각했는가? 아니다.
        // 여기서 알 수 있는 점: 객체 변수의 값은 독립적으로 유지된다
        // 그리고 이것은 매우매우 중요하다!!!


    }
}

// 메서드를 사용하는 이유 -> 여러 번 반복할 가치가 있어서
// Sample 클래스 안에서 sum 이라는 메서드를 만들어보자

class Sample {
    int sum (int a, int b) { // a, b는 매개변수
        return a + b;
    }

    public static void main(String[] args) {

        Sample sample = new Sample(); // 만든 메서드를 테스트하기 위해 이런 식으로 객체를 생성하기도 한다
        int sumResult = sample.sum(3,4); // 3, 4는 인수
        System.out.println(sumResult);
    }
}

// 메서드는 4가지 종류가 있다

class Sample2 {

    // 1. 입력값과 리턴값이 모두 있는 메서드
    int sum(int a, int b) {
        return a + b;
    }

    // 2. 입력값이 없는 메서드
    String say() {
        return "Hi";
    }

    // 3. 리턴값이 없는 메서드
    void displaySum(int a, int b) {
        System.out.println(String.format("%d와 %d의 합은 %d 입니다.", a, b, a + b));
    }

    // 4. 둘 다 없는 메서드
    void say2() {
        System.out.println("Hi");
    }

    // return을 단독으로 사용하면 메서드를 즉시 빠져나갈 수 있다
    // 참고로 이 메서드 또한 리턴값은 없다. 출력하는 것과 리턴값이 있다는 건 전혀 다른 말이다~
    // return을 단독으로 사용하는 건 메서드의 리턴값이 void일 때만 가능하다

    void sayNick(String nick) {
        if ("바보".equals(nick)) {
            return;
        }
        System.out.println(String.format("나의 별명은 %s입니다", nick));
    }

    // 메서드 안에서 변수 이름과 메서드 밖 변수 이름이 같다면, 간섭이 일어날까?
    void varTest (int a) {
        a++;
    }

    // varTest 입력값이 객체인 경우
    int aa; // 객체 변수 aa

    void varTest(Sample2 sample2) {
        sample2.aa++;
    }

    // this 활용하기

    int d;
     void varTest() {
         this.d++; // this를 통해 파라미터 없이 객체에 접근할 수 있음
     }


    public static void main(String[] args) {

        int a = 1;
        Sample2 sample2 = new Sample2();

        sample2.d = 1;
        sample2.varTest();
        System.out.println(sample2.d); // 2

        sample2.aa = 1;
        sample2.varTest(sample2);
        // sample2 객체 자체가 메서드에 들어감
        // 이렇게 메서드가 객체를 받으면, 메서드 내 객체는 전달받은 객체 그 자체로 수행된다


        System.out.println(sample2.aa); // 2 출력

        sample2.varTest(a);
        System.out.println(a);
        // 2가 출력될 것 같지만, 1이 출력됨
        // varTest 메서드의 a와 main 메서드의 a는 다름
        // sample2.varTest(a)에서 a는 1이 복사되어 들어가서 varTest 메서드 안에서만 1 증가
        // 따라서 그 후에 a를 출력한다고 해서 2가 출력되지 않는 것!!
        // 이것을 값에 의한 전달(pass by value)이라고 함
        // 만약 외부 변수 a의 값에 영향을 주고 싶다면, varTest 변수가 내부 a를 리턴하게 만들고, 그 값을 외부 a에 넣어주면 된다!


        String greeting = sample2.say();
        System.out.println(greeting); // 2, Hi 출력

        sample2.displaySum(3, 4); // 3, 3와 4의 합은 7 입니다. 출력

        sample2.say2(); // 4, Hi 출력

        sample2.sayNick("야호"); // 나의 별명은 야호입니다
        sample2.sayNick("바보"); // 출력 x
    }
}

// 값에 의한 호출과 객체에 의한 호출

class Updater {
    void update(int count) {
        count++;
    }
}

class Counter {
    int count = 0; // 객체 변수
}

class Sample3 {
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println(String.format("before update: %d", myCounter.count)); // 0 출력
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter.count);
        System.out.println(String.format("after update: %d", myCounter.count));
        // 마찬가지로 0 출력, 메서드 내부에서는 1이 되었으나, 리턴값이 없기 때문에 여전히 0
    }
}

// 예제 변경

class Updater {
    void update(Counter counter) {
        // 여기서 객체를 전달받기 때문에 메서드 수행 후에도 변경된 값이 유지된다
        counter.count++;
    }
}

class Counter {
    int count = 0; // 객체 변수
}

class Sample4 {
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println(String.format("before update: %d", myCounter.count));
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter);
        System.out.println(String.format("after update: %d", myCounter.count));
    }
}

// 상속
// 자식 클래스가 부모 클래스의 기능을 물려받는 것

class Animal {
    String name;

    public void setName(String name) {
        this.name = name;
    }
}

//class Dog extends Animal { // Dog 클래스에 Animal 클래스를 상속
//
//}

class Sample5 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Bonggu");
        System.out.println(dog.name); // Bonggu
    }
}

// 자식 클래스 기능 확장하기
// 보통 자식 클래스는 부모 클래스 기능 + @ 이다

class Dog extends Animal {
    void sleep() {
        System.out.println(this.name + "zzz");
    }
}

class Sample6 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Bonggu");
        System.out.println(dog.name);
        dog.sleep();
    }
}

// IS-A 관계
// Dog 'is a' Animal

Animal dog = new Dog(); // Animal이 부모 클래스, Dog가 자식 클래스
Dog dog = new Animal(); // 반대의 경우는 컴파일 오류가 발생한다

// 자바에서 만드는 모든 클래스는 Object 클래스를 부모로 가진다
// 따라서 다음과 같이 코딩 가능하다
Object animal = new Animal();
Object dog = new Dog();

// 메서드 오버라이딩
class HouseDog extends Dog {
    @Override
    void sleep() {
        System.out.println(this.name + " zzz in house");
    }

    // 메서드 오버로딩
    // 입력 항목이 다른 경우 동일한 이름의 메서드를 만들 수 있다~

    void sleep(int hour) {
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    }

    // 생성자
    // 메서드명이 클래스명과 동일하고, 리턴 자료형을 정의하지 않는 메서드(void도 안씀!!)
    // 현재 HouseDog 생성자가 name 문자열을 인자로 받으므로, HouseDog 객체를 생성할 때 name 인자를 넣어줘야 함
    // 이런 식으로 생성자는 객체 생성시에 '필수적인 행동을 강제' 할 수 있다

    HouseDog(String name) {
        this.setName(name);
    }

    // 디폴트 생성자
    HouseDog() {

    }
    // 생성자의 인자가 없고, 내부에 아무 내용도 없음
    // 생성자를 따로 지정하지 않으면 컴파일러가 자동으로 만드는 생성자
    // 만약 사용자가 생성자를 하나라도 만들었다면, 디폴트 생성자는 따로 만들어줘야 함

    // 생성자 오버로딩
    // 메서드와 마찬가지도 생성자도 입력값이 다르고 이름은 같은 생성자를 만들어줄 수 있다
    HouseDog(int type) {
        if (type == 1){
            this.setName("yorkshire");
        } else if (type == 2) {
            this.setName("bulldog");
        }
    }

}

public class Sample7 {
    public static void main(String[] args) {
//        HouseDog houseDog = new HouseDog(); 기존 객체 생성
        HouseDog houseDog = new HouseDog("Bonggu");
        // 생성자가 생겼으므로 이제 객체를 만들 때 문자열을 전달해야 한다!!

//        houseDog.setName("Bonggu");
        // 생성자로 이미 name을 전달 -> setName은 불필요

        houseDog.sleep(); // Bonggu zzz in house
        houseDog.sleep(3); // Bonggu zzz in house for 3 hours

        HouseDog happy = new HouseDog("Happy"); // String을 받는 HouseDog 생성자
        HouseDog yorkshire = new HouseDog(1); // int를 받는 HouseDog 생성자
        System.out.println(happy.name);
        System.out.println(yorkshire.name);
    }
}

// 인터페이스
// super 중요함
// 원래 클래스와 마찬가지로 단독 파일로 저장하는 것이 일반적!!!

interface Predator {

    // 인터페이스의 메서드
    String getFood();
    // 인터페이스의 메서드는 '규칙' 이다
    // 이제 인터페이스의 영향을 받는 객체들은 getFood()를 구현하지 않으면 안된다

}
class Animal {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Animal implements Predator, Barkable { // 설정한 인터페이스 이식
    public String getFood() {
        return "apple";
    }

    @Override
    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Animal implements Predator, Barkable {
    public String getFood() {
        return "banana";
    }

    @Override
    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
//    void feed(Tiger tiger) {
//        System.out.println("feed apple");
//    }
//
//    void feed(Lion lion) {
//        System.out.println("feed banana");
//    }

    void feed(Predator predator) {
        System.out.println("feed " + predator.getFood());
    }
}

public class Sample8 {
    public static void main(String[] args) {
        ZooKeeper zooKeeper = new ZooKeeper();
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        // 인터페이스의 구현으로 tiger와 lion은 이제 Animal이자 Predator가 되었다
        // 이렇게 객체가 1개 이상의 자료형 타입을 갖는 것을 다형성(폴리모피즘)이라고 한다

        // 여기서는 tiger와 lion이 각각 predator로써 전달되게 된다
        // 이를 '업 캐스팅' 이라고 한다~ (Predator - Animal - Tiger/Lion)
        zooKeeper.feed(tiger); // feed apple
        zooKeeper.feed(lion); // feed banana

        // 상속으로도 동일한 로직의 코드를 작성할 수 있다!!!
        // 예를 들어 Animal 클래스에 getFood 메서드를 구현하고, 각 Animal 객체에서 오버라이딩을 통해 apple과 banana를 출력하게 할 수 있다.
        // 하지만 인터페이스와 달리 컴파일 오류를 통한 강제성은 없게 되는데, 이 부분이 큰 차별점이다!!!
    }
}

// 디폴트 메서드
interface Predator {
    String getFood();

    default void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
    // 이렇게 디폴트 메서드를 구현하면 Tiger, Lion 등의 클래스는 printFood를 구현하지 않아도 사용 가능
    // 디폴트 메서드도 결국 메서드이기 때문에, 오버라이딩 가능 (실제 클래스에서 다르게 구현 가능!!!)
}

// 다형성에 대해 araboza
// 하나의 객체가 여러 개의 자료형 타입을 가지는 것을 다형성이라고 함!!!
// 즉 tiger 객체는 Tiger이자, Animal이자, Predator이자, Barkable인 것

interface Barkable {
    void bark();
}

class Bouncer {
//    void barkAnimal(Animal animal) {
//        if (animal instanceof Lion) { // instanceof == 어떤 객체가 특정 클래스의 객체인지 조사
//            System.out.println("으르렁");
//        } else if (animal instanceof Tiger) {
//            System.out.println("어흥");
//        }
//    }
    void barkAnimal (Barkable animal) {
        // Tiger, Lion 클래스에 Barkable 인터페이스를 추가
        // Tiger, Lion 클래스에 bark 메서드 구현
        // barkAnimal의 입력 자료형을 Barkable로 변경
        // Tiger, Lion이 Barkable을 가지고 있으므로 가능한 것
        animal.bark();
    }
}

// 인터페이스는 일반 클래스와 달리 다중 상속이 가능하다

 interface BarkablePredator extends Barkable, Predator {
 }

// 이제 BarkablePredator 인터페이스는 getFood와 bark 둘 다 사용할 수 있다

// 그러면 Lion 클래스를 다음과 같이 수정할 수 있다
class Lion extends Animal implements BarkablePredator {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

public class Sample9 {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger);
        // 내부적으로 tiger.bark() 실행
        // 어흥

        bouncer.barkAnimal(lion);
        // 내부적으로 lion.bark() 실행
        // 으르렁
    }
}

// 추상 클래스
// 클래스 앞에 abstract를 붙여요
// 메서드 앞에도 붙여요 (안 붙이고도 쓸 수 있어요)
// 추상 클래스는 단독으로 객체를 생성할 수 없고, 얘를 상속한 실제 클래스를 통해서만 객체를 생성해요

abstract class Predator extends Animal {
    abstract String getFood();

    void printFood() {
        System.out.printf("my food is %s\n", getFood());
    }
}

// Predator 클래스가 추상 클래스가 되었으므로, Tiger, Lion 클래스에서 더 이상 extends 할 수 없음

