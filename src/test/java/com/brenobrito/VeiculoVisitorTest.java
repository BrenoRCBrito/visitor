package com.brenobrito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class VeiculoVisitorTest
{

  private final Veiculo carro = new Carro("ABC1D23", 50000.0, 4);

  private final Veiculo motocicleta = new Motocicleta("XYZ9W87", 20000.0, 150);

  private final Veiculo caminhao = new Caminhao("QRS4T56", 300000.0, 3);

  @Test
  void deveCalcularIpvaDoCarroComQuatroPorCento()
  {
    assertEquals("IPVA de 2000.00", new CalculoIpva().calcular(carro));
  }

  @Test
  void deveCalcularIpvaDaMotocicletaComDoisPorCento()
  {
    assertEquals("IPVA de 400.00", new CalculoIpva().calcular(motocicleta));
  }

  @Test
  void deveIsentarOCaminhaoDeIpva()
  {
    assertEquals("Isento", new CalculoIpva().calcular(caminhao));
  }

  @Test
  void deveEmitirCrlvDoCarroComAsPortas()
  {
    assertEquals("CRLV Carro ABC1D23 - 4 portas", new EmissaoCrlv().emitir(carro));
  }

  @Test
  void deveEmitirCrlvDaMotocicletaComAsCilindradas()
  {
    assertEquals("CRLV Motocicleta XYZ9W87 - 150 cilindradas", new EmissaoCrlv().emitir(motocicleta));
  }

  @Test
  void deveEmitirCrlvDoCaminhaoComOsEixos()
  {
    assertEquals("CRLV Caminhao QRS4T56 - 3 eixos", new EmissaoCrlv().emitir(caminhao));
  }

  @Test
  void deveEscolherOMetodoCertoSemOChamadorConhecerOTipo()
  {
    VeiculoVisitor visitor = new EmissaoCrlv();

    assertEquals("CRLV Carro ABC1D23 - 4 portas", carro.aceitar(visitor));
    assertEquals("CRLV Motocicleta XYZ9W87 - 150 cilindradas", motocicleta.aceitar(visitor));
    assertEquals("CRLV Caminhao QRS4T56 - 3 eixos", caminhao.aceitar(visitor));
  }

  @Test
  void deveAplicarVisitantesDiferentesNaMesmaFrota()
  {
    List<Veiculo> frota = List.of(carro, motocicleta, caminhao);
    CalculoIpva ipva = new CalculoIpva();
    EmissaoCrlv crlv = new EmissaoCrlv();

    assertEquals(List.of("IPVA de 2000.00", "IPVA de 400.00", "Isento"),
        frota.stream().map(v -> v.aceitar(ipva)).toList());
    assertEquals(List.of("CRLV Carro ABC1D23 - 4 portas",
        "CRLV Motocicleta XYZ9W87 - 150 cilindradas",
        "CRLV Caminhao QRS4T56 - 3 eixos"),
        frota.stream().map(v -> v.aceitar(crlv)).toList());
  }
}
