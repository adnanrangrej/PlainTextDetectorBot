import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.extensions.filters.Filter

private val BOT_TOKEN = System.getenv("BOT_TOKEN")
fun main() {
    val bot = bot {
        token = BOT_TOKEN

        dispatch {
            message(Filter.Text) {

                println("Received message: ${message.text}")
                val chatId = ChatId.fromId(message.chat.id)

                // Ignore bot messages
                if (message.from?.isBot == true) {
                    println("This message is from bot: ${message.from?.username}")
                    return@message
                }

                // Ignore private messages and channel messages
                val chat = message.chat
                when (chat.type) {
                    "private", "channel" -> {
                        println("This message is from private or channel: ${message.from?.username}")
                        return@message
                    }
                }

                // Check if sender is admin
                val admins = bot.getChatAdministrators(chatId).getOrNull()
                val isAdmin = admins?.any {
                    it.user.id == message.from?.id
                }

                // Ignore admin messages
                if (isAdmin == true) {
                    println("This message is from admin: ${message.from?.username}")
                    return@message
                }
                val text = message.text
                val doesContainUrl =
                    text?.contains(Regex("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"))
                if (doesContainUrl == true) {
                    println("This message contains a URL!")
                    return@message
                }
                bot.deleteMessage(chatId, message.messageId)
                println("Deleted message: Id: ${message.messageId} Text: ${message.text}")
            }
        }
    }

    bot.startPolling()
}