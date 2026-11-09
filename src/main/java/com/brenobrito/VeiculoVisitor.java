package com.brenobrito;

public interface VeiculoVisitor
{

  String visitarCarro(Carro carro);

  String visitarMotocicleta(Motocicleta motocicleta);

  String visitarCaminhao(Caminhao caminhao);
}
