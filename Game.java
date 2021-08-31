//Name: Itai Steiner
import javax.swing.JOptionPane;

public class Game {
	private Deck _deck;
	private Player _dealer, _player;
	private int nextCardToDeal = 0; 
	private static boolean continueDeal = true;

	public static void main(String[] args) {

		Game blackJack = new Game();
		blackJack.startGame();
		System.out.println("\nDEALER cards: ");
		blackJack._dealer.printCards();
		blackJack.getTotalFor(blackJack._dealer); //printing total value of cards, just to reduce amount of code.
		continueDeal = blackJack.bjOrOver(blackJack._dealer.getTotal()); //Checking if total value is over 21 or 21, again, to reduce amout of code.
		if (continueDeal){ //Will not deal if dealer got black jack
			System.out.println("\nYOUR cards: ");
			blackJack._player.printCards();
			blackJack.getTotalFor(blackJack._player);
			continueDeal = blackJack.bjOrOver(blackJack._player.getTotal());
		}
		while ((continueDeal) && (JOptionPane.showConfirmDialog(null, "Would you like another card?") == 0)){
			blackJack.hit(blackJack._player);
			System.out.println("\nYOUR cards: ");
			blackJack._player.printCards();
			blackJack.getTotalFor(blackJack._player);
			continueDeal = blackJack.bjOrOver(blackJack._player.getTotal());
		}	
		while ((continueDeal)&&(blackJack._dealer.getTotal()<17)){ //Dealer won't take cards if total over 17
			blackJack.hit(blackJack._dealer);
			System.out.println("\nDEALER cards: ");
			blackJack._dealer.printCards();
			blackJack.getTotalFor(blackJack._dealer);
			continueDeal = blackJack.bjOrOver(blackJack._dealer.getTotal());
		}
		blackJack.whoWon();
	}

	public Game(){
		_deck = new Deck();	
		_dealer = new Player();
		_player = new Player();
	}

	public void startGame(){
		for (int i=0; i<4; i++){
			if (i<2){
				_dealer.takeCard(_deck.getCard(nextCardToDeal));
				nextCardToDeal++;
			}
			else {
				_player.takeCard(_deck.getCard(nextCardToDeal));
				nextCardToDeal++;
			}
		}
	}

	public void hit(Player player){
		player.takeCard(_deck.getCard(nextCardToDeal));
		nextCardToDeal++;
	}

	public void whoWon(){
		if (this._dealer.getTotal() > this._player.getTotal() && this._dealer.getTotal() < 22)
			System.out.println("\nI win, better luck next time.");
		if (this._dealer.getTotal() < this._player.getTotal() && this._player.getTotal() < 22)
			System.out.println("\n*** Congratulations, you win! ***");
		if (this._dealer.getTotal() == this._player.getTotal() && this._dealer.getTotal() < 22)
			System.out.println("Draw, nobody win.");
		if (this._dealer.getTotal() > 21)
			System.out.println("You won.");
		if (this._player.getTotal() > 21)
			System.out.println("I win.");
	}

	public boolean bjOrOver(int totalHand){
		if (totalHand == 21){
			System.out.println("-------BLACKJACK!!!-------");
			return false;
		}
		if (totalHand > 21){
			System.out.println("-------Over 21.-------");
			return false;
		}
		return true;
	}

	public void getTotalFor(Player player){
		System.out.println("\nTotal: "+player.getTotal());
	}
}