abstract class Entity {
    private static int count = 0; //total count of entities created

    public abstract void displayInfo();

    public static void updateCount() {
        count = count + 1;
    }

    public static int getCount() {
        return count;
    }

}

