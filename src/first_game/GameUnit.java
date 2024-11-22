package first_game;

import java.util.Random;

public class GameUnit {

    private String name;
    private int damage;
    private int health;
    private int weight;
    private int height;
    private final TypeUnit type;
    protected Random random = new Random();
    private boolean Shield = false;
    private final FamilyUnit family;

    public GameUnit(String name, int damage, int health, int weight, int height,
                    TypeUnit type) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.height = height;
        this.type = type;
        this.family = FamilyUnit.NEITHER;
        if (type == TypeUnit.TANK) {
            this.Shield = true;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getWeight() { return weight; }

    public int getHeight() {
        return height;
    }

    public TypeUnit getType() {
        return type;
    }

    public FamilyUnit getFamily() { return family; }

    public boolean isShield() { return Shield;}

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setShield() {
        this.Shield = false;
    }

    public void SayPhrase(GameUnit type) {
        switch (type.getType()) {
            case TypeUnit.TANK:
                System.out.println("Get over here!");
                break;
            case TypeUnit.HEALER:
                System.out.println("Let's get treated!");
                break;
            case TypeUnit.DAMAGE_DEALER:
                System.out.println("I'll destroy everything and everyone!");
                break;
            case TypeUnit.FLANG:
                System.out.println("Double kill!!!");
                break;
        }
    }

    public boolean isLives() {
        if (this.health <= 0) {
            return true;
        }
        return false;
    }

    public void loseHp(int damage) {
        this.health -= damage;
        if (this.isLives()) {
            this.health = 0;
            System.out.printf("%s is killed!\n", this.name);
        }
    }

    public void damage(GameUnit defender) {
        attack(defender, this.damage);
    }

    public void attack(GameUnit defender, int damage) {
        if (defender.isShield()) {
            defender.setShield();
            return;
        }
        switch (this.getType()) {
            case TypeUnit.TANK:
                if (random.nextDouble() < 0.03) {
                    damage += weight / height * 10;
                }
                break;
            case TypeUnit.DAMAGE_DEALER:
                if (random.nextDouble() < 0.1) {
                    damage *= 3;
                }
                break;
            case TypeUnit.FLANG:
                if (random.nextDouble() < 0.15) {
                    damage *= 2;
                }
                break;
            case TypeUnit.HEALER:
                if (random.nextDouble() < 0.05) {
                    damage *= 2;
                }
                break;
        }
        defender.loseHp(damage);
    }

    public void Heal() {
        if (this.type == TypeUnit.HEALER) {
            this.health += 30;
        } else {
            System.out.println("Who are you, dude?! It's not for u!");
        }
    }

    public void cheatAttack(GameUnit defender) {
        if (this.type == TypeUnit.DAMAGE_DEALER) {
            System.out.println("You will be destroyed!!!");
            damage = defender.getHealth();
            defender.loseHp(damage);
        } else {
            System.out.println("Who are you, dude?! It's not for u!");
        }
    }

    public void destroyHealer(GameUnit defender) {
        if (defender.getType() == TypeUnit.HEALER && this.type == TypeUnit.FLANG) {
            System.out.println("Special offer! 2 for the price of 1!");
            defender.loseHp(this.damage * 2);
        } else {
            System.out.println("Who are you, dude?! It's not for u!");
        }
    }
}