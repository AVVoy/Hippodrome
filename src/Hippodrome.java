import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    private List<Horse> horses;
    public List<Horse> getHorses(){
        return horses;
    }
    static Hippodrome game;

    public static void main(String[] args) {
        Horse horse0 = new Horse("horse0", 3, 0);
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(horse0);
        horses.add(horse1);
        horses.add(horse2);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
    void run(){
        for (int i = 1; i < 101; i++) {
            move();
            print();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void move(){
        for (Horse horse : horses) {
            horse.move();
        }
    }
    void print(){
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double max = 0.0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (max < horse.distance) {
                max = horse.distance;
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().name);
    }
}
