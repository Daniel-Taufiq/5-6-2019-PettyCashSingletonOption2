public class Driver
{
	public static void main(String[] args) throws InterruptedException
	{
		// create one object of petty cash
		// create spenders and savers

		// each implements Runnable
		Saver saver;		// no state in them, can use as much as I want
		Spender spender;	// no state in this one either
		//PettyCash pettyCash;
		Thread[] threads;

		//pettyCash = new PettyCash();	// only need 1 of this so spender and saver use only this object

		// create thread
		threads = new Thread[]
		{
			new Thread(new Saver(PettyCash.getInstance())),
			new Thread(new Spender()),
			new Thread(new Spender())
		};

		for(int i = 0; i < threads.length; i++)
		{
			threads[i].start();
		}
		Thread.sleep(10000);

		for(int i = 0; i < threads.length; i++)
		{
			threads[i].interrupt();
		}


	}
}