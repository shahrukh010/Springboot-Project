package com.code.response;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.code.bot.Bot;
import com.code.bot.CallBackData;

public class Responder extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {

		String response = "I'm sorry, I haven't understood the message you sent😍";
//		String response = "Thanks 😍";
		String chatId = "";
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText(response);

		if (update.hasCallbackQuery() && update.getCallbackQuery().getData() != null
				&& !update.getCallbackQuery().getData().isEmpty()) {

			chatId = String.valueOf(update.getCallbackQuery().getMessage().getChatId());
			String callBackData = update.getCallbackQuery().getData();

			if (callBackData.equalsIgnoreCase(CallBackData.CD_YES.toString())) {

				LocalDateTime currentTime = LocalDateTime.now();
				sendMessage.setText(currentTime.toLocalTime().toString());
			}
			if (callBackData.equalsIgnoreCase(CallBackData.CD_Yes_totally.toString())) {
				sendMessage.setText("You're at the perfect place! 😄" + "\n" + "Before everything else" + "\n"
						+ ",please tell me your name. 🤗\n");
			}

			if (callBackData.equalsIgnoreCase(CallBackData.CD_NO.toString()))
				sendMessage.setText("Fine. thanks");
		}

		if (update.hasMessage() && update.getMessage().hasText()) {
			chatId = String.valueOf(update.getMessage().getChatId());
			String userMessage = update.getMessage().getText().trim();

			if (userMessage.equalsIgnoreCase("Hi")) {

				sendMessage.setText("Hi! Welcome to Parts for All. 😁" + "\n" + "We have got a huge collection" + "\n"

						+ "of used and fresh spare parts for" + "\n" + "your car." + "\n" + "\n"
						+ "So are you tired of looking" + "\n" + "around for car parts?" + "\n" + "\n"

						+ "Choose from below" + "\n");

				// create keyboard
				List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
				// create button
				List<InlineKeyboardButton> buttonRow = new ArrayList<>();
				// create yesbutton
				InlineKeyboardButton yesButton = new InlineKeyboardButton();

				yesButton.setText("✔️" + "Yes,totally!");
				yesButton.setCallbackData(CallBackData.CD_Yes_totally.toString());

				InlineKeyboardButton noThanksButton = new InlineKeyboardButton();
				noThanksButton.setText("➖" + "Not really.");
				noThanksButton.setCallbackData(CallBackData.CD_NOT_REALLY.toString());
				// add yesbutton to buttonRow
				buttonRow.add(yesButton);
				buttonRow.add(noThanksButton);
				// we add newly created button row that contain the yes button to the keyboard
				keyboard.add(buttonRow);

				InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
				inlineKeyboardMarkup.setKeyboard(keyboard);
				sendMessage.setReplyMarkup(inlineKeyboardMarkup);
			}

			if (userMessage.equalsIgnoreCase("Hello"))
				sendMessage.setText("How are you \uD83D\uDE00\"");

			if (userMessage.equalsIgnoreCase("How are you"))
				sendMessage.setText("I'm fine thanku you");

			if (userMessage.contains("time")) {

				sendMessage.setText("Would you like to know the current time?");

				// create keyboard
				List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
				// create button
				List<InlineKeyboardButton> buttonRow = new ArrayList<>();
				// create yesbutton
				InlineKeyboardButton yesButton = new InlineKeyboardButton();

				yesButton.setText("\uD83D\uDC4D\"");
				yesButton.setCallbackData(CallBackData.CD_YES.toString());

				InlineKeyboardButton noThanksButton = new InlineKeyboardButton();
				noThanksButton.setText("No Thanks.");
				noThanksButton.setCallbackData(CallBackData.CD_NO.toString());
				// add yesbutton to buttonRow
				buttonRow.add(yesButton);
				buttonRow.add(noThanksButton);
				// we add newly created button row that contain the yes button to the keyboard
				keyboard.add(buttonRow);

				InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
				inlineKeyboardMarkup.setKeyboard(keyboard);
				sendMessage.setReplyMarkup(inlineKeyboardMarkup);
			}

			if (userMessage.equalsIgnoreCase("/day")) {

				DayOfWeek todayDayOfTheWeek = LocalDateTime.now().getDayOfWeek();
				sendMessage.setText(todayDayOfTheWeek.toString());
			}

		}
		if (chatId.isEmpty()) {

			throw new IllegalStateException("That chat id couldn't be idnentified or found.");
		}

		sendMessage.setChatId(chatId);

		try {
			sendApiMethod(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

	public String customMessage() {

		return "So are you tired of looking" + "\n" + "around for car parts?";
	}

	@Override
	public String getBotUsername() {
		return Bot.USERNAME;

	}

	@Override
	public String getBotToken() {
		return Bot.BOT_TOKEN;
	}

}
