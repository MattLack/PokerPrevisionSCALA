class Trinca extends MaoJogadorType {
  def evaluate(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = m.tipla.collect { case (a,b) => b.head.value }.toList
      val q: List[Int] = m.sorted.map(_.value).filter(!p.contains(_))

      List(3) ::: p ::: q ::: List(0,0)
    }

    (m.tipla.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Three of a Kind"
  }
}

object Trinca {
  def apply(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new Trinca).evaluate(m)
}
