package java_practice.DI.core;

public class Container {
    public Object getInstance(Class clazz) throws Exception {
        // 受け取ったclass定義情報からインスタンスを生成
        Object obj = clazz.getConstructor().newInstance();

        return obj;
    }
}
