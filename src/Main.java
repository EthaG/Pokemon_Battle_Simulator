//test cases

class Main {
    public static void main(String[] args) {

        /**
         * TESTING PURPOSES
         */

        Game temp = new Game();
        temp.start();
        //Game.start() would only work if start() was static

        Trainer beyu = new Trainer();
        beyu.displayInfo();
        Pokemon leafion = new Pokemon("leafion", 4, 5);
        Item heal = new HealthPotion(6);

        Pokemon[] pokemons = new Pokemon[] {leafion, new Pokemon(), new Pokemon("Tyler"), new Pokemon("Pikachu", 10, 10)};

        Item[] items = new Item[] {heal, new AttackPill(3), new AttackPill(7), new HealthPotion(5)};
        Trainer beyu2 = new Trainer("beyu2", pokemons, items);
        beyu2.displayInfo();

        Pokemon[] mons = new Pokemon[2*pokemons.length + 1];
        for (int i = 0; i < pokemons.length; i++) {
            mons[i] = pokemons[i];
        }

        Pokemon mew = new Pokemon("Mew", 8, 10);
        mons[pokemons.length] = mew;

        Trainer beyu3 = new Trainer("beyu3", mons, items);
        beyu3.displayInfo();

        beyu2.setPokemons(mons);
        beyu2.displayInfo();

        for (int j = 1; j < beyu2.getPokemons().length; j++) {
            if (beyu2.getPokemons()[j] != null && beyu2.getPokemons()[j].getName() == "Tyler") {
                beyu2.getPokemons()[j].setHp(-10);
            }
        }
        beyu2.displayInfo();

        for (int j = 1; j < beyu2.getPokemons().length; j++) {
            if (beyu2.getPokemons()[j] != null && beyu2.getPokemons()[j].getName() == "Tyler") {
                beyu2.getPokemons()[j] = null;
            }
        }
        beyu2.displayInfo();

        System.out.println("------ TESTING ------");
        for (Pokemon mon : beyu2.getPokemons()){
            System.out.println(mon);
        }

        for (int i = 0; i < beyu2.getPokemons().length; i++) {
            int j = i+1;
            while (beyu2.getPokemons()[i] == null && j < beyu2.getPokemons().length) {
                if (beyu2.getPokemons()[j] != null) {
                    beyu2.getPokemons()[i] = beyu2.getPokemons()[j];
                    beyu2.getPokemons()[j] = null;
                }
                j = j + 1;
            }
        }

        System.out.println("------ TESTING2 ------");
        for (Pokemon mon : beyu2.getPokemons()){
            System.out.println(mon);
        }

        for (int i = 0; i < beyu2.getPokemons().length; i++) {
            int j = i+1;
            while (beyu2.getPokemons()[i] != null && j < beyu2.getPokemons().length) {
                if (beyu2.getPokemons()[j] != null && beyu2.getPokemons()[i].getName().compareToIgnoreCase(beyu2.getPokemons()[j].getName()) > 0) {
                    Pokemon tempMon = beyu2.getPokemons()[i];
                    beyu2.getPokemons()[i] = beyu2.getPokemons()[j];
                    beyu2.getPokemons()[j] = tempMon;
                }
                j = j + 1;
            }
        }


        for (Pokemon mon: beyu2.getPokemons()) {
            if (mon != null) {
                for (Item item: beyu2.getItems()) {
                    item.use(mon);
                }
            }
        }

        mons[5] = new Pokemon("Mew");
        mons[6] = new Pokemon("leafion");
        mons[7] = new Pokemon("Mew");
        beyu2.setPokemons(mons);

        System.out.println("------ TESTING 3a ------");
        beyu2.displayInfo();

        System.out.println("------ TESTING 4a ------");
        for (Pokemon mon : beyu2.getPokemons()){
            System.out.println(mon);
        }



        for (int i = 0; i < beyu2.getPokemons().length-1; i++) {
            if (beyu2.getPokemons()[i] != null) {
                for (int j = i+1; j < beyu2.getPokemons().length; j++) {
                    if (beyu2.getPokemons()[j] != null &&
                            beyu2.getPokemons()[j].getName().equals(beyu2.getPokemons()[i].getName())) {
                        beyu2.getPokemons()[j] = null;
                    }
                }
            }

        }
        for (int i = 0; i < beyu2.getPokemons().length; i++) {
            int j = i+1;
            while (beyu2.getPokemons()[i] == null && j < beyu2.getPokemons().length) {
                if (beyu2.getPokemons()[j] != null) {
                    beyu2.getPokemons()[i] = beyu2.getPokemons()[j];
                    beyu2.getPokemons()[j] = null;
                }
                j = j + 1;
            }
        }

        System.out.println("------ TESTING 3b ------");
        beyu2.displayInfo();

        System.out.println("------ TESTING 4b ------");
        for (Pokemon mon : beyu2.getPokemons()){
            System.out.println(mon);
        }

        //mons before function: leafion, No name, Pikachu, Mew, null, Mew, leafion, Mew, null
        //mons after function: leafion, No name, Pikachu, Mew, null, null, null, null, null
    }
}