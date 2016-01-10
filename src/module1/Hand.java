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
public class Hand
{

   public final int MAX_CARDS = 50;
   private Card[] myCards;
   private int numCards;
   // Init
   Hand()
   {
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }
   public void resetHand()
   {
      this.myCards = new Card[MAX_CARDS];
      this.numCards = 0;
   }
   // Check if you can add a new card. If so, add a new card to deck
   public boolean takeCard(Card card)
   {
      if (this.numCards == MAX_CARDS) {
         return false;
      }
      this.myCards[this.numCards] = card;
      this.numCards++;
      return true;
   }
   // Check if you can play a card. If not, send an error card.
   public Card playCard()
   {
      if (this.numCards == 0) {
         return new Card(true);
      }
      // Saves copy of card and then sets the place in the array to null
      Card card = this.myCards[this.numCards - 1];
      this.myCards[this.numCards - 1] = null;
      this.numCards--;
      return card;
   }
   @Override
   public String toString()
   {
      // Formats list of non-null cards as an array looking string
      String retString = "[";
      for (int i = 0; i < this.myCards.length; i++) {
         if (this.myCards[i] == null) {
            continue;
         }
         if (i != 0) {
            retString += ", ";
         }
         retString += this.myCards[i];
      }
      retString += "]";
      return retString;
   }
   // Accessor
   public int getNumCards()
   {
      return this.numCards;
   }
   // Return card to look at it further. If k is a bad int, return an error card
   public Card inspectCard(int k)
   {
      if (k >= this.numCards || k < 0) {
         return new Card(true);
      }
      return myCards[k];
   }
}
