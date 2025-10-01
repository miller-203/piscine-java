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
    
    @Override
    public void attack(Character opponent) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        if (this.getWeapon() != null) {
            opponent.takeDamage(this.getWeapon().getDamage());
            return;
        }
        opponent.takeDamage(7);
    }
    
    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        this.setCurrentHealth(this.getCurrentHealth() - (int) Math.floor(damage * 0.8));
        if (this.getCurrentHealth() < 0) {
            this.setCurrentHealth(0);
        }
    }
}   