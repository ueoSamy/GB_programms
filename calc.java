import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Интерфейс операции
interface Operation {
    double execute(double a, double b);
}

// Классы конкретных операций
class Addition implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}

class Multiplication implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}

class Division implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

// Класс калькулятора
class Calculator {
    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double calculate(double a, double b) {
        if (operation == null) {
            throw new IllegalStateException("Operation not set");
        }
        return operation.execute(a, b);
    }
}

// Фабрика операций
class OperationFactory {
    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}

// Пример использования калькулятора
public class Main {
    public static void main(String[] args) {
        // Настройка логирования
        Logger logger = Logger.getLogger(Main.class.getName());
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);

        try {
            // Создание калькулятора
            Calculator calculator = new Calculator();

            // Установка операции сложения
            calculator.setOperation(OperationFactory.createOperation("+"));
            double result = calculator.calculate(5, 3);
            logger.info("Addition result: " + result);

            // Установка операции умножения
            calculator.setOperation(OperationFactory.createOperation("*"));
            result = calculator.calculate(5, 3);
            logger.info("Multiplication result: " + result);

            // Установка операции деления
            calculator.setOperation(OperationFactory.createOperation("/"));
            result = calculator.calculate(6, 2);
            logger.info("Division result: " + result);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
        }
    }
}
