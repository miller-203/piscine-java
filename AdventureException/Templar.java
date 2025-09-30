public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
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
            newHealth = character.getMaxHealth();
        }
        character.setCurrentHealth(newHealth);
    }
    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return this.getName() + " has been beaten, even with its " + this.shield + " shield. So bad, it could heal " + this.healCapacity + " HP." + " He has the weapon " + this.getWeapon().toString() + ".";
        }
        return this.getName() + " is a strong Templar with " + this.getCurrentHealth() + " HP. It can heal " + this.healCapacity + " HP and has a shield of " + this.shield + "." + " He has the weapon " + this.getWeapon().toString() + ".";
    }
    public void attack(Character opponent) {
        heal(this);
        if (this.getWeapon() != null) {
            opponent.takeDamage(this.getWeapon().getDamage());
            return;
        }
        opponent.takeDamage(6);
    }
    public void takeDamage(int damage) {
        this.setCurrentHealth(this.getCurrentHealth() - (damage - this.shield));
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }
}
