import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DartBoard {

    // Include circles in order of increasing radius
    private List<DartCircle> circles = new ArrayList<DartCircle>();

    public DartBoard() {
        circles.add(new DartCircle(1.0, 10));
        circles.add(new DartCircle(5.0, 5));
        circles.add(new DartCircle(10.0, 1));
    }

    public static void main(String[] args) {

        DartBoard board = new DartBoard();
        Dart dart = new Dart (1, 1);

        System.out.println("Score: " + board.score(dart));

    }

    public int score(Dart dart) {

        int score = 0;

        // Find dart's distance from the centre
        double distance = Math.sqrt (Math.pow(dart.getX(), 2) +
                Math.pow(dart.getY(), 2));

        for (DartCircle circle: circles) {
            if (distance <= circle.getRadius()) {
                score = circle.getPoints();
                break;
            }
        }

        return score;

    }
}
