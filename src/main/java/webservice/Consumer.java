package webservice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Consumer {

	public static void main(String[] args) {
		RandonService randonService = new RandonService();
		
		Randon proxy = randonService.getRandonPort();

		
		BindingProvider bp = (BindingProvider) proxy;
		
		Map<String, List <String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("admin"));
		
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		double next = proxy.next(50);
		
		System.out.println(next);
	}

}
