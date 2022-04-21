package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */

  public  Evaluation evaluate(String board){
     String lowerboard = board.toLowerCase();
     int countx = 0;
     int counto = 0;
      if(lowerboard.length() != 9){
        return Evaluation.invalidState;
      }
      
      for(int i=0;i<lowerboard.length();i++){
        if(lowerboard.charAt(i) == 'x'){
          countx++;
        }else if(lowerboard.charAt(i) == 'o'){
          counto++;
          }
      }
      if(Math.abs(countx-counto) >=2){
        return Evaluation.UnreachableState;
      }
      boolean xWins = win_conditions('x',lowerboard);
      boolean oWins = win_conditions('o',lowerboard);

      if(xWins && oWins){
        return Evaluation.UnreachableState;
      }else if(!xWins && !oWins){
        return Evaluation.NoWinner;
      }else if(xWins){
        return Evaluation.Xwins;
      }else if(oWins){
        return Evaluation.Owins;
      }
    return Evaluation.UnreachableState;

  }
  public TicTacToeBoard(String board) {
     
  }
   
  
  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public static boolean win_conditions(char checker, String boardState) {
    for(int i=0;i<7;i+=3){
      if(boardState.charAt(i) == checker && boardState.charAt(i+1) == checker && boardState.charAt(i+2) == checker){
        return true;
      }
    }
    for(int i=0;i<3;i++){
      if(boardState.charAt(i) == checker && boardState.charAt(i+3) == checker && boardState.charAt(i+6) == checker){
        return true;
      }
    }
    if(boardState.charAt(0) == checker && boardState.charAt(4) == checker && boardState.charAt(8) == checker){
      return true;
    }
    return (boardState.charAt(2) == checker && boardState.charAt(4) == checker && boardState.charAt(6) == checker);
          
    
    
  }
}
