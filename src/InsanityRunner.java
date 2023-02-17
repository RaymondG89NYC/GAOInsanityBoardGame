import java.util.*;
public class InsanityRunner {
    public static void main(String[] args){
//        System.out.println("\uD83D\uDFE6");
//        System.out.println("\uD83D\uDFE5");
//        System.out.println("\uD83D\uDFE6".equals("🟦"));
        Scanner input = new Scanner(System.in);
        Insanity game = new Insanity();

        while(!game.WinCheck()){
            System.out.println(game.getBoard());
            System.out.println(game.getNumbers());
            System.out.print("Pick an element to move: ");
            int element = input.nextInt()-1;
            game.move(element);
        }
        game.Win();

    }
}
