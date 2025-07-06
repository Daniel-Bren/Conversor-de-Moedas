Conversor de Moedas - Desafio ONE
📖 Descrição do Projeto
Este projeto é um Conversor de Moedas interativo que funciona via console. Desenvolvido como parte do Programa ONE (Oracle Next Education) em parceria com a Alura, a aplicação permite ao usuário obter taxas de câmbio em tempo real e realizar conversões entre um conjunto pré-definido de moedas.

A aplicação se conecta à API ExchangeRate-API para buscar os dados mais recentes, garantindo que as conversões sejam precisas. É uma demonstração prática de consumo de APIs, manipulação de JSON e desenvolvimento de uma aplicação de console em Java.

✨ Funcionalidades
Conversão em Tempo Real: Utiliza uma API para obter as taxas de câmbio mais atuais.

Menu Interativo: Interface de texto simples e intuitiva para o usuário escolher as moedas que deseja converter.

Conversões Múltiplas: Permite que o usuário realize quantas conversões desejar sem precisar reiniciar o programa.

Moedas Selecionadas: Foco em um conjunto de 6 moedas principais, incluindo BRL, USD e ARS.

🛠️ Tecnologias Utilizadas
Java 17: Versão da linguagem utilizada para o desenvolvimento da lógica principal.

Maven: Gerenciador de dependências para incorporar bibliotecas externas.

Gson: Biblioteca do Google para fazer o parsing (análise) e a conversão de JSON para objetos Java.

Java HttpClient: Ferramenta nativa do Java para realizar requisições HTTP e se comunicar com a API.

ExchangeRate-API: API externa utilizada como fonte para as taxas de câmbio.

🚀 Como Executar o Projeto
Siga os passos abaixo para executar o projeto localmente.

Pré-requisitos
Java Development Kit (JDK) 17 ou superior.

Apache Maven instalado e configurado no seu sistema.

Uma IDE de sua preferência (ex: IntelliJ IDEA, Eclipse).

Passo a Passo
Clone o repositório:

Bash

git clone [URL_DO_SEU_REPOSITORIO_NO_GITHUB]
cd nome-da-pasta-do-projeto
Obtenha uma Chave de API:

Acesse o site ExchangeRate-API e crie uma conta gratuita para obter sua chave de API (API Key).

Configure a Chave de API no Projeto:

Abra o projeto na sua IDE.

Navegue até o arquivo src/main/java/Main.java.

Encontre a seguinte linha de código:

Java

String apiKey = "COLE_SUA_CHAVE_REAL_AQUI";
Substitua "COLE_SUA_CHAVE_REAL_AQUI" pela sua chave de API real.

Execute a Aplicação:

Pela IDE: Simplesmente abra o arquivo Main.java e execute o método main. A IDE cuidará de baixar as dependências do Maven.

Pela Linha de Comando: Navegue até a pasta raiz do projeto e execute o seguinte comando Maven:

Bash

mvn compile exec:java -Dexec.mainClass="Main"
🎮 Exemplo de Uso
Ao executar a aplicação, um menu interativo será apresentado no console:

*************************************************
Bem-vindo(a) ao Conversor de Moedas!
Escolha uma opção de conversão:
1) Dólar (USD) => Peso Argentino (ARS)
2) Peso Argentino (ARS) => Dólar (USD)
3) Dólar (USD) => Real Brasileiro (BRL)
4) Real Brasileiro (BRL) => Dólar (USD)
5) Dólar (USD) => Peso Colombiano (COP)
6) Peso Colombiano (COP) => Dólar (USD)
7) Sair
*************************************************
Sua escolha: 3
Digite o valor que deseja converter: 150
O valor de 150.00 USD corresponde a 817.70 BRL

*************************************************
Bem-vindo(a) ao Conversor de Moedas!
...
✒️ Autor
Daniel Lima
LinkedIn
https://www.linkedin.com/in/daniel-lima-dev/

GitHub
https://github.com/Daniel-Bren
