package com.example;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
public class Card {
    enum Suit{
        Spade("スペード",1,2,3,4,5,6,7,8,9,10,11,12,13),
        Diamond("ダイヤ ",1,2,3,4,5,6,7,8,9,10,11,12,13),
        Heart("ハート ",1,2,3,4,5,6,7,8,9,10,11,12,13),
        Club("クラブ ",1,2,3,4,5,6,7,8,9,10,11,12,13);
        String mark;
        int[] number;
        Suit (String mark,int... number){
              this.mark = mark;
              this.number = number; 
        }
    }

   public ArrayDeque<String> queue = new ArrayDeque<String>(52);
   public ArrayList<String> list = new ArrayList<String>(52);
    public ArrayDeque<String> setDeck(){
        
        for(int i = 0; i < 13;i++){
              queue.add(Suit.Spade.mark+"の"+String.valueOf(Suit.Spade.number[i]));
        }
        for(int i = 0; i < 13;i++){
              queue.add(Suit.Diamond.mark+"の"+String.valueOf(Suit.Diamond.number[i]));
        }
        for(int i = 0; i < 13;i++){
              queue.add(Suit.Heart.mark+"の"+String.valueOf(Suit.Heart.number[i]));
        }
        for(int i = 0; i < 13;i++){
              queue.add(Suit.Club.mark+"の"+String.valueOf(Suit.Club.number[i]));
        }
        for(int i = 0; i < 13;i++){
        list.add(i, queue.pollFirst());
        }
        for(int i = 0; i < 13;i++){
        list.add(i, queue.pollFirst());
        }
        for(int i = 0; i < 13;i++){
        list.add(i, queue.pollFirst());
        }
        for(int i = 0; i < 13;i++){
        list.add(i, queue.pollFirst());
        }
        Collections.shuffle(list);
        for(int i = 0; i < 52;i++){
        queue.add(list.get(i));
        }
        return queue;
    }

    
    
}

