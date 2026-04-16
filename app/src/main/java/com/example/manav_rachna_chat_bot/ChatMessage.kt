package com.example.manav_rachna_chat_bot

enum class Sender {
    USER, BOT
}

data class ChatMessage(
    val text: String,
    val sender: Sender,
    val timestamp: Long = System.currentTimeMillis()
)
