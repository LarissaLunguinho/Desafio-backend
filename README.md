# Desafio-Fullstack-Hepta

## Como usar os filtros:

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
