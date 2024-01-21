// Шаг 1: Создание обобщенного класса Box
/*
 Принцип единственной ответственности (Single Responsibility Principle, SRP):
 Класс Box отвечает за управление коробкой для хранения объектов, включая размещение и получение элементов,
 а также вывод содержимого коробки. Метод printBox() может быть рассмотрен как нарушение SRP,
 так как это может быть отнесено к ответственности другого класса, например, отдельного класса для вывода.
 */
public class Box<T> {
    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }

    // создадим статический метод printBox с ограничением типа в классе Box:
    // Метод printBox нарушает SRP, так как он относится к ответственности вывода, а не управлению коробкой.
    public static void printBox(Box<? extends Fruit> box) {
        System.out.println("Box contains:");
        System.out.println(box.get());
    }

    // Принцип открытости/закрытости (Open/Closed Principle, OCP):
    // Класс Box открыт для расширения (можно добавлять новые методы, например, для работы с коробкой),
    // но закрыт для изменения (основные методы остаются неизменными при добавлении новой функциональности).

    // Принцип подстановки Барбары Лисков (Liskov Substitution Principle, LSP):
    // Метод getFruitBox возвращает Box<Fruit>, но фактически может содержать подклассы Fruit, такие как Apple и Orange,
    // что соответствует LSP.

    // создадим статический метод getFruitBox():
    // Шаг 3: Наполнение коробки фруктами
    public static Box<Fruit> getFruitBox() {
        Box<Fruit> fruitBox = new Box<>();
        fruitBox.put(new Apple());
        fruitBox.put(new Orange());
        return fruitBox;
    }
}

// Принцип инверсии зависимостей (Dependency Inversion Principle, DIP):
// В этом коде не явно видны зависимости, но принцип DIP подразумевает, что вы должны зависеть от абстракций, а не от конкретных реализаций.
// Например, Box<Fruit> - это абстракция, которую мы используем вместо конкретных подклассов Fruit.

// Принцип единственной ответственности (Single Responsibility Principle, SRP):
// В Main-классе нет явного примера нарушения SRP, так как его основная задача - тестирование созданных классов и методов.



// Шаг 2: Создание классов фруктов
class Fruit {
    @Override
    public String toString() {
        return "Fruit";
    }
}

class Apple extends Fruit {
    @Override
    public String toString() {
        return "Apple";
    }
}

class Orange extends Fruit {
    @Override
    public String toString() {
        return "Orange";
    }
}

// Шаг 6: Тестирование
class Main {
    public static void main(String[] args) {
        Box<Fruit> fruitBox = Box.getFruitBox();
        Box.printBox(fruitBox);
    }
}
