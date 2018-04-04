object Spawn
{
	def main(args: Array[String]): Unit =
	{
		(new ThreadA).start
	}
	class ThreadA extends Thread
	{
		override def run(): Unit = sys.error("Test error thread")
	}
}