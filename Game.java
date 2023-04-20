import java.util.Scanner;
public class Game {
    
    int [][] wins = {{ 0, 1, 2 },{ 3, 4, 5 },{ 6, 7, 8 },{ 0, 3, 6 },{ 1, 4, 7 },{ 2, 5, 8 },{ 0, 4, 8 },{ 2, 4, 6 }};
    int [] board = {0,0,0,  0,0,0,  0,0,0};
    boolean finished = false;
    int activePlayer = 1;
    int moveNum = 0;
    int winner = 0;
    char [] players = {' ','X', 'O'};
    Scanner in = new Scanner(System.in);
    void CreateGame(){
        while (!finished){
            showBoard();
            boolean tie = full();
            if(tie){System.out.println("Empate"); break;}
            if(move(in.nextInt(),activePlayer)){
                boolean win = checkWinner();
                if(win){showBoard(); System.out.println("Gano "+activePlayer);  break;}
                if(activePlayer==1)activePlayer = 2;
                else activePlayer = 1;
            }else{
                System.out.println("Movimiento no valido");
            }
        }
    }
    boolean checkWinner(){
        for (int i = 0; i < wins.length; i++) {
            if(board[wins[i][0]] == activePlayer && board[wins[i][1]] == activePlayer && board[wins[i][2]] == activePlayer)return true;
        }
        return false;
    }
    void showBoard(){
        System.out.println(players[board[0]]+"|"+players[board[1]]+"|"+players[board[2]]);
        System.out.println("- - -");
        System.out.println(players[board[3]]+"|"+players[board[4]]+"|"+players[board[5]]);
        System.out.println("- - -");
        System.out.println(players[board[6]]+"|"+players[board[7]]+"|"+players[board[8]]);
    }
    boolean move(int square,int Player){
        if(board[square - 1] != 0) return false;
        board[square - 1] = Player;
        moveNum++;
        return true;
    }
    boolean full(){
        if(moveNum ==9 )return true;
        else return false;
    }
}
