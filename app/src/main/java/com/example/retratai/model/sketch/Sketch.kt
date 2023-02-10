package com.example.retratai.model.sketch

data class Sketch(
    var gender: String = "",
    var age: String = "",
    var bodyType: String = "",
    var ancestry: String = "",
    var skinColor: String = "",
    var hairColor: String = "",
    var hairSize: String = "",
    var eyebrowColor: String = "",
    var eyebrowThickness: String = "",
    var eyeColor: String = "",
    var beardAndMoustache: String = "",
    var beardAndMoustacheSize: String = "",
    var beardAndMoustacheColor: String = "",
    var noseType: String = "",
    var faceType: String = ""
) {
    override fun toString(): String {
        return "Retrato Frontal: " +
                "Gênero: $gender, " +
                "Idade: $age, " +
                "Corpo: $bodyType, " +
                "Descendência: $ancestry, " +
                "Cor da pele: $skinColor, " +
                "Cabelo: $hairSize, "+
                "Cor do Cabelo: $hairColor, " +
                "Cor da Sobrancelha: $eyebrowColor, " +
                "Expessura da Sobrancelha: $eyebrowThickness, " +
                "Cor dos Olhos: $eyeColor, " +
                "Barba: $beardAndMoustache, " +
                "Tamanho da Barba: $beardAndMoustacheSize, " +
                "Cor da Barba: $beardAndMoustacheColor, " +
                "Nariz: $noseType, " +
                "Rosto: $faceType"
    }
}
