# Calculadora de custo/preço de produto

Esse programa facilita o cálculo do custo e preço sugerido de venda de um produto a partir das informações passadas de insumos necessários na produção. É feito para quem precisa fazer os cálculos de forma inteligível, sem precisar pensar na conta em sí.

## Requisitos
- 🍵 Java JDK 17 (ou versão posterior)
- 🪶 Maven (para gerenciamento de dependencias)
- 🎲 Banco de dados MySQL ou MariaDB instalado e em execução
- ⚙️ Ajuste das variáveis de conexão com o banco no arquivo application.properties (uri, user, password)

## Funcionalidades 🧰
- Cadastro de produtos (com suprimentos passados no momento da criação)
- Cálculo automático de custo total por receita de acordo com as quantidades informadas
- Preço sugerido gerado automaticamente de acordo com custo total
- Listagem de produtos com id e nome únicos, e suas respectivas informações

## Diagrama de explicação básico
<p align="center">
  <img src=https://github.com/sergio-ramon/calc_cost_price/blob/main/src/main/resources/diagrama.png>
</p>

## Aprendizados
- POO (revisão e aplicação)
- Abstração
- Stream API (manipulação de listas e atributos das mesmas)
- Banco de dados relacional (SQL com MariaDB/MySQL)
- Conexão com banco de dados aberto em máquina virtual (Oracle VirtualBox com ip próprio no modo bridge)
