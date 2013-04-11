package com.widgetgecko.android.httpservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;

import com.chameleonlauncher.service.ChameleonWidgetRequest;
import com.chameleonlauncher.service.ChameleonWidgetService;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

@SuppressLint("DefaultLocale")
public class HttpWidgetService extends ChameleonWidgetService {

	private static AsyncHttpClient client = new AsyncHttpClient();

	@Override
	public void onWidgetIntent(ChameleonWidgetRequest request) {

		// Validate incoming request

		// Request is made up of four parts:
		// - HTTP Method (GET/POST)
		// - URL
		// - Data (optional)
		// - Data Type (optional)

		if (false == validateRequest(request)) {
			respondWithError(request, "Invalid request.");
		}
		
		JsonHttpResponseHandler handler = null;
		
		handler = new JsonHttpResponseHandler() {
			@Override
			public void onSuccess(JSONArray data) {
				
			}
		};
		
		if ("GET" == getRequestMethod(request)) {
			client.get(getRequestString(request, "url"), getParams(request), handler);
		}
		else if ("POST" == getRequestMethod(request)) {
			client.post(getRequestString(request, "url"), getParams(request), handler);
		}
	}

	private boolean validateRequest(ChameleonWidgetRequest request) {
		if (request.data == null) {
			return false;
		}

		if (!request.data.has("url")) {
			return false;
		}

		String method = getRequestMethod(request);
		if (!(method == "GET" || method == "POST")) {
			return false;
		}

		return true;
	}

	private String getRequestMethod(ChameleonWidgetRequest request) {
		String method = request.data.has("method") ? getRequestString(request,
				"method").toUpperCase() : "GET";
		return method;
	}

	private String getRequestString(ChameleonWidgetRequest request, String key) {
		if (false == request.data.has(key)) {
			return "";
		}
		try {
			return request.data.getString(key);
		} catch (JSONException e) {
			return "";
		}
	}

	protected RequestParams getParams(ChameleonWidgetRequest request) {
		RequestParams params = null;
		if (request.data.has("params")) {
			try {
				params = new RequestParams(request.data.getJSONObject("params"));
			} catch (JSONException e) {
			}
		}
		return params;
	}

	protected void respondWithError(ChameleonWidgetRequest request,
			String errorMessage) {
		JSONObject response_data = new JSONObject();
		try {
			response_data.put("error", errorMessage);
		} catch (JSONException e) {
		}
		respondTo(request, response_data);
	}
}
