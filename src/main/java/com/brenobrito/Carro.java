package com.brenobrito;

public class Carro implements Veiculo
{

  private final String placa;

  private final double valorVenal;

  private final int portas;

  public Carro(String placa, double valorVenal, int portas)
  {
    this.placa = placa;
    this.valorVenal = valorVenal;
    this.portas = portas;
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

  public int getPortas()
  {
    return portas;
  }

  @Override
  public String aceitar(VeiculoVisitor visitor)
  {
    return visitor.visitarCarro(this);
  }
}
