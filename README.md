<p align="center">
  <img src="https://img.shields.io/static/v1?label=Project&message=core-main&color=1f1f1f&style=for-the-badge&logo=Github" alt="core-main">
</p>

<h1 align="center">Core Main (INCOMPLETO)</h1>

<p align="center">
  Plugin Spigot 1.8.8 com gerenciamento de comandos, inventários e NPCs.
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

| Biblioteca | Versão | Descrição |
|------------|--------|-----------|
| `inventory-api` | 2.0.3 | Gerenciamento de inventários (HenryFabio) |
| `command-framework` | 1.3.1 | Sistema de comandos (SaiintBrisson) |
| `PlaceholderAPI` | 2.11.7 | Placeholders (opcional) |
| `npclib-api` | local | NPCs |

## Estrutura

```
src/main/java/com/github/alexvoliveira/plugin/core/spigot/
├── CoreSpigot.java              # classe principal
├── command/
│   └── GameModeCommand.java     # comando /gamemode
├── common/
│   ├── enums/
│   │   └── SkinsNpcEnums.java   # skins de NPCs
│   ├── factory/
│   │   └── ItemFactory.java     # builder de ItemStack
│   └── util/
│       └── PlaceholderUtil.java # utilitário de placeholders
└── service/
    └── CommandService.java      # registro de comandos
```

## Funcionalidades

### Comandos
- `/gamemode [modo]` - Altera modo de jogo
    - Aliases: `gm`, `mododejogo`, `modo-de-jogo`
    - Modos: criativo (c), sobrevivência (s), espectador (sp), aventura (a)

### Recursos
- Factory para criação de itens com suporte a cabeças customizadas
- Integração com PlaceholderAPI e LuckPerms (suffix)
- Enums com skins pré-configuradas para NPCs:
    - SKYWARS
    - BEDWARS
    - EVENTS

## Build

```bash
./gradlew shadowJar
```

Gera `core-main.jar` em `build/libs/` com dependências relocadas.

## Instalação

1. Coloque `core-main.jar` em `plugins/`
2. Coloque `NPCLibPlugin.jar` em `plugins/`
3. Instale `PlaceholderAPI.jar` em `plugins/`
4. Reinicie o servidor

---

<p align="center">
  <img src="https://img.shields.io/static/v1?label=By&message=alexvoliveira&color=1f1f1f&style=for-the-badge&logo=Github" alt="Author">
</p>