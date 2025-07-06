import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

// Record para mapear a resposta da API (mesmo da fase anterior)
record ApiResponse(
        String result,
        @SerializedName("base_code") String baseCode,
        @SerializedName("conversion_rates") Map<String, Double> conversionRates
) {}

public class Main {
    public static void main(String[] args) {

        String apiKey = "insira sua chave (pessoal e intransferível)";
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        try {
            // 1. FAZER A REQUISIÇÃO À API (APENAS UMA VEZ)
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url_str)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Erro ao buscar taxas de câmbio. Código: " + response.statusCode());
                return;
            }

            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
            Map<String, Double> taxasDeCambio = apiResponse.conversionRates();

            // 2. CRIAR O MENU INTERATIVO
            Scanner scanner = new Scanner(System.in);
            int escolha = 0;

            while (escolha != 7) {
                System.out.println("\n*************************************************");
                System.out.println("Bem-vindo(a) ao Conversor de Moedas!");
                System.out.println("Escolha uma opção de conversão:");
                System.out.println("1) Dólar (USD) => Peso Argentino (ARS)");
                System.out.println("2) Peso Argentino (ARS) => Dólar (USD)");
                System.out.println("3) Dólar (USD) => Real Brasileiro (BRL)");
                System.out.println("4) Real Brasileiro (BRL) => Dólar (USD)");
                System.out.println("5) Dólar (USD) => Peso Colombiano (COP)");
                System.out.println("6) Peso Colombiano (COP) => Dólar (USD)");
                System.out.println("7) Sair");
                System.out.println("*************************************************");
                System.out.print("Sua escolha: ");
                escolha = scanner.nextInt();

                if (escolha >= 1 && escolha <= 6) {
                    System.out.print("Digite o valor que deseja converter: ");
                    double valorParaConverter = scanner.nextDouble();

                    switch (escolha) {
                        case 1:
                            converter("USD", "ARS", valorParaConverter, taxasDeCambio);
                            break;
                        case 2:
                            converter("ARS", "USD", valorParaConverter, taxasDeCambio);
                            break;
                        case 3:
                            converter("USD", "BRL", valorParaConverter, taxasDeCambio);
                            break;
                        case 4:
                            converter("BRL", "USD", valorParaConverter, taxasDeCambio);
                            break;
                        case 5:
                            converter("USD", "COP", valorParaConverter, taxasDeCambio);
                            break;
                        case 6:
                            converter("COP", "USD", valorParaConverter, taxasDeCambio);
                            break;
                    }
                } else if (escolha != 7) {
                    System.out.println("Opção inválida, por favor, tente novamente.");
                }
            }

            System.out.println("Obrigado por usar o Conversor de Moedas! Programa finalizado.");
            scanner.close();

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro crítico ao se comunicar com a API.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // 3. MÉTODO AUXILIAR PARA A LÓGICA DE CONVERSÃO
    public static void converter(String moedaOrigem, String moedaDestino, double valor, Map<String, Double> taxas) {
        Double taxaOrigem = taxas.get(moedaOrigem);
        Double taxaDestino = taxas.get(moedaDestino);

        if (taxaOrigem == null || taxaDestino == null) {
            System.out.println("Não foi possível encontrar as taxas de conversão para as moedas especificadas.");
            return;
        }

        double resultado = valor * (taxaDestino / taxaOrigem);

        System.out.printf("O valor de %.2f %s corresponde a %.2f %s\n",
                valor, moedaOrigem, resultado, moedaDestino);
    }
}