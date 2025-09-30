public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return this.getName() + " is a monster with " + this.getCurrentHealth() + " HP";
        }
        return this.getName() + " is a monster and is dead";
    }
    public void attack(Character opponent) {
        opponent.takeDamage(7);
    }
    public void takeDamage(int damage) {
        this.setCurrentHealth(this.getCurrentHealth() - (int) Math.floor(damage * 0.8));
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }
}
