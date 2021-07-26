package com.ilyabuhlakou.mps.telegram.bot

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException


@Component
class Bot : TelegramLongPollingBot() {

    @Value("\${bot.username}")
    private lateinit var botUsername: String

    @Value("\${bot.token}")
    private lateinit var botToken: String

    override fun getBotToken(): String {
        return botToken
    }

    override fun getBotUsername(): String {
        return botUsername
    }

    override fun onUpdateReceived(update: Update?) {
        try {
            update?.apply {
                execute(
                    SendMessage(update.message.chatId.toString(), "Hi, girl")
                )
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}