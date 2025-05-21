# Sistema de Gerenciamento de Funcionários

Este projeto é um sistema de gerenciamento de funcionários desenvolvido com um backend Spring Boot e MySQL como banco de dados, tudo orquestrado com Docker Compose para facilitar o ambiente de desenvolvimento.

### 🚀 Tecnologia Utilizadas
Tecnologias Utilizadas
Backend: Spring Boot (Java 21)
Banco de Dados: MySQL (via Docker)
Containerização: Docker & Docker Compose
Gerenciador de Dependências (Java): Maven
Ferramenta de Banco de Dados: MySQL Workbench

### 🛠️ Pré-requisitos
Para executar este projeto localmente, você precisará ter o seguinte software instalado em sua máquina:

Java Development Kit (JDK) 21 ou superior:
Verifique sua versão: java -version
Apache Maven 3.x.x:
Verifique sua versão: mvn -v

Docker Desktop (ou Docker Engine e Docker Compose):
Verifique suas versões: docker -v e docker compose version (se usar Docker Compose V2) ou docker-compose -v (se usar Docker Compose V1).

### 📋 Configuração e Execução
**1. Clonar o Repositório**
git clone <URL_DO_SEU_REPOSITORIO>
cd fullstack-desafio
**2. Iniciar o Banco de Dados com Docker Compose**
docker compose up -d mysql
**3. Configurar o Banco de Dados**
Host: localhost (ou o IP do seu container, se necessário)
Porta: 3306
Usuário: (verifique seu docker-compose.yml para as credenciais exatas, geralmente root ou user)
Senha: (verifique seu docker-compose.yml para a senha, geralmente password)
Nome do Banco de Dados: (verifique seu docker-compose.yml para o nome do banco, geralmente employee_db ou similar)
**4. Executar a Aplicação Spring Boot**
mvn spring-boot:run
**5. Acessar a Aplicação**
Backend (API): http://localhost:8080 (a porta padrão do Spring Boot)


### Como usar os filtros:

Com essas alterações e o campo `cargo` em `Employee`, você pode fazer as seguintes requisições:

  * **Para listar todos os empregados (sem filtro):**
    `http://localhost:8086/api/v1/employees`

  * **Para filtrar por nome (ex: "Maria"):**
    `http://localhost:8086/api/v1/employees?firstName=Maria`

  * **Para filtrar por cargo (ex: "Gerente"):**
    `http://localhost:8086/api/v1/employees?cargo=Gerente`

  * **Para combinar filtros (neste exemplo, ele prioriza `cargo` se ambos estiverem presentes. Para uma combinação "E" mais robusta, veja a próxima seção):**
    `http://localhost:8086/api/v1/employees?firstName=Joao&cargo=Desenvolvedor`

-----

## Observação sobre filtros combinados ("E")

O código acima prioriza um filtro sobre o outro se ambos (`firstName` e `cargo`) forem fornecidos. Se você precisa de uma consulta onde **ambos** os critérios devem ser satisfeitos (ou seja, `firstName` **E** `cargo`), você precisaria de um método de consulta combinado no seu `EmployeeRepository`:
