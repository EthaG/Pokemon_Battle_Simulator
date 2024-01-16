class AttackPill extends Item {         //AttackPill class inherits from Item class
    private int boostVal;   //value of attack boost

    public AttackPill(int boostVal) {   //constructor
        this.boostVal = boostVal;
    }

    public void setBoostVal(int boostVal) {     //setter
        this.boostVal = boostVal;
    }

    public int getBoostVal() {
        return boostVal;
    }

    public void use(Pokemon pokemon) {
        pokemon.setAtk(pokemon.getAtk() + boostVal);
    }

    public void displayInfo() {
        System.out.println("Item increases attack by: " + boostVal);
    }
}