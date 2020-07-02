public class Spender implements Runnable
{
	// dont need this for Singleton
	//private PettyCash pettyCash;

// also delete parameters
	public Spender()
	{

	}

	public void run()
	{
		boolean done;
		int amount;
		PettyCash pettyCash;
		pettyCash = PettyCash.getInstance();
		done = false;
		while(!done)
		{
			try
			{
				amount = pettyCash.getBalance();	// get balance sand store in local variable, then sleep for awhile because it might change while sleeping
				Thread.sleep(500);
				amount = (3 * amount) / 4;

				if(amount != 0)	// cant take out if money is equal than 0 amount
				{
					pettyCash.testAndTake(amount);
				}

			}
			catch(InterruptedException ie)
			{
				done = true;
			}
		}
	}
}