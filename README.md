# 🛡️ PlainTextDetectorBot
<p align="center">
  <img src="https://github.com/user-attachments/assets/4c74659a-703d-43d7-aec7-07d229a438d7" alt="PlainTextDetectorLogo" height="200"/>
</p>


A Telegram bot that automatically detects and deletes plain text messages from a group, keeping your chat clean and focused on media or links.

---

## 🚀 Features

- ✅ Deletes plain text messages without links or media
- ✅ Ignores messages from admins
- ✅ Supports photos, videos, documents, audio, stickers
- ✅ Runs continuously using polling
- ✅ Designed for media-focused or announcement groups

---

## 🛠️ How It Works

The bot:
- Scans every incoming message in the group
- Checks if the message has **no media** and **no links**
- If the user is **not an admin**, the message is deleted

---

## 📦 Project Structure

```
PlainTextDetectorBot/
├── build.gradle.kts
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
├── .gitignore
└── src/
    └── main/
        └── kotlin/
            └── Main.kt
```

## ⚙️ Environment Variables

| Variable   | Description                     |
|------------|---------------------------------|
| BOT_TOKEN  | Your Telegram Bot API token     |

Set your bot token like this before running:

```bash
export BOT_TOKEN=your_bot_token_here
```

---

## ▶️ How to Run

1. Clone the repo
   ```bash
   git clone https://github.com/adnanrangrej/PlainTextDetectorBot.git
   cd PlainTextDetectorBot
   ```

2. Give execute permission
   ```bash
   chmod +x gradlew
   ```

3. Set bot token
   ```bash
   export BOT_TOKEN=your_bot_token_here
   ```

4. Run the bot
   ```bash
   ./gradlew run
   ```

---

## 💡 Use Case

Perfect for:

- 📣 Channels or groups meant only for media announcements
- 🎥 Movie/Video sharing hubs
- 🔗 Link-based resource groups
- 🤖 Spam reduction in public groups
