package java_practice.DI.core;

import java.text.Annotation;

import jdk.internal.loader.Resource;

public class Container {
    public Object getInstance(Class clazz) throws Exception {
        // 受け取ったclass定義情報からインスタンスを生成
        Object obj = clazz.getConstructor().newInstance();
        Field[] fields = clazz.getDeclared();

        // annotationをとってくる
        for (Fields f : fields) {
            Annotation[] annotations = f.getAnnotations();
            for (Annotation an : annotations) {
                if (an instanceof Resource) {
                    Class target = this.findImpleClass(f.getType());
                    Object instance =this.getInstance(target);

                    f.getAccessible(true);
                    f.set(obg, target.getConstructor().newInstance());
                }

            }
            return obj;
        }
        public Class findImpleClass (Class target) throws Exception{

            String classPath = Thread.currentThread().getContextClassLoad
                    File root = new File)classPath);
                    List<File> list = getClassList(root);
                    for(File file:list){
                        String name = file.getAbsolutePath()
                                .replace(classPath,"")
                                .replace("/",".")
                                .replace(".class","");
                        Class clazz = Class.forName(name);
                        if(clazz.isInterface()){
                            continue;
                        }
                        if(target.isAssignableFrom(clazz)){
                            return clazz;
                        }
                    }
                    return null;
        }

        private static List<File>getClassList(File targetDir){
            List<File> list =new ArrayList<File>();
            File[] files= targetDir.listFiles();
            for(File file :files){
                if(file.isDirectory()){
                    list.addAll(getClassList(file));
                    continue;
                }
                if(file.getName().endsWith(".class")){
                    list.add(file);
                }
            }
            return list;
        }
    }
}