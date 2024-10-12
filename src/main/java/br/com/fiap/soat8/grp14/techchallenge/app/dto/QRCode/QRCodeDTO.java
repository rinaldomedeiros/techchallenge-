package br.com.fiap.soat8.grp14.techchallenge.app.dto.QRCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QRCodeDTO {

	private String qrData;
	private String orderId;
	
}
