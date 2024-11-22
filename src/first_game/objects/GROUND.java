package first_game.objects;

import first_game.FamilyUnit;
import first_game.GameUnit;
import first_game.TypeUnit;

public class GROUND extends GameUnit {
    private final FamilyUnit family;

    public GROUND(String name, int damage, int hp, int weight, int height,
                  TypeUnit type) {
        super(name, damage, hp, weight, height, type);
        this.family = FamilyUnit.GROUND;
    }

    @Override
    public void damage(GameUnit defender) {
        switch (defender.getFamily()) {
            case FamilyUnit.FIRE:
                attack(defender, this.getDamage() / 2);
            case FamilyUnit.GROUND:
                attack(defender, 0);
            case FamilyUnit.WIND:
                attack(defender, this.getDamage() * 5);
            default:
                attack(defender, this.getDamage());
        }
    }
}
