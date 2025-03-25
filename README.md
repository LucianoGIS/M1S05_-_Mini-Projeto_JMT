# Mapeamento de Áreas Verdes de Joinville  

**Sistema em Java via terminal para cadastrar, avaliar e consultar parques de Joinville com critérios sustentáveis** 

---

## Introdução  
Projeto acadêmico referento ao "Módulo 1 - Defesa de Mini-Projeto" do programa Joinville Mais Tec, idealizado pela Prefeitura de Joinville em parceria com o SENAI, ACIJ, Join.valle e Sebrae. 

O sistema em Java implementa uma interface via terminal para:
- Cadastrar áreas verdes com localização e atividades
- Avaliar parques com base em cinco critérios ecológicos
- Consultar dados por meio de um menu interativo

---

## Funcionalidades  

**Cadastro de áreas verdes**  
- Nome, tipo de vegetação, horário, atividades  
- Geolocalização (latitude/longitude)  

**Avaliação com critérios sustentáveis**  
- Notas de 1-5 para: árvores, qualidade do ar, poluição sonora, etc  

**Consultas intuitivas**  
- Listagem resumida ou detalhada  

**Menu interativo no terminal**

<img width="242" alt="{5553D4CF-5921-4294-B46A-2987BA6B9C8D}" src="https://github.com/user-attachments/assets/cd7544ac-3d80-4bad-b4d8-7e20cf14955a" />


---

## Tecnologias  

```plaintext
📦 src
├── models          # Entidades (AreaVerde, Avaliacao, Localizacao)
├── repositories    # Persistência em memória
├── services        # Regras de negócio
└── utils           # Validação de inputs
```

**Padrões**: SOLID, Repository Pattern  

---

## Como Executar  

1. Clone o repositório  
2. Execute:  
```bash
cd src && javac Main.java && java Main
```

---

## Licença  

<div align="center">
  <img src="https://img.shields.io/badge/Java-21-orange" alt="Java 21">
  <img src="https://img.shields.io/badge/License-MIT-green" alt="License MIT">
</div>
