class Par extends MaoJogadorType {
  def evaluate(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {
    def score: List[Int] = {
      val p: List[Int] = m.pares.collect { case (a,b) => b.head.value }.toList
      val q: List[Int] = m.sorted.map(_.value).filter(!p.contains(_))

      List(1) ::: p ::: q ::: List(0)
    }

    (m.pares.toList.length == 1, this, score)
  }

  override def toString: String = {
    "Par"
  }
}

object Par {
  def apply(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new Par).evaluate(m)
}
