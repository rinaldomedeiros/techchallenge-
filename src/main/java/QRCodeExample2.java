import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class QRCodeExample2 {

	private static final String ACCESS_TOKEN = "TEST-4145583959975611-100611-73e56e44ec44aabd9abe05dbf329c33b-200680136";
	private static final String idUsuario = "200680136";
	private static final String idPosExterno = "CAIXA01POS01";

	public static void main(String[] args) {
		try {

			// 2. Gerar um QR Code Dinâmico associado ao POS
			gerarQrCode();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void gerarQrCode() throws Exception {
		StringBuilder urlTemp = new StringBuilder();
		urlTemp.append("https://api.mercadopago.com/instore/orders/qr/seller/collectors/");
		urlTemp.append(idUsuario);
		urlTemp.append("/pos/");
		urlTemp.append(idPosExterno);
		urlTemp.append("/qrs");
		URL url = new URL(urlTemp.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);

		// Envio do payload para gerar o QR Code
		StringBuilder json = new StringBuilder();
		json.append("{\n");
		json.append("  \"external_reference\": \"PEDIDO001\",\n");
		json.append("  \"title\": \"Lanchonete TechChallenge\",\n");
		json.append("  \"description\": \"Pedido 001\",\n");
		json.append("  \"notification_url\": \"https://www.yourserver.com/notifications\",\n");
		json.append("  \"total_amount\": 40,\n");
		json.append("  \"items\": [\n");
		json.append("    {\n");
		json.append("      \"sku_number\": \"A123K9191938\",\n");
		json.append("      \"category\": \"Sanduiche\",\n");
		json.append("      \"title\": \"Hamburger\",\n");
		json.append("      \"description\": \"Hamburger \",\n");
		json.append("      \"unit_price\": 40,\n");
		json.append("      \"quantity\": 1,\n");
		json.append("      \"unit_measure\": \"unit\",\n");
		json.append("      \"total_amount\": 40\n");
		json.append("    }\n");
		json.append("  ],\n");
		json.append("  \"cash_out\": {\n");
		json.append("    \"amount\": 0\n");
		json.append("  }\n");
		json.append("}");

		OutputStream os = conn.getOutputStream();
		os.write(json.toString().getBytes());
		os.flush();

		if (conn.getResponseCode() != 201) {
			throw new RuntimeException("Erro na criação do QR Code: " + conn.getResponseCode());
		}

		Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
		String jsonResponse = scanner.useDelimiter("\\Z").next();
		scanner.close();

		// Extração do QR Code da resposta
		String qrCodeUrl = getQrCode(jsonResponse);
		String qrCodeIdPedido = getIdPedido(jsonResponse);
		System.out.println("QR Code URL: " + qrCodeUrl);
		System.out.println("QR Code Id Pedido: " + qrCodeIdPedido);
	}

	private static String getIdPedido(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		return jsonObject.getString("in_store_order_id");
	}

	private static String getQrCode(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		return jsonObject.getString("qr_data");
	}
}
