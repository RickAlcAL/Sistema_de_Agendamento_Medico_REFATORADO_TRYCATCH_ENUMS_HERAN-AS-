# Sistema de Agendamento Médico

Este repositório contém um sistema de agendamento médico que passou por um processo rigoroso de refatoração. O objetivo principal foi aplicar conceitos avançados de Programação Orientada a Objetos (POO) para transformar um código legado em uma solução robusta, escalável e de fácil manutenção.

## 🚀 Melhorias Implementadas

O projeto foi reestruturado focando em três pilares principais de qualidade de software:

* **Herança:** Modelagem do domínio médico utilizando classes herdadas para especialidades e tipos de atendimento, garantindo reutilização de código e polimorfismo.
* **Enums (Enumerações):** Centralização e padronização de estados fixos do sistema (como status do agendamento: `AGENDADO`, `CANCELADO`, `CONCLUÍDO`) e dias da semana, eliminando o uso de strings mágicas.
* **Tratamento de Exceções (Try-Catch):** Implementação de robustez contra falhas e entradas inválidas. O sistema agora conta com exceções customizadas para regras de negócio (ex: `HorarioIndisponivelException`).

## 🛠️ Tecnologias e Conceitos Utilizados

* Linguagem de Programação Java
* Programação Orientada a Objetos (POO)
* Manipulação de Erros e Exceções
* Clean Code (Código Limpo)

