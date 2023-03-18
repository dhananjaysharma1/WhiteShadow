package com.scale.whiteshadow.model

data class Pokemons(
    val pokemonList: List<Info>
)

data class PokemonInfo(
    val pokemonAbilities: List<PokemonAbilities>,
    val forms: List<FormsContent>,
    val gameIndices: List<GameIndex>,
    val height: Int,
    val heldItems: List<HeldItem>,
    val id: Int,
    val isDefault: Boolean,
    val locationAreaEncounters: String,
    val moves: List<Moves>,
    val species: Info,
    val sprites: SpritesContent,
    val stats: List<Stats>,
    val types: List<Types>
)

data class PokemonAbilities(
    val abilities: Ability,
    val isHidden: Boolean,
    val slot: Int
)

data class Ability(
    val name: String,
    val url: String,
)

data class FormsContent(
    val contents: List<Info>
)

data class Info(
    val name: String,
    val url: String
)

data class GameIndex(
    val gameIndex: Int,
    val version: Info
)

data class HeldItem(
    val item : Info,
    val versionDetails: List<Detail>
)

data class Detail(
    val rarity: Int,
    val version: Info
)

data class Moves(
    val move: Move,
    val name: String,
    val order: Int
)

data class Move(
    val move: Info,
    val versionGroupDetails: List<VersionGroupDetail>
)

data class VersionGroupDetail(
    val levelLearnedAt: Int,
    val moveLearnMethod: Info
)

data class SpritesContent(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?
)

data class Stats(
    val baseStat: Int,
    val effort: Int,
    val stat: Info
)

data class Types(
    val type: Type,
    val weight: Int
)

data class Type(
    val slot: Int,
    val type: Info
)

