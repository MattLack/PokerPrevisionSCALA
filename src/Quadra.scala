class Quadra extends MaoJogadorType { 
  def evaluate(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = m.quadra.collect { case (a,b) => b.head.value }.toList
      val q: List[Int] = m.sorted.map(_.value).filter(!p.contains(_))

      List(7) ::: p ::: q ::: List(0,0,0)
    }

    (m.quadra.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Quadra"
  }
}

object Quadra {
  def apply(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new Quadra).evaluate(m)
}
