import java.lang.reflect.Array;
import java.util.ArrayList;

public class Insanity {
    private ArrayList<String> game = new ArrayList<String>();
    private ArrayList<String> numbers = new ArrayList<String>();
    public Insanity(){
        //Red
        game.add("\uD83D\uDFE5");
        game.add("\uD83D\uDFE5");
        game.add("\uD83D\uDFE5");
        game.add("\uD83D\uDFE5");
        //Blanks
        game.add("⬛");
        game.add("⬛");
        //Blue
        game.add("\uD83D\uDFE6");
        game.add("\uD83D\uDFE6");
        game.add("\uD83D\uDFE6");
        game.add("\uD83D\uDFE6");

        for(int i = 0; i < 10; i++){
            numbers.add(" " + (i+1));
        }
    }
    public void move(int element){
        int check = moveCheck(element);
        if(check==0){
            System.out.println("This piece doesn't have anywhere to go");
        }
        //Red move right
        else if(check==1){
            String piece = game.set(element, "⬛");
            game.set(element+1, piece);
        }
        //Red hop right
        else if(check==2){
            String piece = game.set(element, "⬛");
            game.set(element+2, piece);
        }
        //BLue move left
        else if(check==3){
            String piece = game.set(element, "⬛");
            game.set(element-1, piece);
        }
        //Blue hop left
        else if(check==4){
            String piece = game.set(element, "⬛");
            game.set(element-2, piece);
        }
    }
    public int moveCheck(int element){
        String piece = game.get(element);
        //Red
        if(piece.equals("\uD83D\uDFE5")){
            if(element == game.size()-1){
                return 0;
            }
            else{
                if(game.get(element+1).equals("⬛")){
                    return 1;
                }
                if(!game.get(element+1).equals("⬛") && game.get(element+2).equals("⬛")){
                    return 2;
                }
                else{
                    return 0;
                }
            }
        }
        //Blue
        else if(piece.equals("🟦")){
            if(element == 0){
                return 0;
            }
            else{
                if(game.get(element-1).equals("⬛")){
                    return 3;
                }
                if(!game.get(element-1).equals("⬛") && game.get(element-2).equals("⬛")){
                    return 4;
                }
                else{
                    return 0;
                }
            }
        }
        else{
            return 0;
        }
    }
    public boolean WinCheck(){
        for(int i = 0; i < game.size(); i++){
            if(i <= 5){
                if(!game.get(i).equals("🟦")){
                    return false;
                }
            }
            if(i >= 6){
                if(!game.get(i).equals("\uD83D\uDFE5")){
                    return false;
                }
            }
        }
        return true;
    }
    public void Win() {
        System.out.println("YOU WIN!!! Good job!");
    }
    public ArrayList<String> getBoard(){
        return game;
    }
    public ArrayList<String> getNumbers(){
        return numbers;
    }
}
