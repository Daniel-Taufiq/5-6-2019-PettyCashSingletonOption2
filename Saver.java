public class Saver implements Runnable	// runnable doesnt have advertise, must use try catch
{
	// run method contains loop and runs forver

	//private PettyCash pettyCash;	// 1 ref to pettyCash giving to multiple objs


	public Saver(PettyCash pettyCash)
	{
	}

	public void run()
	{
		PettyCash pettyCash;
		pettyCash = PettyCash.getInstance();
		boolean done;
		int amount;	// write in way it fails, early on for demo

		done = false;
		while(!done)
		{
			try
			{
				amount = random(4) + 1;
				Thread.sleep(500);
				pettyCash.add(amount);	// keep putting random amounts of money in
			}
			catch(InterruptedException ie)
			{
				done = true;
				//System.out.println(ie.getMessage());
			}
		}
	}

	private static int random(int x) { return (int)(Math.random() * x); }
}