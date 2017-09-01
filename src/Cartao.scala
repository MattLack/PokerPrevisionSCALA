import scala.util.matching.Regex

class Cartao(cartao: String) {
  require(isValid(cartao), "Especificacao invalida do cartao")

  def face: String = {
    cartao.substring(0,1)
  }

  def suit: String = {
    cartao.substring(1,2)
  }

  def value: Int = {
    Cartao.value(face)
  }

  override def toString: String = {
    cartao
  }

  private def isValid(cartao: String): Boolean = {
    new Regex("[2-9KTQJA]{1}[CDSH]{1}").findAllIn(cartao).length > 0
  }
}

object Cartao {
  def apply(cs: String): Cartao = new Cartao(cs)

  val suits: List[String] = 
    List("C", "H", "D", "S")

  val faces: List[String] = 
    (2 to 9).map(_.toString).toList ::: List("T", "J", "Q", "K", "A")

  def value(key: String): Int = {
    values.find(v => v._1 == key).get._2
  }

  private val values: List[(String, Int)] = List(
    ("2", 2),
    ("3", 3),
    ("4", 4),
    ("5", 5),
    ("6", 6),
    ("7", 7),
    ("8", 8),
    ("9", 9),
    ("T", 10),
    ("J", 11),
    ("Q", 12),
    ("K", 13),
    ("A", 14)
  )
}