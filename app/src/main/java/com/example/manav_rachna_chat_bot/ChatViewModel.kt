package com.example.manav_rachna_chat_bot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    val messages = mutableStateListOf<ChatMessage>()

    init {
        messages.add(ChatMessage("Hello! Welcome to Manav Rachna University. How can I help you today?", Sender.BOT))
    }

    fun sendMessage(text: String) {
        if (text.isBlank()) return

        messages.add(ChatMessage(text, Sender.USER))
        
        viewModelScope.launch {
            delay(1000) // Simulate bot thinking
            val response = getBotResponse(text)
            messages.add(ChatMessage(response, Sender.BOT))
        }
    }

    private fun getBotResponse(userText: String): String {
        val input = userText.lowercase()
        return when {
            input.contains("admission") -> "Admissions are open for various courses! You can check the details on our website or visit the campus."
            input.contains("courses") || input.contains("programs") -> "We offer various programs in Engineering, Management, Law, Applied Sciences, and more."
            input.contains("location") || input.contains("where") -> "Manav Rachna University is located in Sector 43, Faridabad, Haryana."
            input.contains("contact") || input.contains("phone") -> "You can contact us at +91-129-4198100 or email us at admissions@manavrachna.edu.in."
            input.contains("fees") -> "Fee structure varies by course. Please visit our official website for the detailed fee schedule."
            input.contains("hi") || input.contains("hello") -> "Hello! How can I assist you with Manav Rachna University today?"
            else -> "I'm sorry, I don't have information on that. Would you like to know about admissions, courses, or contact details?"
        }
    }
}
