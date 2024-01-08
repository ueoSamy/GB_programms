// Абстрактный класс для представления геометрической фигуры
abstract class Shape {
    // Методы для вычисления площади и периметра, которые будут реализованы в подклассах
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

// Класс для представления круга
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Класс для представления прямоугольника
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Класс для представления квадрата (подкласс прямоугольника)
class Square extends Rectangle {
    // В конструкторе вызывается конструктор родительского класса Rectangle
    public Square(double side) {
        super(side, side);
    }

    // Переопределение методов родительского класса, чтобы они соответствовали квадрату
    @Override
    public double calculateArea() {
        return super.calculateArea(); // Для квадрата, площадь равна стороне в квадрате
    }

    @Override
    public double calculatePerimeter() {
        return 4 * super.calculatePerimeter(); // Для квадрата, периметр равен 4 * сторона
    }
}
