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
package module2;

import module1.Card;

/**
 *
 * @author Aidan Lloyd-Tucker
 */
public class Deck
{

   public final int MAX_CARDS = 6 * 52;
   private static Card[] masterPack;
   private Card[] cards;
   private int topCard;
   private int numPacks;
   Deck(int numPacks)
   {
      this.numPacks = numPacks;
      Deck.masterPack = new Card[52];
      allocateMasterPack();
   }
   Deck()
   {
      this(1);
   }
   public void init(int numPacks)
   {
   }
   public int getTopCard()
   {
      return this.topCard;
   }
   static void allocateMasterPack()
   {
      char[] valueArr = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < valueArr.length; j++) {
            masterPack[i * valueArr.length + j] = new Card(valueArr[j], Card.Suit.values()[i]);
         }
      }
   }
}
