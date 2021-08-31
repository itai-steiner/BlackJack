//Name: Itai Steiner
public class Player {

	static private final int HAND_SIZE = 11;
	private Card[] _playerHand;
	private int _currentNumOfCards;

	public Player(){
		_playerHand= new Card[HAND_SIZE];
		_currentNumOfCards = 0;
	}

	public void takeCard(Card card){
		this._playerHand[_currentNumOfCards] = card;
		_currentNumOfCards++;
	}

	public void printCards(){
		for (int i=0; i<_currentNumOfCards; i++)
			if ((_playerHand[i].getNum() == 1) || (_playerHand[i].getNum() > 10))
					System.out.print("-"+_playerHand[i].getName()+"- ");
			else System.out.print("-"+_playerHand[i].getNum()+"- ");
	}

	public int getTotal(){
		int _total = 0, ace = 0;
		for(int i=0; i<_currentNumOfCards; i++){
			if (_playerHand[i].getValue() == 1)
				ace += ace+1;
			else 
				_total += _playerHand[i].getValue();
		}
		for (int j = 0; j<ace; j++){
			if ((_total + 11) < 22)
				_total += 11;
			else _total += 1;
		}
		return _total;
	}
}
