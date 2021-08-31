//Name: Itai Steiner
public class Card {

	private int _num, _value;
	private String _name;

	public Card(int num){
		_num = num;
		if (num < 10)
			_value = num;
		else _value = 10;
		if (num == 1)
			_name = "ACE";
		if (num == 11)
			_name = "JACK";
		if (num == 12)
			_name = "QUEEN";
		if (num == 13)
			_name = "KING";
	}

	public int getNum(){
		return this._num;
	}
	
	public int getValue(){
		return this._value;
	}
	
	public String getName(){
		return this._name;
	}
}
