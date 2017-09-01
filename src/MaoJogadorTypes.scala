object MaoJogadorTypes {
  def all: List[MaoJogadorType] = {
    List(
      new StraightFlush,
      new Quadra,
      new FullHouse,
      new Flush,
      new Trinca,
      new DoisPares,
      new Par,
      new CartaAlta
    )
  }
}
