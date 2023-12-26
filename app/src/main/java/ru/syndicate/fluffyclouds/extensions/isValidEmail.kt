package ru.syndicate.fluffyclouds.extensions

fun String.isValidEmail(): Boolean {
    if (isEmpty())
        return true

    val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    return matches(emailRegex)
}