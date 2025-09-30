public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
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
        if (this.getCurrentHealth() != 0) {
            return this.getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + this.healCapacity
                    + " HP." + " He has the weapon " + this.getWeapon().toString() + ".";
        }
        return this.getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP." + " He has the weapon " + this.getWeapon().toString() + ".";
    }
    public void attack(Character opponent) {
        heal(this);
        if (this.getWeapon() != null) {
            opponent.takeDamage(this.getWeapon().getDamage());
            return;
        }
        opponent.takeDamage(10);
    }
    public void takeDamage(int damage) {
        this.setCurrentHealth(this.getCurrentHealth() - damage);
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }
}
