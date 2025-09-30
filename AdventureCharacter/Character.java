public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
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
}