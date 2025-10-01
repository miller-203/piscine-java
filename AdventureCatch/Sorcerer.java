public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    public int getHealCapacity() {
        return this.healCapacity;
    }

    public void heal(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
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
    
    @Override
    public void attack(Character opponent) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        heal(this);
        if (this.getWeapon() != null) {
            opponent.takeDamage(this.getWeapon().getDamage());
            return;
        }
        opponent.takeDamage(10);
    }
    
    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        this.setCurrentHealth(this.getCurrentHealth() - damage);
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }
}