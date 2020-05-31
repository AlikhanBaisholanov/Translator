package com.example.lab3.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.lab3.R
import com.example.lab3.message_samples.FavouriteMessageSample
import com.example.lab3.message_samples.MessageSample
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class SharedPreferencesConfig(private val context: Context) {
    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.shared_preferences),
        Context.MODE_PRIVATE
    )!!
    private val gson = Gson()
    private var jsonString = ""
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var type: Type
    private lateinit var responseMessage: MessageSample
    fun savingTranslatedMessages(list: MutableList<MessageSample>) {
        editor = sharedPreferences.edit()
        jsonString = gson.toJson(list)
        editor.putString(context.getString(R.string.saving_translated_messages), jsonString)
        editor.apply()
    }

    fun extractingTranslatedMessages(): MutableList<MessageSample> {
        jsonString = sharedPreferences.getString(
            context.getString(R.string.saving_translated_messages),
            DEFAULT_MESSAGE
        ).toString()
        type = object : TypeToken<MutableList<MessageSample>>() {}.type
        var messageList = gson.fromJson<MutableList<MessageSample>>(jsonString, type)
        if (messageList == null) {
            messageList = mutableListOf()
        }
        return messageList
    }

    fun savingKirLatMessages(list: MutableList<MessageSample>) {
        editor = sharedPreferences.edit()
        jsonString = gson.toJson(list)
        editor.putString(context.getString(R.string.kirlat_messages), jsonString)
        editor.apply()
    }

    fun extractingKirLatMessages(): MutableList<MessageSample> {
        jsonString = sharedPreferences.getString(
            context.getString(R.string.kirlat_messages),
            DEFAULT_MESSAGE
        ).toString()
        type = object : TypeToken<MutableList<MessageSample>>() {}.type
        var messageList = gson.fromJson<MutableList<MessageSample>>(jsonString, type)
        if (messageList == null) {
            messageList = mutableListOf()
        }
        return messageList
    }

    fun savingFavouriteMessages(list: MutableList<FavouriteMessageSample>) {
        editor = sharedPreferences.edit()
        jsonString = gson.toJson(list)
        editor.putString(context.getString(R.string.favourite_messages), jsonString)
        editor.apply()
    }

    fun extractingFavouriteMessages(): MutableList<FavouriteMessageSample> {
        jsonString = sharedPreferences.getString(
            context.getString(R.string.favourite_messages),
            DEFAULT_MESSAGE
        ).toString()
        type = object : TypeToken<MutableList<FavouriteMessageSample>>() {}.type
        var favouriteMessageList =
            gson.fromJson<MutableList<FavouriteMessageSample>>(jsonString, type)
        if (favouriteMessageList == null) {
            favouriteMessageList = mutableListOf()
        }
        return favouriteMessageList
    }

    fun savingFavouriteMessage(requestMessage: MessageSample, responseMessage: MessageSample) {
        editor = sharedPreferences.edit()
        val requestMessageString = requestMessage.messageString
        val responseMessageString = responseMessage.messageString
        val favouriteMessageSample =
            FavouriteMessageSample(requestMessageString, responseMessageString)
        jsonString = gson.toJson(favouriteMessageSample)
        editor.putString(context.getString(R.string.selected_message), jsonString)
        editor.apply()
    }

    fun extractingFavouriteMessage(): FavouriteMessageSample {
        val selectedMessage: FavouriteMessageSample
        if (sharedPreferences.contains(context.getString(R.string.selected_message))) {
            jsonString = sharedPreferences.getString(
                context.getString(R.string.selected_message),
                DEFAULT_MESSAGE
            ).toString()
            sharedPreferences.edit().remove(context.getString(R.string.selected_message)).apply()
            type = object : TypeToken<FavouriteMessageSample>() {}.type
            selectedMessage = gson.fromJson(jsonString, type)
        } else {
            selectedMessage = FavouriteMessageSample("", "")
        }
        return selectedMessage
    }
}