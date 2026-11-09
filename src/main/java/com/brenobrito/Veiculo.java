package com.brenobrito;

public interface Veiculo
{

  String getPlaca();

  double getValorVenal();

  String aceitar(VeiculoVisitor visitor);
}
