<p align="center">
  <img src="https://img.shields.io/static/v1?label=Project&message=core-main&color=1f1f1f&style=for-the-badge&logo=Github" alt="core-main">
</p>

<h1 align="center">Core Main</h1>

<p align="center">
  Plugin Spigot 1.8.8 base com comandos, inventários, views e utilitários compartilhados.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-8-orange?style=for-the-badge&logo=java" alt="Java 8">
  <img src="https://img.shields.io/badge/Spigot-1.8.8-yellow?style=for-the-badge" alt="Spigot">
  <img src="https://img.shields.io/badge/Gradle-8.14-blue?style=for-the-badge&logo=gradle" alt="Gradle">
</p>

---

## Tecnologias

<p align="left">
  <img src="https://img.shields.io/badge/Java-8-ED8B00?style=flat-square&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Spigot-1.8.8-orange?style=flat-square" alt="Spigot">
  <img src="https://img.shields.io/badge/Gradle-8.14-02303A?style=flat-square&logo=gradle&logoColor=white" alt="Gradle">
  <img src="https://img.shields.io/badge/Lombok-1.18.38-red?style=flat-square" alt="Lombok">
</p>

## Dependências

| Biblioteca | Versão | Descrição                                 |
|------------|--------|-------------------------------------------|
| `inventory-api` | 2.0.3 | Gerenciamento de inventários (HenryFabio) |
| `command-framework` | 1.3.1 | Sistema de comandos (SaiintBrisson)       |
| `PlaceholderAPI` | 2.11.7 | Placeholders (depend)                     |
| `NPCLibPlugin` | 2.13.1 | NPCs (depend)                             |

## Estrutura

```
src/main/java/com/github/alexvoliveira/plugin/core/spigot/
├── CoreSpigot.java                     # classe principal
├── command/
│   └── GameModeCommand.java            # comando /gamemode
├── common/
│   ├── enums/
│   │   ├── SkinsNpcEnums.java          # skins de NPCs
│   │   └── type/
│   │       └── GameType.java           # enum de modos de jogo
│   ├── factory/
│   │   └── ItemFactory.java            # builder de ItemStack
│   └── util/
│       └── PlaceholderUtil.java        # utilitário de placeholders
├── service/
│   └── CommandService.java             # registro de comandos
└── view/
    ├── AccountView.java                # GUI da conta do jogador
    └── ServerView.java                 # GUI de seleção de servidores
```

## Funcionalidades

### Comandos
- `/gamemode [modo]` - Altera modo de jogo
  - Aliases: `gm`
  - Modos aceitos:
    - `survival`, `s`, `0` - Modo sobrevivência
    - `criativo`, `c`, `1` - Modo criativo
    - `aventura`, `a`, `2` - Modo aventura
    - `espectador`, `sp`, `3` - Modo espectador

### Views (Inventários)
- **AccountView** - Menu de conta do jogador
  - Exibe skull do jogador
  - Mostra cargo (via PlaceholderAPI/LuckPerms)
  - Slot 13, título "Sua Conta."

- **ServerView** - Menu de seleção de servidores
  - Item SKYWARS (Eye of Ender)
  - Slot 13, título "Sua Conta."

### Sistema de Enums
- **GameType** - Enum com suporte a aliases para GameMode
- **SkinsNpcEnums** - Skins pré-configuradas:
  - SKYWARS
  - BEDWARS
  - EVENTS

### Utilitários
- **ItemFactory** - Builder pattern para criação de ItemStack
  - Suporte a cabeças customizadas (owner/URL)
  - Lore, nome, durabilidade, slot

- **PlaceholderUtil** - Integração com PlaceholderAPI
  - Método `getRole(Player)` - retorna suffix do LuckPerms

## Build

```bash
./gradlew shadowJar
```

Gera `core-main.jar` em `build/libs/` com dependências relocadas.

## Instalação

1. Coloque `NPCLibPlugin.jar` em `plugins/`
2. Coloque `PlaceholderAPI.jar` em `plugins/`
3. Coloque `LuckPerms.jar` em `plugins/`
4. Coloque `core-main.jar` em `plugins/`
5. Reinicie o servidor

## Uso como Dependência

Outros plugins podem depender do core-main adicionando no `plugin.yml`:

```yaml
depend: [ core-main ]
```

E referenciando no `build.gradle`:

```gradle
implementation files("../core-main/build/libs/core-main.jar")
```

---

<p align="center">
  <img src="https://img.shields.io/static/v1?label=By&message=alexvoliveira&color=1f1f1f&style=for-the-badge&logo=Github" alt="Author">
</p>