import java.util.Scanner;
import java.util.Random;

class Game {

    private boolean inProgress = true; //inProgress is non-static variable
    Scanner input = new Scanner(System.in);
    private Trainer you;
    private Trainer enemy;
    private Pokemon yourBattleMon;
    private Pokemon enemyBattleMon;

    public int getRandNum(String stat) {
        Random rand = new Random();
        if (stat == "hp") {
            return rand.nextInt(20) + 1; //hp is 1 to 20
        } else {
            return rand.nextInt(11); //atk is 0 to 10
        }
    }

    public void switchMon(String newMon) {      //does not switch enemy mons
        boolean invalid = true;
        while (invalid == true) {
            for (Pokemon mon: you.getPokemons()) {
                if (mon != null && mon.getName().equals(newMon)) {
                    invalid = false;
                    yourBattleMon = mon;
                }
            }
            if (invalid == true) {
                System.out.print("Entered invalid pokemon name. Choose a new battle pokemon: ");
                newMon = input.next();
            }
        }
    }

    public void attackMon(Pokemon attackerMon, Pokemon targetMon) {
        int atk = attackerMon.getAtk();
        targetMon.setHp(targetMon.getHp() - atk);
        System.out.println(attackerMon.getName() + " inflicts " + atk + " damage on " + targetMon.getName());
        displayInfo();
    }

    public void checkDeath(Trainer target, Pokemon targetMon) {
        if (targetMon.getHp() <= 0) {
            System.out.println(targetMon.getName() + " is dead!");
            for (int i = 0; i < target.getPokemons().length; i++) {
                if (target.getPokemons()[i] != null && target.getPokemons()[i].getName().equals(targetMon.getName())) {
                    target.getPokemons()[i] = null; //gets rid of dead mon
                    if (target == enemy && target.getPokemons()[i+1] != null) { //if enemyMon is dead then bring out next enemyMon
                        enemyBattleMon = target.getPokemons()[i+1];
                    }
                    checkLoser(target);
                }
            }
            if (target == you && inProgress == true) {
                System.out.println("The battle isn't over yet! Choose your next battle pokemon: ");
                switchMon(input.next());
            }
        }
    }

    public void checkLoser(Trainer target) {        //checks if a player has no mons left
        boolean noMonsLeft = true;
        for (Pokemon mon: target.getPokemons()) {
            if (mon != null) {
                noMonsLeft = false;
            }
        }
        if (noMonsLeft == true) {
            System.out.println(target.getName() + " loses!");
            System.out.println("-----GAME OVER-----");
            inProgress = false;     //updates inProgress to false so game stops
        }

    }

    public void displayInfo() {     //displays both players' info
        System.out.println();
        you.displayInfo();
        System.out.println();
        enemy.displayInfo();
        System.out.println();
    }

    public void start() {   //start() is non-static method so only instances of Game can use it

        //create trainers & mons, then display initial info
        System.out.print("Type your name: ");
        String yourName = input.next();

        System.out.print("A trainer can have 2 or 3 pokemon. How many pokemon do you want?: ");
        int numPokemon = input.nextInt();
        while (numPokemon > 3 || numPokemon < 2) {
            System.out.print("Entered invalid number of pokemon. How many pokemon do you want?: ");
            numPokemon = input.nextInt();
        }

        Pokemon[] yourMons = new Pokemon[numPokemon];
        for (int i = 0; i < numPokemon; i++) {
            System.out.print("Name your pokemon: ");
            String monName = input.next();
            yourMons[i] = new Pokemon(monName, getRandNum("hp"), getRandNum("atk"));
        }
        you = new Trainer(yourName, yourMons);

        Pokemon[] enemyMons = new Pokemon[numPokemon];
        for (int i = 0; i < numPokemon; i++) {
            String monName = "Pokemon" + (i+1);
            enemyMons[i] = new Pokemon(monName, getRandNum("hp"), getRandNum("atk"));
        }
        enemy = new Trainer("Enemy", enemyMons);

        displayInfo();

        yourBattleMon = yourMons[0];
        enemyBattleMon = enemyMons[0];

        System.out.println("Your battle pokemon is " + yourBattleMon.getName());
        System.out.println("Enemy battle pokemon is " + enemyBattleMon.getName());

        while (inProgress == true) {
            System.out.print("Choose switch or attack: ");
            String choice = input.next();
            while (!choice.equals("switch") && !choice.equals("attack")) {
                System.out.print("Entered invalid choice. Choose switch or attack: ");
                choice = input.next();
            }

            if (choice.equals("switch")) {
                System.out.print("Choose a new battle pokemon: ");
                switchMon(input.next());
            } else {   //choice is attack
                attackMon(yourBattleMon, enemyBattleMon);
                checkDeath(enemy, enemyBattleMon);
            }

            attackMon(enemyBattleMon, yourBattleMon);
            checkDeath(you, yourBattleMon);

        }
    }

}


