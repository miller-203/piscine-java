import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }
    @Override
    public String toString() {
        if (this.currentHealth == 0) {
            return this.name + " : " + "KO";
        }
        return this.name + " : " + this.currentHealth + "/" + this.maxHealth;
    }
    public int getCurrentHealth() {
        return this.currentHealth;
    }
    public int getMaxHealth() {
        return this.maxHealth;
    }
    public String getName() {
        return this.name;
    }
    public void takeDamage(int damage) {
        this.currentHealth -= damage;
        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }
    }
    public void attack(Character opponent) {
        opponent.takeDamage(9);
    }
    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\nNobody's fighting right now !\n------------------------------------------\n";
        } else {
            StringBuilder status = new StringBuilder("------------------------------------------\nCharacters currently fighting :\n");
            for (Character character : allCharacters) {
                status.append(" - ").append(character.toString()).append("\n");
            }
            status.append("------------------------------------------\n");
            return status.toString();
        }
    }
    public static Character fight(Character c1, Character c2) {
        Character attacker = c1;
        Character defender = c2;
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            attacker.attack(defender);
            Character temp = attacker;
            attacker = defender;
            defender = temp;
        }
        Character winner = (c1.getCurrentHealth() > 0) ? c1 : c2;
        return winner;
    }
}