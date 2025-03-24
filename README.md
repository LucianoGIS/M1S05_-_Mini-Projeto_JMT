**Mapeamento de Áreas Verdes de Joinville**

Sistema Java para cadastro, avaliação e consulta de parques e áreas verdes

---

## 🚀 Funcionalidades  

✔ **Cadastro de áreas verdes**  
- Nome, tipo de vegetação, horário, atividades  
- Geolocalização (latitude/longitude)  

✔ **Avaliação com critérios sustentáveis**  
- Notas de 1-5 para: árvores, qualidade do ar, poluição sonora, etc  

✔ **Consultas intuitivas**  
- Listagem resumida ou detalhada  

✔ **Menu interativo no terminal**  

---

## ⚙️ Tecnologias  

```plaintext
📦 src
├── models          # Entidades (AreaVerde, Avaliacao, Localizacao)
├── repositories    # Persistência em memória
├── services        # Regras de negócio
└── utils           # Validação de inputs
```

**Padrões**: SOLID, Repository Pattern  

---

## 🛠️ Como Executar  

1. Clone o repositório  
2. Execute:  
```bash
cd src && javac Main.java && java Main
```

---

## 📜 Licença  

<div align="center">
  <img src="https://img.shields.io/badge/Java-17%2B-blue?logo=java" alt="Java 17+">
  <img src="https://img.shields.io/badge/License-MIT-green" alt="License MIT">
</div>
