package com.anshul.dogglers

/**
 * An object to generate a static list of dogs
 */
object DataSource {

    val dogs: List<Dog> = listOf(
        Dog(
            R.drawable.tzeitel,
            "Tzeitel",
            "7",
            "Sun Bathing"
        ),
        Dog(
            R.drawable.leroy,
            "Leroy",
            "4",
            "Sleeping Out"
        ),
        Dog(
            R.drawable.frankie,
            "Frankie",
            "2",
            "Steal Socks"
        ),
        Dog(
            R.drawable.nox,
            "Nox",
            "8",
            "Meeting New Animals"
        ),
        Dog(
            R.drawable.faye,
            "Faye",
            "8",
            "Digging in the Garden"
        ),
        Dog(
            R.drawable.bella,
            "Bella",
            "14",
            "Chasing Sea Foam"
        )
    )
}
