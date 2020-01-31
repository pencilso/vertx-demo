package io.javac.vertx.vertxdemo.vertx;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.javac.vertx.vertxdemo.model.respone.ResponeWrapper;
import io.javac.vertx.vertxdemo.utils.JsonUtils;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @author pencilso
 * @date 2020/1/24 4:28 下午
 */
@Slf4j
public class VertxRespone {

    private final RoutingContext routingContext;

    private VertxRespone(RoutingContext routingContext) {
    this.routingContext = routingContext;
}

    public static VertxRespone build(RoutingContext routingContext) {
        return new VertxRespone(routingContext);
    }


    public void respone(ResponeWrapper responeWrapper) {
        HttpServerResponse httpServerResponse = routingContext.response();
        httpServerResponse.putHeader("Content-Type", "text/json;charset=utf-8");
        try {
            // 转换为JSON 字符串
            httpServerResponse.end(JsonUtils.objectToJson(responeWrapper));
        } catch (JsonProcessingException e) {
            log.error("serialize object to json fail wrapper: [{}]", responeWrapper);
            e.printStackTrace();
        }
    }

    public void responeSuccess(Object data) {
        respone(new ResponeWrapper(0, data, "操作成功"));
    }

    public void responeState(boolean state) {
        if (state) {
            respone(ResponeWrapper.RESPONE_SUCCESS);
        } else {
            respone(ResponeWrapper.RESPONE_FAIL);
        }
    }
}