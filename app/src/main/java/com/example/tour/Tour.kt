package com.example.tour

data class Tour(
    var title: String,
    var card: MutableList<Card>,
)

data class Card (
    var photoId: Int,
    var context: String
) {

    val imageUrl = "https://picsum.photos/150?random=$photoId"
}

