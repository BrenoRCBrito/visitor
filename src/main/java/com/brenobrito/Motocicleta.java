package com.brenobrito;

public class Motocicleta implements Veiculo
{

  private final String placa;

  private final double valorVenal;

  private final int cilindradas;

  public Motocicleta(String placa, double valorVenal, int cilindradas)
  {
    this.placa = placa;
    this.valorVenal = valorVenal;
    this.cilindradas = cilindradas;
  }

  @Override
  public String getPlaca()
  {
    return placa;
  }

  @Override
  public double getValorVenal()
  {
    return valorVenal;
  }

  public int getCilindradas()
  {
    return cilindradas;
  }

  @Override
  public String aceitar(VeiculoVisitor visitor)
  {
    return visitor.visitarMotocicleta(this);
  }
}
