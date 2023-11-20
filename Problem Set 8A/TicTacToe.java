import java.util.Scanner;
public class TicTacToe{
    static Scanner input = new Scanner(System.in);
    static String[][] board = new String[3][3];
    static int round = 0;
    static boolean gameWon = false;
    static boolean gameOver = false;
    static boolean isX = true;
    
    public static void main(String[]args){
        makeBoard();
        printBoard();
        while(!gameOver){
            if(!gameWon && round<10){
               playRound();   
            }else{
                playAgain();
            }
        }  
        
    }
   
    public static void makeBoard() {
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[0].length; col++){
                board[row][col] = "[ ]";
            }
        }
    }

    public static void printBoard() { 
        if(gameWon == false){
            round++;   
            System.out.print("Round " +round+":");
        }
        System.out.println();
        for(int row = 0; row<board.length;row++){
            for(int col = 0; col<board[0].length;col++){
                System.out.print(board[row][col]);
            } 
             System.out.println();
        }
        if(!gameWon)move();
    }
    
    public static void move(){
        if(isX){
            System.out.print("X, make your move (row,col):");
        }else{
            System.out.print("O, make your move (row,col):");
        }
    }
    
    public static void playRound() {
        //move input
        String move = input.nextLine();
        int r = Integer.parseInt(move.substring(0,1));
        int c = Integer.parseInt(move.substring(2,3));
        
        //checks if move is valid
        boolean valid = true;
        if(r>2||c>2||!board[r][c].equals("[ ]")){
            valid = false;
        }  
          
         if(!valid){
                System.out.println();
                System.out.println("*ERROR INVALID MOVE*");
                System.out.println();
                round--;
                printBoard();
            }else{
                if(isX){
                    board[r][c] = "[x]";  
                    isX = false;
                    gameWon("[x]");
                }else{
                    board[r][c] ="[O]";
                    isX = true;
                    gameWon("[O]");
                }
                System.out.println();
                win();  //checks if game has ended 
        }  
     }
     
    public static void gameWon(String player){
        // Check rows
        if (board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player)) gameWon = true;
        if (board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player)) gameWon = true;
        if (board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player)) gameWon = true;

        // Check columns
        if (board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player)) gameWon = true;
        if (board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player)) gameWon = true;
        if (board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player)) gameWon = true;

        // Check diagonals
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) gameWon = true;
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) gameWon = true;
    }
     
     public static void win(){
        if(gameWon){
           System.out.print("YOU WON!"); 
           printBoard();
           System.out.print("Play again? Y/N ");
        }else if(!gameWon && round == 9){
            System.out.print("TIE GAME!");
            gameWon = true;
            printBoard();
            System.out.print("Play again? Y/N ");
        }else{
            printBoard();
        }  
     }
     
     public static void playAgain(){
         String ans = input.nextLine().toLowerCase(); 
         if(ans.equals("y")){
            gameOver = false;
            System.out.println();
            reset();
         }
         else if (ans.equals("n")){
             gameOver = true; 
         }else{
             System.out.println("I'm too tired for this...");
             gameOver = true;
         }
         
     }
     
     public static void reset(){
         gameWon = false;
         isX = true;
         round = 0;
         makeBoard();
         printBoard();  
     }
    
}