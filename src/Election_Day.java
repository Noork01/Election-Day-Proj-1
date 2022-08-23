

public class Election_Day {
	
	public static int num_voters = 20;
	public static int num_ID_checkers = 3;
	public static int num_k = 3;
	public static int num_sh = 2;
	
	public static void main(String[] args) {

		System.out.println("["+(System.currentTimeMillis()-System.currentTimeMillis())+"] "+": Program Start");

		//create and starts student threads which in turn create and start family threads
		for (int i = 1; i <= num_voters; i++) {
		    Voters voter = new Voters(Integer.toString(i));
		    voter.start();
		}
		for (int i = 1; i <= num_ID_checkers; i++) {
			ID_checkers ID_checker = new ID_checkers(Integer.toString(i));
		    ID_checker.start();
		}	
		
		Kiosk_helper kioskHelper = new Kiosk_helper();
		kioskHelper.start();
		
		for (int i = 1; i <= num_sh; i++) {
			Scanning_helpers scanningHelper = new Scanning_helpers(Integer.toString(i));
			scanningHelper.start();
		}
		

	}

}
