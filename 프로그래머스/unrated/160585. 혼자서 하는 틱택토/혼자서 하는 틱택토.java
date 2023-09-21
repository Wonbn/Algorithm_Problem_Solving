import java.util.*;

class Solution {
    public int solution(String[] board) {
        StringBuilder sb;
        int countX = 0;
        int countO = 0;
        
        for(String s : board) {
            for(char c : s.toCharArray()) {
                if(c == 'X') countX++;
                if(c == 'O') countO++;
            }
        }
        
        if(countX > countO || (countO - countX) > 1) return 0;
        
        // win
        boolean fWin = false;
        boolean sWin = false;
        for(String s : board) {
            if(s.equals("OOO")) fWin = true;
            if(s.equals("XXX")) sWin = true;
        }
        
        for(int i = 0; i < 3; i++) {
            sb = new StringBuilder();
            for(int j = 0; j < 3; j++) {
                char c = board[j].charAt(i);
                sb.append(c);
            }
            if(sb.toString().equals("OOO")) fWin = true;
            if(sb.toString().equals("XXX")) sWin = true;
        }
        
        sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            sb.append(board[i].charAt(i));   
        }
        if(sb.toString().equals("OOO")) fWin = true;
        if(sb.toString().equals("XXX")) sWin = true;
        
        sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            sb.append(board[i].charAt(2-i));   
        }
        if(sb.toString().equals("OOO")) fWin = true;
        if(sb.toString().equals("XXX")) sWin = true;
        
        if(fWin) {
            if(sWin) return 0;
            else {
                if(countX == countO) return 0;
            }
        } else {
            if(sWin) {
                if(countX != countO) return 0;
            }
        }
        
        return 1;
    }
}