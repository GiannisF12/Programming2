class Game{

    public static void main(String args[])
    {
        Cat cat = new Cat();
        numberOfLegs = 4;
        numberOfEars = 2;
        cat.name="Jim";

        System.out.println("When the cat with name" + cat.name + "is hungry say");
        cat.catAction(1);
        System.out.println("But when the cat wants caresses say");
        cat.catAction(2);

    }
}