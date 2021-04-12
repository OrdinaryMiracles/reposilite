package org.panda_lang.reposilite.resource;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;
import org.panda_lang.reposilite.utils.FilesUtils;

public class FrontendFileHandler implements Handler {

	@OpenApi(
			operationId = "getApp",
			summary = "Get frontend application",
			description = "Returns Vue.js application wrapped into one app.js file",
			tags = { "Resource" },
			responses = {
					@OpenApiResponse(status = "200", description = "Default response")
			}
	)
	@Override
	public void handle(Context context) {
		System.out.println(context.matchedPath());
		String path = context.matchedPath();
		String result = FilesUtils.getResource("/static" + path);
		context.result(result)
				.header("Content-Type", "application/javascript")
				.res.setCharacterEncoding("UTF-8");
	}
}
