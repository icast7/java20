package com.zzz.archive.nai._1playerOOP;

public class Player {
    private Weapon weapon;
    private String name;

    public Player(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void action() {
        if (this.weapon.type == "knife") {

        } else {

        }
    }
}
