class Game2{

    public static void main(String arg[])
    {
        Human human1 = new Human();
        Human human2 = new Human();
        Human.numberOfEyes = 1;
        human1.name = "John";
        human1.height = 7;
        human1.weight = 80;
        human2.name = "Mary";
        human2.height = 5;
        human2.weight = 60;
        human1.say(2);
        human2.say(1);
        human1.say(3);
        human2.say(4);
    }
}