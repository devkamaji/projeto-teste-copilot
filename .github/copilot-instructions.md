## Requisitos principais

Você deve seguir as instruções abaixo para garantir que o código gerado atenda aos requisitos de qualidade e documentação.
- Use o pt-br como idioma padrão para todos os comentários, variáveis, metodos e classes
- Seja especializado em java 21 e spring boot
- Seja especializado em clean code
- Seja especializado em Junit 5

## Requisitos de qualidade de código

- Use nomes claros e descritivos de variável e funções
- Nunca utilize @Autowired
- Sempre utilize @Lombok se possivel para construtores, getters e setters
- Sempre Utilize DTO (Data Transfer Object) para transferir dados entre processos
- Sempre utilize record para criar Objetos imutáveis
- Escreva testes de unidade para funcionalidade principal
- Manter funções focadas e gerenciáveis (geralmente abaixo de 50 linhas)
- Use padrões de manuseio de erros de forma consistente
- Mantenha todas as linhas, incluindo comentários, menos de 120 caracteres
- Para qualquer código, use os seguintes arquivos de configuração (se estiverem presentes): `<root>/pom.xml` e `<root>/settings.xml`

## Requisitos de documentação

- Adicione o JavaDoc se estiver ausente, mas mantenha curto. Não alinhe.
- Adicione comentários para explicar implementações de lógica complexa ou não óbvias
- Coloque os comentários embutidos acima do código, não na mesma linha
- Use frases completas para comentários
- Nunca comente em Markdown, exceto blocos de código

## Requisitos de commit
- Escreva mensagens em pt-br
- Use mensagens de commit claras e descritivas
- Use o seguinte formato para mensagens de commit:
```
<tipo>(escopo): <descrição>
<corpo>
```
- O tipo pode ser um dos seguintes:
  - feat: uma nova funcionalidade
  - fix: uma correção de bug
  - docs: apenas documentação
  - style: alterações que não afetam o significado do código (espaços em branco, formatação, etc)
  - refactor: uma mudança de código que não corrige um bug nem adiciona uma funcionalidade
  - perf: uma mudança de código que melhora o desempenho
  - test: adicionar testes ausentes ou corrigir testes existentes sem alterar o código de produção
  - chore: alterações na construção do sistema ou ferramentas auxiliares e bibliotecas, como documentação gerada por ferramentas