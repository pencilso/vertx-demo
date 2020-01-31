package io.javac.vertx.vertxdemo.model.respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author pencilso
 * @date 2020/1/24 4:17 下午
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ResponeWrapper<V> {

    private int code;
    private V data;
    private String message;

    public static final ResponeWrapper<String> RESPONE_SUCCESS = new ResponeWrapper<>(0, null, "操作成功");
    public static final ResponeWrapper<String> RESPONE_FAIL = new ResponeWrapper<>(10001, null, "操作失败");
}
