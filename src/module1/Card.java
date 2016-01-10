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
public class Card
{

   // Static enum for the suit
   public static enum Suit
   {

      clubs, diamonds, hearts, spades
   };
   private char value;
   private Suit suit;
   private boolean errorFlag;
   // Regular init
   public Card(char value, Suit suit)
   {
      if (!isValid(value, suit)) {
         this.errorFlag = true;
      }
      this.value = value;
      this.suit = suit;
      this.errorFlag = false;
   }
   // If nothing is provided, use the regular init with an Ace of Spades
   public Card()
   {
      this('A', Suit.spades);
   }
   // An easy way to create a bad card. It just uses the default values and then changes the flag.
   public Card(boolean errorFlag)
   {
      this();
      this.errorFlag = errorFlag;
   }
   // If error, send invalid. Else, send the value and suit
   @Override
   public String toString()
   {
      if (errorFlag) {
         return "[ invalid ]";
      }
      return this.value + " of " + this.suit;
   }
   // Set the value and suit and then check if valid. If it isnt, set the error flag
   public boolean set(char value, Suit suit)
   {
      this.value = value;
      this.suit = suit;
      if (!isValid(value, suit)) {
         this.errorFlag = true;
         return false;
      } else {
         this.errorFlag = false;
         return true;
      }
   }
   // Accessors
   public char getValue()
   {
      return this.value;
   }
   public Suit getSuit()
   {
      return this.suit;
   }
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   // Compares this card and a given card
   // TODO: make a static method that compares two cards given
   public boolean equals(Card card)
   {
      return (this.suit == card.getSuit() && this.value == card.getValue() && this.errorFlag == card.getErrorFlag());
   }
   // Checks if the value is either a digit (2..9) or (A, J, Q, K, T)
   private boolean isValid(char value, Suit suit)
   {
      if ((Character.isDigit(value) && value != '0' && value != '1') || value == 'A' || value == 'J' || value == 'Q' || value == 'K' || value == 'T') {
         return true;
      }
      return false;
   }
}
