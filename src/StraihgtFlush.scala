class StraightFlush extends MaoJogadorType {
  def evaluate(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = {

    def matches: Boolean = {
      m.isConsecutive && m.isSameSuit
    }

    (matches, this, 8 :: m.sorted.map(_.value))
  }

  override def toString: String = {
    "Straight Flush"
  }
}

object StraightFlush {
  def apply(m: MaoJogador): (Boolean, MaoJogadorType, List[Int]) = (new StraightFlush).evaluate(m)
}
