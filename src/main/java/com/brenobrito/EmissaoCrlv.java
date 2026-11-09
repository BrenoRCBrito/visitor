package com.brenobrito;

public class EmissaoCrlv implements VeiculoVisitor
{

  public String emitir(Veiculo veiculo)
  {
    return veiculo.aceitar(this);
  }

  @Override
  public String visitarCarro(Carro carro)
  {
    return "CRLV Carro " + carro.getPlaca() + " - " + carro.getPortas() + " portas";
  }

  @Override
  public String visitarMotocicleta(Motocicleta motocicleta)
  {
    return "CRLV Motocicleta " + motocicleta.getPlaca() + " - "
        + motocicleta.getCilindradas() + " cilindradas";
  }

  @Override
  public String visitarCaminhao(Caminhao caminhao)
  {
    return "CRLV Caminhao " + caminhao.getPlaca() + " - " + caminhao.getEixos() + " eixos";
  }
}
