public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() != 0) {
            return this.getName() + " is a monster with " + this.getCurrentHealth() + " HP" + ". He has the weapon " + this.getWeapon().toString() + ".";
        }
        return this.getName() + " is a monster and is dead . He has the weapon " + this.getWeapon().toString() + ".";
    }
    public void attack(Character opponent) {
        if (this.getWeapon() != null) {
            opponent.takeDamage(this.getWeapon().getDamage());
            return;
        }
        opponent.takeDamage(7);
    }
    public void takeDamage(int damage) {
        this.setCurrentHealth(this.getCurrentHealth() - (int) Math.floor(damage * 0.8));
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }
}
