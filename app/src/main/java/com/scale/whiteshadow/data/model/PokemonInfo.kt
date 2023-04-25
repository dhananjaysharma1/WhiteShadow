package com.scale.whiteshadow.data.model

data class Pokemons(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Info>
)

data class PokemonInfo(
    val abilities: List<PokemonAbilities>,
    val baseExperience: Int,
    val forms: List<FormsContent>,
    val gameIndices: List<GameIndex>,
    val height: Int,
    val heldItems: List<HeldItem>,
    val id: Int,
    val isDefault: Boolean,
    val locationAreaEncounters: String,
    val moves: List<Moves>,
    val name: String,
    val order: Int,
    val species: Info,
    val sprites: SpritesContent,
    val stats: List<Stats>,
    val types: List<Types>,
    val weight: Int
)

data class PokemonAbilities(
    val ability: Info,
    val isHidden: Boolean,
    val slot: Int
)

data class FormsContent(
    val info: Info
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
    val item: Info,
    val versionDetails: List<Detail>
)

data class Detail(
    val rarity: Int,
    val version: Info
)

data class Moves(
    val move: Move,
    val versionGroupDetails: List<VersionGroupDetail>
)

data class Move(
    val move: Info,
    val versionGroupDetails: List<VersionGroupDetail>
)

data class VersionGroupDetail(
    val levelLearnedAt: Int,
    val moveLearnMethod: Info,
    val versionGroup: Info
)

data class SpritesContent(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?,
    val other: OtherSprites
)

data class OtherSprites(
    val dreamWorld: Content
)

data class Content(
    val frontDefault: String?,
    val frontFemale: String?
)

data class Stats(
    val baseStat: Int,
    val effort: Int,
    val stat: Info
)

data class Types(
    val slot: Int,
    val type: Info
)
