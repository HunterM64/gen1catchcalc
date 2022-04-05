import scala.io.StdIn.readLine
object Calculator {


  def main(args: Array[String]):Unit = {
  
    // get pokeball used
    val ball = getBall();
    var n = 0;
    ball match {
      case 1 => n = scala.util.Random.nextInt(256);
      case 2 => n = scala.util.Random.nextInt(201);
      case 3 => n = scala.util.Random.nextInt(151);
      case 4 => println("You will catch it!");return;
      case _ => println("Error: Invalid ball");return;
    }

    // get status
    val status = getStatus();
    var s = 0;
    status match {
      case 1 => s = 25;
      case 2 => s = 12;
      case _ => s = 0;
    }

    val r = n - s;

    if (r < 0) {
      println("You will catch it!");
      return;
    }

    // not caught, calc HP factor
    var f = 0; // Pokemon max HP * 255

    if (ball == 2) {
      f /= 8;
    } else {
      f /= 12;
    }

    // divide pokemon's current HP by 4( if 0, make it 1)
    var currHP:Int = 0;
    currHP /= 4;
    if (currHP == 0) {
      currHP = 1;
    }
    
    f /= currHP;
    if (f > 255) {
      f = 255;
    }
  }

  def getBall(): Int = {
    println("Gen 1 Pokeball types: ");
    println("1. Pokeball");
    println("2. Great Ball");
    println("3. Ultra/Safari Ball");
    println("4. Master Ball");
    // Get input
    val ball = readLine("Enter number corresponding to ball type used: ");
    // Check input
    if (1 to 4 contains ball.toInt) return ball.toInt else return -1
  }

  def getStatus(): Int = {
    println("Gen 1 Statuses: ");
    println("1. Sleep / Frozen");
    println("2. Poison, Burn, Paralysis");
    println("3. Other");
    // Get input
    val status = readLine("Enter number corresponding to status: ");
    // Check input
    if (1 to 3 contains status.toInt) return status.toInt else return -1
  }
}