import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class QRCodeExample {

  private static final String ACCESS_TOKEN = "TEST-4145583959975611-100611-73e56e44ec44aabd9abe05dbf329c33b-200680136";

  public static void main(String[] args) {
    try {
      // 1. Criar um POS
      String posId = createPointOfSale();

      // 2. Gerar um QR Code Dinâmico associado ao POS
      if (posId != null) {
        generateQrCode(posId);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String createPointOfSale() throws Exception {
    URL url = new URL("https://api.mercadopago.com/pos");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setDoOutput(true);

    // Envio do payload para criação do POS
    String input = "{"
        + "\"name\":\"Point of Sale Test\","
        + "\"fixed_amount\":true,"
        + "\"category\":\"miscellaneous\","
        + "\"external_id\":\"POS_ID_123456\""
        + "}";

    OutputStream os = conn.getOutputStream();
    os.write(input.getBytes());
    os.flush();

    if (conn.getResponseCode() != 201) {
      throw new RuntimeException("Erro na criação do POS: " + conn.getResponseCode());
    }

    Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
    String jsonResponse = scanner.useDelimiter("\\Z").next();
    scanner.close();
    
    // Extração do POS_ID da resposta
    String posId = extractPosIdFromResponse(jsonResponse);
    System.out.println("POS ID: " + posId);

    return posId;
  }

  public static void generateQrCode(String posId) throws Exception {
    URL url = new URL("https://api.mercadopago.com/instore/orders/qr/seller/collectors/YOUR_USER_ID/pos/" + posId + "/qrs");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setDoOutput(true);

    // Envio do payload para gerar o QR Code
    String input = "{"
        + "\"external_reference\":\"REFERENCE_123456\","
        + "\"title\":\"Compra de exemplo\","
        + "\"description\":\"Pagamento via QRCode\","
        + "\"total_amount\":1000,"
        + "\"items\":["
        + "{\"sku_number\":\"123\",\"category\":\"miscellaneous\",\"title\":\"Produto 1\",\"description\":\"Descrição produto 1\",\"unit_price\":1000,\"quantity\":1}"
        + "],"
        + "\"notification_url\":\"https://www.your-notification-url.com\""
        + "}";

    OutputStream os = conn.getOutputStream();
    os.write(input.getBytes());
    os.flush();

    if (conn.getResponseCode() != 201) {
      throw new RuntimeException("Erro na criação do QR Code: " + conn.getResponseCode());
    }

    Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
    String jsonResponse = scanner.useDelimiter("\\Z").next();
    scanner.close();
    
    // Extração do QR Code da resposta
    String qrCodeUrl = extractQrCodeUrlFromResponse(jsonResponse);
    System.out.println("QR Code URL: " + qrCodeUrl);
  }

  // Métodos auxiliares para extração de dados da resposta JSON
  public static String extractPosIdFromResponse(String jsonResponse) {
    // Implementar a lógica para extrair o POS ID da resposta JSON
    return "POS_ID_EXTRAIDO";
  }

  public static String extractQrCodeUrlFromResponse(String jsonResponse) {
    // Implementar a lógica para extrair a URL do QR Code da resposta JSON
    return "URL_DO_QRCODE_EXTRAIDO";
  }
}
