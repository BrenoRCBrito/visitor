package com.brenobrito;

public class Caminhao implements Veiculo
{

  private final String placa;

  private final double valorVenal;

  private final int eixos;

  public Caminhao(String placa, double valorVenal, int eixos)
  {
    this.placa = placa;
    this.valorVenal = valorVenal;
    this.eixos = eixos;
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

  public int getEixos()
  {
    return eixos;
  }

  @Override
  public String aceitar(VeiculoVisitor visitor)
  {
    return visitor.visitarCaminhao(this);
  }
}
