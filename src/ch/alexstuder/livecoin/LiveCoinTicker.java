package ch.alexstuder.livecoin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import ch.alexstuder.livecoin.model.LiveCoinJson;

public class LiveCoinTicker {
	public static void main(String[] args) {

		ArrayList<LiveCoinJson> coinList = new ArrayList<LiveCoinJson>();
		LiveCoinJson liveCoin = new LiveCoinJson();

		try {
			// URL queryUrl = new
			// URL("https://api.livecoin.net/exchange/order_book?currencyPair=LTC/BTC");
			URL queryUrl = new URL("https://api.livecoin.net//exchange/last_trades?currencyPair=CHSB/BTC");
			HttpURLConnection connection = (HttpURLConnection) queryUrl.openConnection();
			connection.setDoOutput(true);

			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			JsonParser parser = Json.createParser(rd);
			String key = null;
			String value = null;
			while (parser.hasNext()) {
				final Event event = parser.next();
				switch (event) {
				case KEY_NAME:
					key = parser.getString();
					
					// Add Coin Oject to List 
					if (key.contains("time")) {
						if (liveCoin.isSet()) {
							coinList.add(liveCoin);
							liveCoin = new LiveCoinJson();
						}
					}
					System.out.println("Key:"+key);
					break;
				case VALUE_STRING:
					String string = parser.getString();
					if (key.contains("type")) {
						liveCoin.setType(string);
					}
					System.out.println("string:"+string);
					break;
				case VALUE_NUMBER:
					BigDecimal number = parser.getBigDecimal();
					switch (key) {
					case "time":
						liveCoin.setTime(number);
						break;
					case "id":
						liveCoin.setId(number);
						break;
					case "price":
						liveCoin.setPrice(number);
						break;
					case "quantity":
						liveCoin.setQuantity(number);
						break;

					default:
						break;
					}
					System.out.println("number:"+number);
					break;
				case VALUE_TRUE:
					break;
				case VALUE_FALSE:
					break;
				default:
					break;
				}
			}

			parser.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
