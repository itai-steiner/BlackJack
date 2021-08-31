//Name: Itai Steiner

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	public static final int DECK_SIZE = 52;
	ArrayList<Card> _list;

	public Deck(){
		_list = new ArrayList<Card>(DECK_SIZE); 
		this.addCards();

	}

	public void addCards(){
		Random rand = new Random();
		for (int i= 0; i<= DECK_SIZE; i++){
			int cardNum = rand.nextInt(13)+1;
			Card currentCard = new Card(cardNum);
			_list.add(currentCard);
		}

	}

	public Card getCard(int num){
		return this._list.get(num);
	}
}
