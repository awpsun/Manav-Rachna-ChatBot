package com.example.manav_rachna_chat_bot

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    val messages = mutableStateListOf<ChatMessage>()

    init {
        messages.add(ChatMessage("Hello! Welcome to Manav Rachna University (MRU). How can I assist you today?", Sender.BOT))
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
            input.contains("admission") -> "Admissions are open for the 2024-25 session! You can apply online via the official website or visit the campus for counseling."
            input.contains("courses") || input.contains("programs") || input.contains("study") -> "MRU offers a wide range of programs including Engineering, Law, Management, Applied Sciences, Education, and Humanities."
            input.contains("location") || input.contains("where") || input.contains("address") -> "Our address is: Sector – 43, Aravalli Hills, Delhi – Surajkund Road, Faridabad – 121004, (Haryana), India."
            input.contains("contact") || input.contains("phone") || input.contains("call") -> "You can reach us at +91-129-4268500 or call our toll-free number available on the website."
            input.contains("mail") || input.contains("email") -> "For any queries, feel free to email us at admissions@manavrachna.edu.in."
            input.contains("fees") || input.contains("structure") -> "The fee structure depends on the chosen program. Detailed information is available under the 'Admissions' section on manavrachna.edu.in."
            input.contains("placement") || input.contains("job") || input.contains("salary") -> "Manav Rachna has a strong placement record with top recruiters like Amazon, Microsoft, TCS, and many more visiting our campus."
            input.contains("scholarship") -> "We offer various scholarships based on merit in qualifying exams like MRNAT, JEE Main, SAT, and others."
            input.contains("ranking") || input.contains("nirf") -> "Manav Rachna institutions are consistently ranked among the top universities in India by NIRF, QS, and other prestigious agencies."
            input.contains("hostel") || input.contains("accommodation") -> "Yes, we provide safe and comfortable on-campus hostel facilities for both boys and girls."
            input.contains("facilities") || input.contains("campus") || input.contains("library") -> "Our campus is equipped with state-of-the-art labs, a digital library, sports facilities, and innovation centers."
            input.contains("hi") || input.contains("hello") || input.contains("hey") -> "Hello! I'm the MRU Assistant. How can I help you with information about our university?"
            input.contains("bye") || input.contains("thanks") || input.contains("thank") -> "You're welcome! Feel free to ask if you have more questions. Have a great day!"
            else -> "I'm sorry, I don't have specific info on that. Try asking about admissions, courses, placements, scholarships, or contact details."
        }
    }
}
