class Pokemon extends Entity {          //Pokemon class inherits from Entity class
    private String name;        //pokemon's name
    private int hp;             //health points
    private int atk;            //attack points

    public Pokemon(String name, int hp, int atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }

    public Pokemon() {
        this("No name", 0 , 0);
    }

    public Pokemon(String name) {
        this(name, 0, 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public void displayInfo() {
        System.out.println("Pokemon name: " + name + "\thp: " + hp + "\tatk: " + atk);
    }
}
