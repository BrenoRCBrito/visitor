package com.brenobrito;

import java.util.Locale;

public class CalculoIpva implements VeiculoVisitor
{

  public String calcular(Veiculo veiculo)
  {
    return veiculo.aceitar(this);
  }

  @Override
  public String visitarCarro(Carro carro)
  {
    return formatar(carro.getValorVenal() * 0.04);
  }

  @Override
  public String visitarMotocicleta(Motocicleta motocicleta)
  {
    return formatar(motocicleta.getValorVenal() * 0.02);
  }

  @Override
  public String visitarCaminhao(Caminhao caminhao)
  {
    return "Isento";
  }

  private String formatar(double valor)
  {
    return String.format(Locale.ROOT, "IPVA de %.2f", valor);
  }
}
