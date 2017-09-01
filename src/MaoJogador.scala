import Ordering.Implicits._

class MaoJogador(val Cartaos: List[Cartao]) {
  require(isValid, "Invalida especicacao da mao do jogador")

  def sorted: List[Cartao] = this.Cartaos.sortWith(_.value > _.value)

  def compareTo(that: MaoJogador): (Option[MaoJogador], Option[MaoJogadorType], String) = {
    def eval(h: MaoJogador): (MaoJogador, MaoJogadorType, List[Int]) = {
      MaoJogadorTypes.all.collect { case t => t.evaluate(h) }.find { case (b,t,s) => b } match {
          case None    => throw new Error("Isto nunca deve acontecer :p")
          case Some(v) => (h, v._2, v._3)
        }
    }

    def compare(a: (MaoJogador, MaoJogadorType, List[Int]), b: (MaoJogador, MaoJogadorType, List[Int])): Option[(MaoJogador, MaoJogadorType)] = {
      (a._3 > b._3, b._3 > a._3) match {
        case (true, false) => Some((a._1, a._2))
        case (false, true) => Some((b._1, b._2))
        case _ => None
      }
    }

    compare(eval(this), eval(that)) match {
      case Some(v)  => (Option(v._1), Option(v._2), s"Winner: ${v._1} (${v._2})")
      case None     => (None, None, s"Tie (${eval(this)._2})")
    }
  }

  def pares = group(2)
  def tipla = group(3)
  def quadra = group(4)

  def isSameSuit: Boolean = {
    Cartaos.groupBy(_.suit).toList.length == 1
  }

  def isConsecutive: Boolean = {
    def get(swap: Boolean): List[Int] = swap match {
      case false  => sorted.map(_.value)
      case true   => get(false).map { case 14 => 1; case x => x }.sortWith(_ > _)
    }

    val a: List[Int] = get(false)
    val b: List[Int] = get(true)
    
    (a.max to a.min by -1).toList == a || (b.max to b.min by -1).toList == b
  }

  override def toString: String = {
    Cartaos.map(_.toString).mkString(" ")
  }

  private def group(n: Int): Map[String, List[Cartao]] = {
    this.Cartaos.groupBy(_.face).filter { case (a,b) => b.length == n }
  }

  private def isValid: Boolean = {
    Cartaos.length == 5
  }
}

object MaoJogador {
  def apply(Cartaos: List[String]): MaoJogador = {
    val c = Cartaos.collect { case s: String => new Cartao(s) }
    new MaoJogador(c)
  }
}
