class Trainer extends Entity {

    private String name;
    private Pokemon[] pokemons;
    private Item[] items;

    public Trainer(String name, Pokemon[] pokemons, Item[] items) {
        this.name = name;
        this.pokemons = pokemons;
        this.items = items;
        updateCount();
    }

    public Trainer() {
        this("No name", null, null);
    }

    public Trainer(String name, Pokemon[] pokemons) {
        this(name, pokemons, null);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPokemons(Pokemon[] pokemons) {
        this.pokemons = pokemons;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public Item[] getItems() {
        return items;
    }

    public void displayInfo() {
        System.out.println("Trainer's name: " + name);

        if (pokemons != null) {
            System.out.println("Trainer's Pokemon:");
            for (Pokemon pokemon: pokemons) {
                if (pokemon != null) {
                    pokemon.displayInfo();
                }
            }
        } else {
            System.out.println("Trainer's Pokemon: null");
        }

        if (items != null) {
            System.out.println("Trainer's Items:");
            for (Item item: items) {
                item.displayInfo();
            }
        } else {
            System.out.println("Trainer's Items: null");
        }

    }
}

