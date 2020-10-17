public class Song {
    public static void main(String[] args){
        intro();
        first();
        second();
        third();
        fourth();
        fifth();
        sixth();
    }
    public static void intro(){
        System.out.println("There was an old woman who swallowed a fly.");
        drawPerhaps();     
    }

    public static void first(){
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        spiderFly();
    }
     public static void second(){
         System.out.println("There was an old woman who swallowed a bird,");
         System.out.println("How absurd to swallow a bird.");
         birdSpider();
     }
     public static void third(){
         System.out.println("There was an old woman who swallowed a cat,");
         System.out.println("Imagine that to swallow a cat.");
         catBird();
     }
     public static void fourth(){
         System.out.println("There was an old woman who swallowed a dog,");
         System.out.println("What a hog to swallow a dog.");
         dogCat();
     }
     public static void fifth(){
         System.out.println("There was an old woman who swallowed a zebra,");
         System.out.println("Born in september they called her a libra.");
         System.out.println("She swallowed the zebra to catch the dog,");
         dogCat();

     }
     public static void sixth(){
         System.out.println("There was an old woman who swallowed a horse,");
         System.out.println("She died of course.");
     }
     public static void drawPerhaps(){
         System.out.println("I don't know why she swallowed that fly,");
         System.out.println("Perhaps she'll die.");
         System.out.println();
     }
     public static void spiderFly(){
         System.out.println("She swallowed the spider to catch the fly,");
         drawPerhaps();
     }
     public static void birdSpider(){
         System.out.println("She swallowed the bird to catch the spider,");
         spiderFly();
     }
     public static void catBird(){
         System.out.println("She swallowed the cat to catch the bird,");
         birdSpider();
     }
     public static void dogCat(){
         System.out.println("She swallowed the dog to catch the cat,");
         catBird();
     }
}
