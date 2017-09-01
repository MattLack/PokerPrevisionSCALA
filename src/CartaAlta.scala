class CartaAlta extends MaoJogadorType {
  def evaluate(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {
    (true, this, 0 :: m.sorted.map(_.value))
  }
  
  override def toString: String = "Carta Alta"
}

object CartaAlta {
  def apply(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new CartaAlta).evaluate(m)
}
