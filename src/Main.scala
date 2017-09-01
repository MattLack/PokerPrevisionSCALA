object Main { 
  def main(args: Array[String]): Unit = {
//    println("Simple Poker Hand Evaluator")
//    println("=======================================")
//    
//    println("Instructions:")
//    println(" - Enter each hand in the following format:")
//    println("    {V}{S} {V}{S} {V}{S} {V}{S} {V}{S}")
//    println("     Suits: C=Clubs, H=Hearts, S=Spades, D=Diamonds")
//    println("     Values: 2,3,4,5,6,7,8,9,T,J,Q,K,A")
//    println("  - Example:")
//    println("     AC 2D TH 3S 5D")
 //   println("")
     //   val a: String = System.console().readLine("Black: ")
 //   val b: String = System.console().readLine("White: ")
  
//   val b: String = "5C AD 5D AC 9C 8C TS KC 9H 4S"
//   println(b.split(" ").toList.slice(0, 5).toList)
//     println(b.split(" ").toList.slice(5, 10).toList)
//    val h1: Hand = Hand(b.split(" ").toList.slice(0, 4))
//     val h2: Hand = Hand(b.split(" ").toList.slice(4, 9))
//    
 //   println(h1.compareTo(h2)._3)
    
   calcular(io.Source.fromFile("entrada/pokerK.txt").getLines());

  }
  
  def calcular(linha: Iterator[String]) : String= {
  //  ).next().split(" ").toList
     var line = linha.next().split(" ").map(_.trim).toList;
  
   val h1: Hand = Hand(line.slice(0,5).toList )
   val h2: Hand = Hand(line.slice(5,10).toList )
   var cont = 0
   println(line)
    println(h1.compareTo(h2)._3)
     
    if(linha.hasNext){
       
         calcular(linha );
     }
     else{
      ""
     }       
  }
  
  
  
 
}
