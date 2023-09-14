class Game4{

    public static void main(String args[])
    {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        numberOfLegs = 4;
        numberOfEars = 2;
        cat1.name="Jim";
        cat2.name="Lily";
        System.out.println("Cat with name" + cat1.name + "action is");
        System.out.println("Cat with name" + cat2.name + "says");
        cat1.catAction(2);
        cat2.catAction(1);
    }
}