package br.com.fiap.soat8.grp14.techchallenge.app.services;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;

@Service
public class QRCodeService {

	private static final String ACCESS_TOKEN = "TEST-4145583959975611-100611-73e56e44ec44aabd9abe05dbf329c33b-200680136";
	private static final String idUsuario = "200680136";
	private static final String idPosExterno = "CAIXA01POS01";
	private static final String titulo = "Lanchonete Grupo 14";

    public String gerarQrCode(String nrPedido, List<ItemPedidoDTO> itens, double valorTotal) throws Exception {
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

		// Montar o JSON do payload
        String jsonPayload = new JSONObject()
            .put("external_reference", nrPedido)
            .put("title", titulo)
            .put("description", "Pedido " + nrPedido)
            .put("notification_url", "https://www.yourserver.com/notifications")
            .put("total_amount", valorTotal)
            .put("items", getJsonItens(itens))
            .put("cash_out", new JSONObject().put("amount", 0))
            .toString();

		OutputStream os = conn.getOutputStream();
		os.write(jsonPayload.getBytes());
		os.flush();

		if (conn.getResponseCode() != 201) {
			throw new RuntimeException("Erro na criação do QR Code: " + conn.getResponseCode());
		}

		Scanner scanner = new Scanner(conn.getInputStream(), "UTF-8");
		String jsonResponse = scanner.useDelimiter("\\Z").next();
		scanner.close();

		return getQrCode(jsonResponse);
	}

    
    private JSONArray getJsonItens(List<ItemPedidoDTO> itens) {
    	JSONArray jsonItems = new JSONArray();
    	for (ItemPedidoDTO item : itens) {
    	    JSONObject jsonItem = new JSONObject()
    	        .put("sku_number", item.getId().toString())
    	        .put("category", item.getProduto().getCategoriaProduto())
    	        .put("title", item.getProduto().getNome())
    	        .put("description", item.getProduto().getDescricao())
    	        .put("unit_price", item.getValorItem())
    	        .put("quantity", item.getQuantidade())
    	        .put("unit_measure", "unidade")
    	        .put("total_amount", item.getValorItem() * item.getQuantidade());

    	    jsonItems.put(jsonItem);
    	}
		return jsonItems;
    }

    private String getQrCode(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		return jsonObject.getString("qr_data");
	}

	private String getIdPedido(String jsonResponse) {
		JSONObject jsonObject = new JSONObject(jsonResponse);
		return jsonObject.getString("in_store_order_id");
	}
}
