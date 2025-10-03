import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> change = new ArrayList<>();
        List<Integer> sortedCoins = new ArrayList<>(coins);
        Collections.sort(sortedCoins, Collections.reverseOrder());

        for (int coin : sortedCoins) {
            while (amount >= coin) {
                change.add(coin);
                amount -= coin;
            }
        }
        return change;
    }
}