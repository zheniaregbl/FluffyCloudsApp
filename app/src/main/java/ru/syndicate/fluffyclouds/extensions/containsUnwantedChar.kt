package ru.syndicate.fluffyclouds.extensions

fun String.containsUnwantedChar(): Boolean =
    contains(' ') || contains('/') || contains('\\') || contains('\"') ||
            contains('\'')