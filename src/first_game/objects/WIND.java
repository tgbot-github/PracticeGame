package first_game.objects;

import first_game.FamilyUnit;
import first_game.GameUnit;
import first_game.TypeUnit;

public class WIND extends GameUnit {
    private final FamilyUnit family;

    public WIND(String name, int damage, int hp, int weight, int height,
                TypeUnit type) {
        super(name, damage, hp, weight, height, type);
        this.family = FamilyUnit.WIND;
    }

    @Override
    public void damage(GameUnit defender) {
        switch (defender.getFamily()) {
            case FamilyUnit.FIRE:
                attack(defender, this.getDamage() * 3);
            case FamilyUnit.GROUND:
                attack(defender, this.getDamage() * 3);
            case FamilyUnit.WATER:
                attack(defender, this.getDamage() * 3);
            case FamilyUnit.WIND:
                attack(defender, 0);
            default:
                attack(defender, this.getDamage());
        }
    }
}
