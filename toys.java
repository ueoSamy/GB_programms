import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                return;
            }
        }
        System.out.println("Игрушка с id " + id + " не найдена.");
    }

    public Toy drawToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomNumber = new Random().nextDouble() * totalWeight;
        double currentWeight = 0.0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    return toy;
                } else {
                    System.out.println("Больше нет доступного количества для игрушки: " + toy.getName());
                    return null;
                }
            }
        }
        return null;
    }

    public void saveToyToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("winners.txt", true)) {
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(1, "Медвежонок Teddy", 10, 20);
        toyStore.addToy(2, "Кукла", 15, 30);
        toyStore.addToy(3, "Машинка", 20, 50);

        for (int i = 0; i < 5; i++) {
            Toy winner = toyStore.drawToy();
            if (winner != null) {
                System.out.println("Поздравляем! Вы выиграли " + winner.getName());
                toyStore.saveToyToFile(winner);
            } else {
                System.out.println("Больше нет игрушек для розыгрыша.");
            }
        }
    }
}
