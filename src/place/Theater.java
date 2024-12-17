package place;

import character.*;
import character.Character;
import help.*;

public class Theater extends Place {
    private final Actors actors;
    private final Character[] audience;

    public Theater(String name, int x, int y, int z, Actors actors, Character[] audience) {
        super(name, x, y, z);
        this.actors = actors;
        this.audience = audience;
    }

    public void startShow() {
        System.out.println("\nПредставление начинается!\n");

        while (!isAudienceEmpty() && hasApples()) {
            for (int i = 0; i < audience.length; i++) {
                Character character = audience[i];
                if (character != null) {
                    if (character.getState() == State.Sad) {
                        System.out.println(character.getName() + " слишком расстроен и покидает представление.");
                        audience[i] = null;
                        continue;
                    }
                    try {
                        character.throwApple();
                        actors.setState(actors.worsenState(actors.getState()));

                        if (character instanceof Julio julio) {
                            julio.debuffAudience(audience);
                        }
                        if (character instanceof Migo migo){
                            migo.giveAppleAudience(audience);
                        }

                    } catch (PossibleException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

        System.out.println("\nУ персонажей нет яблок, или они слишком расстроены\n");
    }

    private boolean hasApples() {
        for (Character character : audience) {
            if (character != null) {
                for (Apple apple : character.appleInventory) {
                    if (apple != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isAudienceEmpty() {
        for (Character character : audience) {
            if (character != null) {
                return false;
            }
        }
        return true;
    }
}

