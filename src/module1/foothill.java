/*
 * Copyright (C) 2016 Aidan Lloyd-Tucker
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package module1;

/**
 *
 * @author aidan
 */
public class foothill
{

   public static void main(String[] args)
   {
      System.out.println("TESTING CARD CLASS\n");
      testCardClass();
      System.out.println("\nTESTING HAND CLASS\n");
      testHandClass();
   }
   public static void testCardClass()
   {
      Card[] cardArray = {new Card(), new Card('Z', Card.Suit.clubs), new Card('Q', Card.Suit.hearts)};
      for (Card card : cardArray) {
         System.out.println(card);
      }
      System.out.println("CHANGING VALUES");
      cardArray[0].set('L', Card.Suit.spades);
      cardArray[1].set('K', Card.Suit.diamonds);
      for (Card card : cardArray) {
         System.out.println(card);
      }
   }
   public static void testHandClass()
   {
      Hand hand = new Hand();
      System.out.println("Filling Hand");
      for (int i = 0; i < 10; i++) {
         hand.takeCard(new Card('Q', Card.Suit.clubs));
         hand.takeCard(new Card('T', Card.Suit.spades));
         hand.takeCard(new Card('5', Card.Suit.diamonds));
         hand.takeCard(new Card('A', Card.Suit.hearts));
         hand.takeCard(new Card('K', Card.Suit.diamonds));
      }
      System.out.println("Printing Hand: " + hand);
      System.out.println("Hand has " + hand.getNumCards() + " cards");
      System.out.print("Overflowing Hand: ");
      String resultOfHandOverflow = hand.takeCard(new Card('Q', Card.Suit.clubs)) ? "Success. Can overflow hand" : "Failed. Cannot overflow hand";
      System.out.println(resultOfHandOverflow);
      System.out.println("Inspect Card");
      System.out.println("Error Inspect: " + hand.inspectCard(hand.MAX_CARDS + 50));
      System.out.println("Good Inspect: " + hand.inspectCard(hand.getNumCards() - 10));
      System.out.println("Playing Cards");
      // You have to declare your own var or else the for loop will recalculate the number of cards every time and you will only remove 1/2.
      int numCards = hand.getNumCards();
      for (int i = 0; i < numCards; i++) {
         System.out.println("Playing Card: " + hand.playCard());
      }
      System.out.println("Printing Hand: " + hand);
      System.out.println("Hand has " + hand.getNumCards() + " cards");
   }
}
