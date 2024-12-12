import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputName;
        int inputSpeed;
        Car[] carList = new Car[3];
        Race referee = new Race();
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите название машины №" + (i + 1) + ":");
            inputName = scanner.next();
            System.out.println("Введите скорость машины №" + (i + 1) + ":");
            while ((inputSpeed = scanner.nextInt()) > 250 || inputSpeed < 0) {
                System.out.println("Скорость должна быть от 0 до 250. Введите значение в указанном диапазоне");
            }
            carList[i] = new Car(inputName, inputSpeed);
            referee.defineLeader(carList[i]);
        }
        System.out.println("Самая быстрая машина: " + referee.leader);
    }
}

class Race {
    int distance = 0;
    String leader;

    void defineLeader(Car car) {
        if (car.speed * 24 > distance) {
            distance = car.speed * 24;
            leader = car.name;
        }
    }
}

class Car {
    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}
