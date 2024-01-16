class HealthPotion extends Item {           //HealthPotion class inherits from Item class
    private int healAmount; //amount the potion heals for

    public HealthPotion(int healAmount) {   //constructor
        this.healAmount = healAmount;
    }

    public void setHealAmount(int healAmount) {     //setter
        this.healAmount = healAmount;
    }

    public int getHealAmount() {        //getter
        return healAmount;
    }

    public void use(Pokemon pokemon) {
        pokemon.setHp(pokemon.getHp() + healAmount);
    }

    public void displayInfo() {
        System.out.println("Item heals pokemon for: " + healAmount);
    }
}