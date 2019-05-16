
import rooms.*;
import frames.*;

/**
 * to-do: 
 * check in and out
 * resrevation is cancelled if the whole entire tiem lot is not open
 */

public class Main {
	public static void main ( String [ ] args ) {
		PartyWorld rooms = new PartyWorld ( );
		new MainFrame ( rooms );
	}
}
