package br.com.fiap.soat8.grp14.techchallenge.app.services;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.soat8.grp14.techchallenge.app.dto.QRCode.QRCodeDTO;
import br.com.fiap.soat8.grp14.techchallenge.app.dto.itempedido.ItemPedidoDTO;
import br.com.fiap.soat8.grp14.techchallenge.infra.config.MercadoPagoConfig;

@Service
public class QRCodeService {

    @Autowired
    private MercadoPagoConfig mercadoPagoConfig;

    public QRCodeDTO gerarQrCode(String idPedido, List<ItemPedidoDTO> itens, double valorTotal) throws Exception {
        String apiUrl = mercadoPagoConfig.getApiUrl();
        String accessToken = mercadoPagoConfig.getAccessToken();
        String idUsuario = mercadoPagoConfig.getIdUsuario();
        String idPosExterno = mercadoPagoConfig.getIdPosExterno();
        String titulo = mercadoPagoConfig.getTitulo();
    	
        StringBuilder urlTemp = new StringBuilder();
        urlTemp.append(apiUrl);
        urlTemp.append("/");
        urlTemp.append(idUsuario);
        urlTemp.append("/pos/");
        urlTemp.append(idPosExterno);
        urlTemp.append("/qrs");

        URL url = new URL(urlTemp.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonPayload = new JSONObject()
            .put("external_reference", idPedido)
            .put("title", titulo)
            .put("description", "Pedido " + idPedido)
            .put("notification_url", "https://www.yourserver.com/notifications") //TODO
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

    private QRCodeDTO getQrCode(String jsonResponse) {
    	JSONObject jsonObject = new JSONObject(jsonResponse);
    	String qrData = jsonObject.getString("qr_data");
    	String orderId = jsonObject.getString("in_store_order_id");
    	
		return new QRCodeDTO(qrData, orderId);
	}

}
