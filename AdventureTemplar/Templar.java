public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }
    public int getHealCapacity() {
        return this.healCapacity;
    }
    public int getShield() {
        return this.shield;
    }
    public void heal(Character character) {
        int newHealth = character.getCurrentHealth() + this.healCapacity;
        if (newHealth > character.getMaxHealth()) {
            character.setCurrentHealth(character.getMaxHealth());
        } else {
            character.setCurrentHealth(newHealth);
        }
    }
    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return this.getName() + " has been beaten, even with its " + this.shield + " shield. So bad, it could heal " + this.healCapacity + " HP." ;
        }
        return this.getName() + " is a strong Templar with " + this.getCurrentHealth() + " HP. It can heal " + this.healCapacity + " HP and has a shield of " + this.shield + ".";
    }
}
