class FullHouse extends MaoJogadorType {
  def evaluate(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {

    def matches: Boolean = {
      m.pares.toList.length == 1 && m.tipla.toList.length == 1
    }

    def score: List[Int] = {
      val p: List[Int] = matches match {
        case true  => m.tipla.collect { case (a,b) => b.head.value }.toList
        case false => 0 :: Nil
      }
      
      val q: List[Int] = matches match {
        case true  => m.pares.collect { case (a,b) => b.head.value }.toList
        case false => 0 :: Nil
      }

      6 :: p.head :: q.head :: 0 :: 0 :: 0 :: Nil
    }

    (matches, this, score)
  }

  override def toString: String = {
    "Full House"
  }
}

object FullHouse {
  def apply(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new FullHouse).evaluate(m)
}
