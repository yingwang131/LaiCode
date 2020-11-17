package Node;
import java.util.*;
public class CardGame {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
//System.out.println("ID001");
        String[] deck=makeDeck();
        String [] sDeck=shuffleDeck(deck);
        int choose = 0;
        boolean successfulinput = false;

// loop {


        // Ask the user which part they want to do
        System.out.println("Choose a play style: 1. man vs computer "
                + "2. computer vs computer");
        choose = input.nextInt();

        do {
            // if the user chooses part 1 {
            switch(choose) {
                case 1:{
                    makeDeck();
                    shuffleDeck(deck);
// get the user choice and the computer's choice
                    System.out.println("Pick up a card from 1 to 52");
                    int humanValue = input.nextInt();
// Make sure the choices are valid. The user should not
                    // be able to enter card 150000.
//   String
                    if (choose > 52) {
                        break;
                    }
//Computer generate Card
                    int computerValue = (int)(Math.random()*52);
                    System.out.println(computerValue);
                    int winner = declareWinner(humanValue, computerValue);

                    if (winner == 0)
                    {
                        System.out.println("This game is tie");
                    }
                    if (winner == 1)
                    {
                        System.out.println("User win the game");
                    }
                    else
                    {
                        System.out.println("Computer win the game");
                    }
                    break;
                }
                case 2:{
                    makeDeck();
                    shuffleDeck(deck);
                    int  computerAlphaValue = (int)(Math.random()*53);
                    int  computerBetaValue = (int)(Math.random()*53);

                }
            }
        }while(choose == 1 || choose == 2);
    }
    public static String[] makeDeck(){
        String[] suits={"diamond","clubs","hearts","spades"};
        String[]ranks={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
        // You have the suits and the rank,
        // How do you put them as strings?
        // How do you easily make all the combinations of them?
        String[] sortedDeck = new String[52];
        int a = 0;
        for(int i = 0; i< ranks.length; i++) {
            for (int j = 0; j< 4; j++) {
                String suit = suits[j];
                String rank = ranks[i];
                sortedDeck[a] = rank + " of "  + suit;
                a++;
            }
        }

        return sortedDeck;
    }

    public static String[] shuffleDeck(String [] deck){
        String[] shuffled=new String[52];
        // You need to shuffle the array
        for (int i = 0; i< deck.length; i++) {
            shuffled[i] = deck[i];
        }

        for(int i = 0; i< 100; i++) {
            int index1 = (int)(Math.random()*deck.length);
            int index2 = (int)(Math.random()*deck.length);
            String temp = shuffled[index1];
            shuffled[index1] = shuffled[index2];
            shuffled[index2] = temp;
        }
        return shuffled;
    }

    public  static int declareWinner(int value1, int value2) {

        String[] orderedDeck = makeDeck();
        String[] deck = shuffleDeck(orderedDeck);
        //compare suit

        String card1 = deck[value1];
        String card2 = deck[value2];

        int compare1 = searchCard(card1);
        int compare2 = searchCard(card2);
//To against same card, the value2, or computer, will randomly pick another card
        if (compare1 == compare2)
        {
            return 0;
        }
        else if (compare1 > compare2)
        {
            return 1;

        }else {
            return 2;

        }
        //else: compare rank
        //if suit computerValue > suit humanValue
        //print: computer win
        //else : human win

    }

    public static int searchCard(String card){
        String[] orderedDeck = makeDeck();
        int index = 0;
        for (int i = 0; i < orderedDeck.length; i++)
        {
            if(orderedDeck[i].equals(card))
            {
                index = i;
            }
        }

        return index;
    }
}
