object Principal { 
      var vitoriaMaoUm = 0; // contador de vitorias da cartao um
  def main(args: Array[String]): Unit = {

   var initTime = System.currentTimeMillis();
   
   calcular(io.Source.fromFile("entrada/pokerK.txt").getLines());
   
   var endTime = System.currentTimeMillis();
   
   // calculando os segundos
   var totalTime = (endTime - initTime)/1000; 
   
   println("O primeiro jogador ganhou " + vitoriaMaoUm +" vezes, O algoritmo levou " + totalTime + " segundos para ser concluido .")

  }
  
  def calcular(linha: Iterator[String]) : String= {
  
     var line = linha.next().split(" ").map(_.trim).toList;
  
    val h1: MaoJogador = MaoJogador(line.slice(0,5).toList )
   
    val h2: MaoJogador = MaoJogador(line.slice(5,10).toList )
    
// comparacao do resultado da cartao que ganhou com a cartao um
// caso seja igual a cartao 1 ganhou
 if(( h1.compareTo(h2)._3.substring(8,22).toString().contains(h1.toString())))
 {
  vitoriaMaoUm = vitoriaMaoUm +1;
 }
   
     // enquanto o arquivo nao acabou     
    if(linha.hasNext){
       
         calcular(linha );
     }
     else{ // retorna string vazia se acabou o arquivo
      ""
     }       
  }
  
}
