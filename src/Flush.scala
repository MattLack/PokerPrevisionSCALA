class Flush extends MaoJogadorType {  
  def evaluate(MaoJogador: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {
    (MaoJogador.isSameSuit, this, 5 :: MaoJogador.sorted.map(_.value))
  }

  override def toString: String = {
    "Flush"
  }
}

object Flush {
  def apply(MaoJogador: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new Flush).evaluate(MaoJogador)
}
