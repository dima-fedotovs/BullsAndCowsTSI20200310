package tsi.javacourses;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.*;

public class PrimaryController {

    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView<Turn> turnsTable;
    public Button goButton;
    private List<Integer> myNumbers;
    private int count;

    public void initialize() {
        generateRandom();

        goButton.disableProperty().bind(
                Bindings.createBooleanBinding(
                        () -> {
                            Set<Integer> tmp = new HashSet<>();
                            tmp.add(num1.getValue());
                            tmp.add(num2.getValue());
                            tmp.add(num3.getValue());
                            tmp.add(num4.getValue());
                            return tmp.size() < 4;
                        },
                        num1.valueProperty(),
                        num2.valueProperty(),
                        num3.valueProperty(),
                        num4.valueProperty()
                )
        );
    }

    private void generateRandom() {
        Set<Integer> tmp = new LinkedHashSet<>();
        Random rand = new Random();
        while (tmp.size() < 4) {
            int i = rand.nextInt(10);
            tmp.add(i);
        }

        myNumbers = List.copyOf(tmp);

        System.out.println(myNumbers);
    }


    public void doTurn() throws IOException {
        count++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();

        List<Integer> userNumbers = List.of(n1, n2, n3, n4);

        var turn = new Turn();

        turn.setNr(count);
        turn.setGuess("" + n1 + n2 + n3 + n4);
        updateBullsAndCows(turn, userNumbers);

        turnsTable.getItems().add(0, turn);

        System.out.printf("TURN %d %d %d %d%n", n1, n2, n3, n4);

        if (turn.getBulls() == 4) {
            App.setRoot("secondary");
        }
    }

    private void updateBullsAndCows(Turn turn, List<Integer> userNumbers) {
        int cows = 0;
        int bulls = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                int un = userNumbers.get(x);
                int mn = myNumbers.get(y);
                if (un == mn) {
                    if (x == y) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        turn.setCows(cows);
        turn.setBulls(bulls);
    }

}
